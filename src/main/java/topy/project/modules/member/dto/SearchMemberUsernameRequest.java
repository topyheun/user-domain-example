package topy.project.modules.member.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import static topy.project.common.Const.MEMBER_DTO_NO_CONTACT;

@Getter
@Setter
public class SearchMemberUsernameRequest {

    @NotNull(message = MEMBER_DTO_NO_CONTACT)
    private String contact;
}
