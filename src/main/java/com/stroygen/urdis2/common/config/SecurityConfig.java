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
                .requestMatchers("/").permitAll()
                .requestMatchers("/login", "/oauth2/authorization/kakao").permitAll()
                .anyRequest().permitAll()
//                .anyRequest().authenticated()
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


//
//@Configuration
//public class SecurityConfig {
//
//    private final JwtTokenProvider jwtTokenProvider;
//
//    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
//        this.jwtTokenProvider = jwtTokenProvider;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션 사용 안 함
//                .and()
//                .authorizeRequests()
//                .antMatchers("/login", "/refresh-token").permitAll() // 인증 필요 없는 경로
//                .anyRequest().authenticated()
//                .and()
//                .addFilter(new JwtAuthenticationFilter(jwtTokenProvider)); // JWT 필터 추가
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}


//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/auth")
//public class AuthController {
//
//    private final JwtTokenProvider jwtTokenProvider;
//
//    public AuthController(JwtTokenProvider jwtTokenProvider) {
//        this.jwtTokenProvider = jwtTokenProvider;
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
//        // 사용자 인증 로직 (생략: DB 조회 등)
//
//        // 성공 시 액세스 토큰과 리프레시 토큰 발급
//        String accessToken = jwtTokenProvider.createAccessToken(loginRequest.getUsername());
//        String refreshToken = jwtTokenProvider.createRefreshToken(loginRequest.getUsername());
//
//        return ResponseEntity.ok(new TokenResponse(accessToken, refreshToken));
//    }
//
//    @PostMapping("/refresh-token")
//    public ResponseEntity<?> refreshToken(@RequestBody TokenRequest tokenRequest) {
//        // 리프레시 토큰 검증 및 액세스 토큰 재발급
//        if (jwtTokenProvider.validateToken(tokenRequest.getRefreshToken())) {
//            String username = jwtTokenProvider.getUsernameFromToken(tokenRequest.getRefreshToken());
//            String newAccessToken = jwtTokenProvider.createAccessToken(username);
//            return ResponseEntity.ok(new TokenResponse(newAccessToken, tokenRequest.getRefreshToken()));
//        }
//        return ResponseEntity.status(401).body("Invalid Refresh Token");
//    }
//}