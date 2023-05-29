package topy.project.modules.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import topy.project.common.exception.BadRequestException;
import topy.project.infra.config.RedisUtil;
import topy.project.infra.mail.EmailMessage;
import topy.project.infra.mail.EmailService;
import topy.project.infra.mail.EmailTemplate;
import topy.project.modules.member.dto.MemberEmailVerificationRequest;
import topy.project.modules.member.dto.MemberSignUpRequest;

import java.util.UUID;

import static topy.project.common.Const.MEMBER_USED_ACCOUNT;
import static topy.project.infra.mail.EmailConst.EMAIL_SEND_AUTH_CODE_MESSAGE;
import static topy.project.infra.mail.EmailConst.EMAIL_VERIFICATION_EXPIRATION_TIME;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final RedisUtil redisUtil;
    private final EmailTemplate emailTemplate;
    private final EmailService emailService;

    @Transactional
    public void createMember(MemberSignUpRequest memberSignUpRequest) {
        if (memberRepository.existsByUsername(memberSignUpRequest.getUsername())) {
            throw new BadRequestException(MEMBER_USED_ACCOUNT);
        }

        Member member = Member.builder()
                .username(memberSignUpRequest.getUsername())
                .password(memberSignUpRequest.getPassword())
                .build();
        member.setEncodePassword(passwordEncoder.encode(member.getPassword()));
        memberRepository.save(member);
    }

    public void sendVerificationCode(MemberEmailVerificationRequest memberEmailVerificationRequest) {
        String authKey = createAuthKey();
        EmailMessage emailMessage = EmailMessage.builder()
                .to(memberEmailVerificationRequest.getReceiver())
                .subject(EMAIL_SEND_AUTH_CODE_MESSAGE)
                .message(emailTemplate.verifyAuthCodeMailTemplate(authKey))
                .build();
        emailService.send(emailMessage);
        redisUtil.setDataExpire(authKey, memberEmailVerificationRequest.getReceiver(), EMAIL_VERIFICATION_EXPIRATION_TIME);
    }

    private String createAuthKey() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid.substring(0, 8);
    }
}
