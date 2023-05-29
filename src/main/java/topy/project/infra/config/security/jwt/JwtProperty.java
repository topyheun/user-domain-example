package topy.project.infra.config.security.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ConfigurationProperties(prefix = "jwt")
@Component
public class JwtProperty {
    private String header;
    private String secretKey;
    private long accessTokenValidityTime;
}
