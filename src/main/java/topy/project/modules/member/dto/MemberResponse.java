package topy.project.modules.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponse {

    private String username;

    private String contact;

    @Builder
    public MemberResponse(String username, String contact) {
        this.username = username;
        this.contact = contact;
    }
}
