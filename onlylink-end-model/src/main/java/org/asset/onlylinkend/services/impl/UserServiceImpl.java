package org.asset.onlylinkend.services.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.asset.onlylinkend.entity.dto.user;
import org.asset.onlylinkend.mapper.UserMapper;
import org.asset.onlylinkend.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, user> implements UserService {

    @Override
    public user findByUsername(String username) {
         return baseMapper.selectByUsername(username);
    }

    @Override
    public user findByEmail(String email) {
        return baseMapper.selectByEmail(email);
    }

    @Override
    public int insertUser(String username, String password,String email) {
        user user = new user();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        return baseMapper.insert(user);
    }




    @Override
    public boolean isUser(String username) {

        return true;
    }
}
