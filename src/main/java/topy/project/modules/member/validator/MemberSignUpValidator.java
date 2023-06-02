package topy.project.modules.member.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import topy.project.common.exception.BadRequestException;
import topy.project.modules.member.MemberRepository;
import topy.project.modules.member.dto.MemberSignUpRequest;

import java.util.regex.Pattern;

import static topy.project.common.Const.*;

@Component
@RequiredArgsConstructor
public class MemberSignUpValidator implements Validator {

    private final MemberRepository memberRepository;

    private final Pattern emailValidPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(MemberSignUpRequest.class);
    }

    @Override
    public void validate(Object object, Errors errors) {
        MemberSignUpRequest memberSignUpRequest = (MemberSignUpRequest) object;

        if (!emailValidPattern.matcher(memberSignUpRequest.getUsername()).matches()) {
            throw new BadRequestException(MEMBER_INVALID_EMAIL_FORMAT);
        }

        if (memberRepository.existsByUsername(memberSignUpRequest.getUsername())) {
            throw new BadRequestException(MEMBER_USED_ACCOUNT);
        }

        if (memberRepository.existsByContact(memberSignUpRequest.getContact())) {
            throw new BadRequestException(MEMBER_USED_CONTACT);
        }
    }
}
