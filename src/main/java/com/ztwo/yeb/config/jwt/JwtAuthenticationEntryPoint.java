package com.ztwo.yeb.config.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ztwo.yeb.common.vo.ResultCode;
import com.ztwo.yeb.common.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 当未登录或者token失效自定义的返回结果
 *
 * @Author ZTwo
 * @Date 2021/9/12 10:06
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        //验证为未登录状态会进入此方法，认证错误
        logger.warn("认证失败：{}", authException.getMessage());
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; character=utf-8");
        PrintWriter out = response.getWriter();
        out.write(new ObjectMapper().writeValueAsString(ResultVO.error(ResultCode.NO_LOGIN)));
        out.flush();
        out.close();
    }
}
