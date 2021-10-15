package com.ztwo.yeb.common;

import com.ztwo.yeb.YebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author ZTwo
 * @Date 2021/9/16 16:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = YebApplication.class)
public class BCrytTest {

    @Test
    public void encoding() {
        //用户密码
        String password = "123";
        //密码加密
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        //加密
        String newPassword = passwordEncoder.encode(password);
        System.out.println("加密密码为："+newPassword);
    }

}
