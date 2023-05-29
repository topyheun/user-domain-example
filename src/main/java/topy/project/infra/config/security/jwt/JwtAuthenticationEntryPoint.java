package topy.project.infra.config.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static topy.project.common.Const.JWT_UNAUTHENTICATED_USER;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        sendErrorResponse(response, JWT_UNAUTHENTICATED_USER);
    }

    private void sendErrorResponse(HttpServletResponse response, String message) throws IOException {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(message, HttpStatus.FORBIDDEN);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new ObjectMapper().writeValueAsString(responseEntity));
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }
}
