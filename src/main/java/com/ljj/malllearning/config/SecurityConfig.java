package com.ljj.malllearning.config;

import com.ljj.malllearning.component.JwtAuthenticationTokenFilter;
import com.ljj.malllearning.component.RestAuthenticationEntryPoint;
import com.ljj.malllearning.component.RestfulAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * springSecurity配置
 *
 * @author ljj
 * @date 2020/9/27
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    /**
     * 配置userDetailsService passwordEncoder
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
        super.configure(auth);
    }

    /**
     * 根据用户名获取用户信息 需要自行实现
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return userName -> {
            //校验逻辑 获取登录用户信息
            return null;
        };
    }

    /**
     * 密码进行编码及比对
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置需要拦截的路径 jwt过滤器 及 出异常后的处理器
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //复杂的跨域请求会先进行一次options请求进行预检
        http.csrf().disable()//由于使用的是jwt 不需要csrf
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //使用jwt 不使用session
                .and().authorizeRequests().antMatchers(HttpMethod.GET, "/", "/.html", "/**/html", "/**/js", "/**/css")//允许对于静态资源的无授权访问
                .permitAll()
                .antMatchers("/admin/login", "/admin/register")//登录注册允许匿名访问
                .permitAll()
                .antMatchers(HttpMethod.OPTIONS)//跨域请求会先进行一个option请求
                .permitAll()
//                .antMatchers("/")//测试时全部运行访问
//                .permitAll()
                .anyRequest()//除上面之外的任何请求 都需要鉴权认证
                .authenticated();
        //禁用缓存
        http.headers().cacheControl();
        //添加jwt filter
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        http.exceptionHandling().accessDeniedHandler(restfulAccessDeniedHandler).authenticationEntryPoint(restAuthenticationEntryPoint);
    }

//    @Bean
//    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
//        return new JwtAuthenticationTokenFilter();
//    }

    //cors跨域资源共享 当一个域名访问另一个不同域名或同域名不同端口的资源时 就会发出跨域请求 如果此时另一个资源不允许其进行跨域资源访问 那么访问的这个资源就会遇到跨域问题

}
