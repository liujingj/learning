package com.ljj.malllearning.component;

import com.ljj.malllearning.common.utils.JwtTokenUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 在用户名和密码校验之前添加的过滤器 如果有jwt的token 会自行根据token登录
 *
 * @author ljj
 * @date 2020/9/27
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //??
        String token = httpServletRequest.getHeader("token");
        if (token != null && token.startsWith("")) {
            String authToken = token.substring("".length());
            String userName = jwtTokenUtil.getUserNameFromToken(authToken);
            if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                //根据用户名查询用户信息
                //如果是当前登录人
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(null, null, null);
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
