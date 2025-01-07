package com.airbnb.airbnb.configuration;




import com.airbnb.airbnb.entity.Users;
import com.airbnb.airbnb.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

public class WebFilter extends OncePerRequestFilter {

    @Autowired
    JwtService jwtService;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return "OPTIONS".equalsIgnoreCase(request.getMethod());
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) {
        try {
            String token = httpServletRequest.getHeader("Authorization").substring(7);
            String username = jwtService.extractUsername(token);
            Users user = new Users();
            user.setUserName(username);
            boolean isValidRequest = jwtService.isTokenValid(token, user);
            if (!isValidRequest) {
                return;
            }
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } catch (Exception e) {
            throw new RuntimeException("JWT validation failed", e);
        }
    }
}

