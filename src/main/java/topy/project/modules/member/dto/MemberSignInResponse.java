package topy.project.modules.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberSignInResponse {

    private String username;

    private String jwtToken;

    @Builder
    public MemberSignInResponse(String username, String jwtToken) {
        this.username = username;
        this.jwtToken = jwtToken;
    }
}
