package com.ztwo.yeb.api;

import com.ztwo.yeb.bean.AdminLogin;
import com.ztwo.yeb.common.vo.ResultVO;
import com.ztwo.yeb.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

/**
 * @Author ZTwo
 * @Date 2021/9/16 19:39
 */
@RestController
@Api(tags = "登陆管理")
public class LoginController {

    @Resource
    private AdminService adminService;

    @ApiOperation(value = "登陆")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultVO login(@RequestBody AdminLogin adminLogin, HttpServletRequest request) {
        return adminService.login(adminLogin.getUsername(), adminLogin.getPassword(), adminLogin.getCode(), request);
    }

    @ApiOperation(value = "获取登陆用户信息")
    @RequestMapping(value = "/loginInfo", method = RequestMethod.POST)
    public ResultVO loginInfo(Principal principal) {
        return adminService.getAdminInfo(principal);
    }

    @ApiOperation(value = "登出")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResultVO logout() {
        return ResultVO.success();
    }

    @ApiOperation(value = "生成登陆校验码")
    @RequestMapping(value = "/captcha", method = RequestMethod.GET, produces = "image/jpeg")
    public void captcha(HttpServletRequest request, HttpServletResponse response) {
        adminService.createCaptcha(request, response);
    }

}
