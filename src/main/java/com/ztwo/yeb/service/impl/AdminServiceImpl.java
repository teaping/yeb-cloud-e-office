package com.ztwo.yeb.service.impl;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.ztwo.yeb.bean.Admin;
import com.ztwo.yeb.common.utils.JwtUtil;
import com.ztwo.yeb.common.vo.ResultCode;
import com.ztwo.yeb.common.vo.ResultVO;
import com.ztwo.yeb.dao.AdminMapper;
import com.ztwo.yeb.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.util.StringUtil;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;

/**
 * @Author ZTwo
 * @Date 2021/9/12 8:43
 */
@Service
public class AdminServiceImpl implements AdminService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private AdminMapper adminMapper;
    @Resource
    private UserDetailsService userDetailsService;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private DefaultKaptcha defaultKaptcha;
    @Resource
    private JwtUtil jwtUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /**
     * admin登陆
     *
     * @param username
     * @param password
     * @param code
     * @param request
     * @return [java.lang.String, java.lang.String, javax.servlet.http.HttpServletRequest]
     */
    @Override
    public ResultVO login(String username, String password, String code, HttpServletRequest request) {
        //校验验证码
        String captcha = (String) request.getSession().getAttribute("captcha");
        if (StringUtil.isEmpty(code) || !captcha.equalsIgnoreCase(code)) {
            System.out.println(ResultVO.error(ResultCode.CAPTCHA_ERROR).toString());
            return ResultVO.error(ResultCode.CAPTCHA_ERROR);
        }
        logger.warn("username:{}, password:{}, code:{}", username, password, code);
        //登陆判断
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        //密码错误
        if (null == userDetails || !passwordEncoder.matches(password, userDetails.getPassword())) {
            return ResultVO.error(ResultCode.LOGIN_ERROR);
        }
        //账号禁用
        if (!userDetails.isEnabled()) {
            return ResultVO.error(ResultCode.UNAUTHORIZED);
        }
        //更新security登陆用户对象
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //生成token
        String token = jwtUtil.generateToken(userDetails);
        HashMap<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("tokenHead", tokenHead);
        return ResultVO.success(map);
    }

    /**
     * 获取登陆对象信息
     *
     * @param principal
     * @return [java.security.Principal]
     */
    @Override
    public ResultVO getAdminInfo(Principal principal) {
        if (null == principal) {
            return null;
        } else {
            String username = principal.getName();
            Admin admin = getAdminByUsername(username);
            admin.setPassword(null);
            return ResultVO.success(admin);
        }
    }

    /**
     * 通过username查询Admin对象
     *
     * @param username
     * @return [java.lang.String]
     */
    @Override
    public Admin getAdminByUsername(String username) {
        return adminMapper.selectAdmin(username, true);
    }

    /**
     * 生成和响应校验码
     *
     * @param request
     * @param response
     * @return [javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse]
     */
    @Override
    public void createCaptcha(HttpServletRequest request, HttpServletResponse response) {
        //设置页面不缓存
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        //设置response输出类型为image/jpeg类型
        response.setContentType("image/jpeg");
        //----------------------生成验证码begin---------------------
        //获取校验码内容
        String text = defaultKaptcha.createText();
        //校验码放入session
        request.getSession().setAttribute("captcha", text);
        //根据校验码内容生成图形校验码
        BufferedImage image = defaultKaptcha.createImage(text);
        //输出校验码图片
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            ImageIO.write(image, "jpg", out);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
