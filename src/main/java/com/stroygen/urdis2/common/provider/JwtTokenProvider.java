//package com.stroygen.urdis2.common.provider;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import jakarta.annotation.PostConstruct;
//
//import java.security.Key;
//import java.util.Date;
//
//public class JwtTokenProvider {
//    private final String SECRET_KEY = "your-secret-key"; // 반드시 환경 변수로 관리!
//    private final long ACCESS_TOKEN_EXPIRATION = 1000 * 60 * 15; // 15분
//    private final long REFRESH_TOKEN_EXPIRATION = 1000 * 60 * 60 * 24 * 7; // 7일
//    private Key key;
//
//    @PostConstruct
//    public void init() {
//        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
//        this.key = Keys.hmacShaKeyFor(keyBytes);
//    }
//
//    public String createAccessToken(String id, String email, String nickName) {
//        return Jwts.builder()
//                .claim("id", id)
//                .claim("email", email)
//                .claim("nickname", nickName)
//                .issuedAt(new Date())
//                .expiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRATION))
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//    }
//
//    public String createRefreshToken(String id, String email, String nickName) {
//        return Jwts.builder()
//                .claim("id", id)
//                .claim("email", email)
//                .claim("nickname", nickName)
//                .issuedAt(new Date())
//                .expiration(new Date(System.currentTimeMillis() + REFRESH_TOKEN_EXPIRATION))
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//    }
//
//    public String getUsernameFromJWT(String token) {
//        return Jwts.parser()
//                .verifyWith(key)    // 새로운 방식
//                .build()
//                .parseSignedClaims(token)  // 새로운 방식
//                .getPayload()
//                .getSubject();
//    }
//
//
//3. JWT 필터 작성
//
//Spring Security에서 요청을 가로채 JWT를 검증하는 필터를 작성합니다.
//}
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    private final JwtTokenProvider jwtTokenProvider;
//
//    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
//        this.jwtTokenProvider = jwtTokenProvider;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//            throws ServletException, IOException {
//        String token = resolveToken(request);
//
//        if (token != null && jwtTokenProvider.validateToken(token)) {
//            String username = jwtTokenProvider.getUsernameFromToken(token);
//            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
//                    username, null, null); // 권한 정보를 추가할 수도 있음
//            SecurityContextHolder.getContext().setAuthentication(auth);
//        }
//
//        chain.doFilter(request, response);
//    }
//
//    private String resolveToken(HttpServletRequest request) {
//        String bearerToken = request.getHeader("Authorization");
//        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
//            return bearerToken.substring(7);
//        }
//        return null;
//    }
//}