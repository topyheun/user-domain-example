package topy.project.modules.member.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import static topy.project.common.Const.MEMBER_DTO_NO_CONTACT;
import static topy.project.common.Const.MEMBER_DTO_NO_USERNAME;

@Getter
@Setter
public class SearchMemberPasswordRequest {

    @NotNull(message = MEMBER_DTO_NO_USERNAME)
    private String username;

    @NotNull(message = MEMBER_DTO_NO_CONTACT)
    private String contact;
}
