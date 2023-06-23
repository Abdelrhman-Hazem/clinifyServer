package gov.iti.jets.clinify.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Value("${server-Authorization.url}")
    private String AuthorizationServer;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.oauth2ResourceServer(oauth ->
                oauth.opaqueToken(op -> op
                        .introspectionUri(AuthorizationServer + "/oauth2/introspect")
                        .introspectionClientCredentials("iti-client", "iti-secret")
                )
        );

        http.authorizeHttpRequests(auth -> {
            auth.anyRequest().authenticated();
        });

        return http.build();
    }
}
