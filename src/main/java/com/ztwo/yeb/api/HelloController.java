package com.ztwo.yeb.api;

import com.ztwo.yeb.bean.Admin;
import com.ztwo.yeb.common.vo.ResultVO;
import com.ztwo.yeb.dao.AdminMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 测试接口
 *
 * @Author ZTwo
 * @Date 2021/9/12 10:42
 */
@RestController
@CrossOrigin
public class HelloController {

    @Resource
    private AdminMapper adminMapper;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResultVO hello() {
        List<Admin> admins = adminMapper.selectAll();
        return ResultVO.success(admins);
    }
}
