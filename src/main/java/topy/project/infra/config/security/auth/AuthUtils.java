package topy.project.infra.config.security.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import topy.project.common.exception.BadRequestException;

import static topy.project.common.Const.JWT_WITHOUT_ACCESS;

public class AuthUtils {

    public static void checkJwtToken(String username) {
        if (!getAuthenticationPrincipalUsername().equals(username)) {
            throw new BadRequestException(JWT_WITHOUT_ACCESS);
        }
    }

    private static String getAuthenticationPrincipalUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        return ((UserDetails) principal).getUsername();
    }
}
