package com.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenFilter extends OncePerRequestFilter {
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token=extractTokenFromRequest(httpServletRequest);
        if(StringUtils.hasText(token) && jwtProvider.validateToken(token)){
            String userName=jwtProvider.getUserNameFromToken(token);
            UserDetails userDetails=userDetailsService.loadUserByUsername(userName);
            UsernamePasswordAuthenticationToken authentication=new UsernamePasswordAuthenticationToken(userDetails,null,
                    userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    private String extractTokenFromRequest(HttpServletRequest httpServletRequest) {
        String token=httpServletRequest.getHeader("Authorization");

        if(StringUtils.hasText(token) && token.startsWith("Bearer ")){
            return token.substring(7);
        }
        return token;
    }
}
