package topy.project.modules.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class MemberSignUpRequest {

    @NotBlank(message = "아이디를 입력해주세요.")
    private String username;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_\\-+=~`\\[\\]{}|:;\"'<>,.?\\\\/])[A-Za-z\\d!@#$%^&*()_\\-+=~`\\[\\]{}|:;\"'<>,.?\\\\/]{8,20}$", message = "숫자, 대문자, 소문자, 특수문자를 포함하여 8 ~ 20자리의 비밀번호를 입력해주세요.")
    private String password;
}
