package topy.project.modules.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

import static topy.project.common.Const.*;

@Getter
public class ChangeMemberPasswordRequest {

    @NotBlank(message = MEMBER_DTO_NO_CURRENT_PASSWORD)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_\\-+=~`\\[\\]{}|:;\"'<>,.?\\\\/])[A-Za-z\\d!@#$%^&*()_\\-+=~`\\[\\]{}|:;\"'<>,.?\\\\/]{8,20}$", message = MEMBER_DTO_WRONG_PASSWORD_RULE)
    private String currentPassword;

    @NotBlank(message = MEMBER_DTO_NO_NEW_PASSWORD)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_\\-+=~`\\[\\]{}|:;\"'<>,.?\\\\/])[A-Za-z\\d!@#$%^&*()_\\-+=~`\\[\\]{}|:;\"'<>,.?\\\\/]{8,20}$", message = MEMBER_DTO_WRONG_PASSWORD_RULE)
    private String newPassword;
}
