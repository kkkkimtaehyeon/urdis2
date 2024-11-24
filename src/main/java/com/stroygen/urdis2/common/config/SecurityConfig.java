package com.stroygen.urdis2.common.config;

import com.stroygen.urdis2.service.authentication.AuthService;
import com.stroygen.urdis2.service.authentication.CustomOAuth2UserService;
import com.stroygen.urdis2.common.handler.CustomLogoutHandler;
import com.stroygen.urdis2.common.handler.OAuth2AuthenticationSuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {
    private final CustomOAuth2UserService customOAuth2UserService;
    private final AuthService authService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(requests -> requests
                .anyRequest().permitAll()
        );
        http.oauth2Login(oauthLogin -> oauthLogin
                .loginPage("/login")
                .userInfoEndpoint(userInfo -> userInfo.userService(customOAuth2UserService))
                .successHandler(new OAuth2AuthenticationSuccessHandler(authService))
        );
        http.logout(logout -> logout
                .addLogoutHandler(new CustomLogoutHandler(authService))
        );

        return http.build();
    }
}