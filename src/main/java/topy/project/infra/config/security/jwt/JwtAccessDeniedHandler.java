package topy.project.infra.config.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static topy.project.common.Const.JWT_WITHOUT_ACCESS;

@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        sendErrorResponse(response, JWT_WITHOUT_ACCESS);
    }

    private void sendErrorResponse(HttpServletResponse response, String message) throws IOException {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(message, HttpStatus.FORBIDDEN);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new ObjectMapper().writeValueAsString(responseEntity));
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }
}
