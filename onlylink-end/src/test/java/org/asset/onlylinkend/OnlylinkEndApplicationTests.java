package org.asset.onlylinkend;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.asset.onlylinkend.mapper.UserMapper;
import org.asset.onlylinkend.entity.dto.user;

@SpringBootTest
class OnlylinkEndApplicationTests {
@Resource
private UserMapper userMapper;

    @Test
    void test() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username","ww");
        user account = userMapper.selectOne(wrapper);
        System.out.println(account);

    }

}
