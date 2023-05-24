package topy.project.modules.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import topy.project.common.exception.BadRequestException;
import topy.project.modules.member.dto.MemberSignUpRequest;

import static topy.project.common.Const.MEMBER_USED_ACCOUNT;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

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
}
