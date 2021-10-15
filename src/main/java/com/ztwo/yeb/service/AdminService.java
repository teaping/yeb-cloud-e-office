package com.ztwo.yeb.service;

import com.ztwo.yeb.bean.Admin;
import com.ztwo.yeb.common.vo.ResultVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

/**
 * @Description
 * @Author ZTwo
 * @Date 2021/9/12 8:42
 */
public interface AdminService {

    /**
     * admin登陆
     * 登陆成功返回token
     *
     * @param username
     * @param password
     * @param code
     * @param request
     * @return [java.lang.String, java.lang.String, javax.servlet.http.HttpServletRequest]
     */
    ResultVO login(String username, String password, String code, HttpServletRequest request);

    /**
     * 登陆成功获取用户信息
     *
     * @param principal
     * @return [java.security.Principal]
     */
    ResultVO getAdminInfo(Principal principal);

    /**
     * 根据username查询用户
     *
     * @param username
     * @return [java.lang.String]
     */
    Admin getAdminByUsername(String username);

    /**
     * 生成和响应校验码
     *
     * @param request
     * @param response
     * @return [javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse]
     */
    void createCaptcha(HttpServletRequest request, HttpServletResponse response);

}
