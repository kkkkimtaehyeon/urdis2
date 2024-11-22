package com.stroygen.urdis2.common.config;

import com.stroygen.urdis2.common.handler.OAuth2AuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

//    @Value("${spring.security.oauth2.client.registration.kakao.client-id}")
//    private String clientId;
//
//    @Value("${spring.security.oauth2.client.registration.kakao.client-secret}")
//    private String clientSecret;
//
//    @Value("${spring.security.oauth2.client.registration.kakao.redirect-uri}")
//    private String redirectUri;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(requests -> requests
                .anyRequest().permitAll()
        );
//        http.oauth2Login(oauthLogin -> oauthLogin
//                .loginPage("/login")
//                .successHandler(new OAuth2AuthenticationSuccessHandler())
//        );

        return http.build();
    }

//    @Bean
//    public ClientRegistrationRepository clientRegistrationRepository() {
//        // Register the Kakao client configuration in the in-memory repository
//        return new InMemoryClientRegistrationRepository(kakaoClientRegistration());
//    }
//
//    private ClientRegistration kakaoClientRegistration() {
//        return ClientRegistration.withRegistrationId("kakao")
//                .clientId("56fa105d4e79219dc0a0f22fca878e39")
//                .clientSecret("4rveTx2itzdlBYDEdGlqZxQ7x53GGO9G")
//                .clientName("Kakao")
//                .redirectUri("http://locahost:8080/login/oauth2/code/kakao")
//                .authorizationUri("https://kauth.kakao.com/oauth/authorize")
//                .tokenUri("https://kauth.kakao.com/oauth/token")
//                .userInfoUri("https://kapi.kakao.com/v2/user/me")
//                .userNameAttributeName("id")
//                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                .scope("profile_nickname", "account_email")
//                .build();
//    }
}