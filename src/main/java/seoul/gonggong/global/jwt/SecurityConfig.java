package seoul.gonggong.global.jwt;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import seoul.gonggong.global.error.exception.InvalidException;

import static seoul.gonggong.global.error.status.ErrorStatus.INVALID_OAUTH;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final String[] securityAllowArray = {
            "/**"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        try {
            httpSecurity
                    .csrf(csrf -> csrf.disable())
                    .formLogin(formLogin -> formLogin.disable())
                    .httpBasic(httpBasic -> httpBasic.disable())
                    .oauth2Login(Customizer.withDefaults())
                    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authorizeHttpRequests(auth -> auth.requestMatchers(securityAllowArray).permitAll()
                            .anyRequest().authenticated());

            return httpSecurity.build();
        } catch (Exception e) {
            throw new InvalidException(INVALID_OAUTH);
        }
    }
}
