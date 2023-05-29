package topy.project.modules.member.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

import static topy.project.common.Const.*;

@Getter
public class MemberSignInRequest {

    @Email
    @NotBlank(message = MEMBER_DTO_NO_USERNAME)
    private String username;

    @NotBlank(message = MEMBER_DTO_NO_PASSWORD)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_\\-+=~`\\[\\]{}|:;\"'<>,.?\\\\/])[A-Za-z\\d!@#$%^&*()_\\-+=~`\\[\\]{}|:;\"'<>,.?\\\\/]{8,20}$", message = MEMBER_DTO_WRONG_PASSWORD_RULE)
    private String password;
}
