package com.ztwo.yeb.dao;

import com.ztwo.yeb.YebApplication;
import com.ztwo.yeb.bean.Admin;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = YebApplication.class)
class AdminMapperTest {

    @Resource
    private AdminMapper adminMapper;

    @Test
    public void AdminTest() {
        List<Admin> admins = adminMapper.selectAll();
        for (Admin admin : admins) {
            System.out.println(admin);
        }
    }

}