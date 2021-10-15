package com.ztwo.yeb.config;

import com.ztwo.yeb.config.jwt.JwtAuthenticationEntryPoint;
import com.ztwo.yeb.config.jwt.JwtAuthenticationTokenFilter;
import com.ztwo.yeb.config.jwt.RestAuthenticationAccessDeniedHandler;
import com.ztwo.yeb.service.AdminService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * security配置类
 *
 * @Author ZTwo
 * @Date 2021/9/12 9:26
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private AdminService adminService;
    @Resource
    private RestAuthenticationAccessDeniedHandler restAuthenticationAccessDeniedHandler;
    @Resource
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                //基于token，不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //开启认证
                .authorizeRequests()
                //其它进行拦截认证
                .anyRequest().authenticated()
                .and()
                //禁用缓存
                .headers().cacheControl();
        //添加jwt登陆过滤器
        http.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //添加自定义未授权和未登录返回结果
        http.exceptionHandling()
                .accessDeniedHandler(restAuthenticationAccessDeniedHandler)
                .authenticationEntryPoint(jwtAuthenticationEntryPoint);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/login",
                "/logout",
                "/css/**",
                "js/**",
                "/index.html",
                "/doc.html",
                "favicon.ico",
                "/webjars/**",
                "/swagger-resources/**",
                "/v2/api-docs/**",
                "/captcha"
        );
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        return username -> {
            return adminService.getAdminByUsername(username);
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }


}
