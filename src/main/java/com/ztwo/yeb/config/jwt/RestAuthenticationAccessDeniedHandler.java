package com.ztwo.yeb.config.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ztwo.yeb.common.vo.ResultCode;
import com.ztwo.yeb.common.vo.ResultVO;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 当前访问接口没有权限，自定义返回结果
 *
 * @Author ZTwo
 * @Date 2021/9/12 10:13
 */
@Component
public class RestAuthenticationAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        //登陆状态下，权限不足执行方法
        System.out.println("权限不足:" + e.getMessage());
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(new ObjectMapper().writeValueAsString(ResultVO.error(ResultCode.FORBIDDEN)));
        out.flush();
        out.close();
    }
}
