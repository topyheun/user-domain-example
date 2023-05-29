package topy.project.modules.member.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import static topy.project.common.Const.MEMBER_DTO_NO_RECEIVER;

@Getter
public class MemberEmailVerificationRequest {

    @NotBlank(message = MEMBER_DTO_NO_RECEIVER)
    private String receiver;
}
