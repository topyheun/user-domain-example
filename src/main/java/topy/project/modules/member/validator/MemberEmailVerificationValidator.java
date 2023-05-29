package topy.project.modules.member.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import topy.project.common.exception.BadRequestException;
import topy.project.modules.member.MemberRepository;
import topy.project.modules.member.dto.MemberEmailVerificationRequest;

import java.util.regex.Pattern;

import static topy.project.common.Const.MEMBER_INVALID_EMAIL_FORMAT;
import static topy.project.common.Const.MEMBER_USED_ACCOUNT;

@Component
@RequiredArgsConstructor
public class MemberEmailVerificationValidator implements Validator {

    private final MemberRepository memberRepository;

    private final Pattern emailValidPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(MemberEmailVerificationRequest.class);
    }

    @Override
    public void validate(Object object, Errors errors) {
        MemberEmailVerificationRequest memberEmailVerificationRequest = (MemberEmailVerificationRequest) object;

        if (!emailValidPattern.matcher(memberEmailVerificationRequest.getReceiver()).matches()) {
            throw new BadRequestException(MEMBER_INVALID_EMAIL_FORMAT);
        }

        if (memberRepository.existsByUsername(memberEmailVerificationRequest.getReceiver())) {
            throw new BadRequestException(MEMBER_USED_ACCOUNT);
        }
    }
}
