package seoul.gonggong.global.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;
import seoul.gonggong.global.jwt.*;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtTokenProvider jwtTokenProvider;
    private final CorsFilter corsFilter;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // CSRF 설정 Disable
        http
                .csrf(
                        (csrfConfigurer) -> csrfConfigurer.disable()
                )

                .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)

                .exceptionHandling((exceptionConfig)->
                        exceptionConfig.authenticationEntryPoint(jwtAuthenticationEntryPoint)
                                .accessDeniedHandler(jwtAccessDeniedHandler) // exception handling 할 때 만든 클래스를 추가
                )

                .headers((headersConfig) ->
                        headersConfig.frameOptions(frameOptionsConfig ->
                                frameOptionsConfig.sameOrigin()
                        )
                )

                .sessionManagement((session)-> session.sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS
                ))

                .authorizeHttpRequests((request)->request
                        .requestMatchers("/auth/**")
                        .permitAll()
                        .anyRequest().authenticated()   // 나머지 API 는 전부 인증 필요
                )

                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
                        UsernamePasswordAuthenticationFilter.class); // JwtAuthenticatinoFilter 를 addFilterBefore 로 등록했던 JwtSecurityConfig 클래스를 적용
        return http.build();
    }
}
