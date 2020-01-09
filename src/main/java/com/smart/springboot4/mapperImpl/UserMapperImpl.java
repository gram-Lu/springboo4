package com.smart.springboot4.mapperImpl;

import com.smart.springboot4.mapper.UserMapper;
import com.smart.springboot4.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userMapperImpl")
public class UserMapperImpl implements UserMapper {
    @Autowired
    UserMapper userMapper;
    @Override
    public void insert(User user) {
        System.out.println("进入Service层" );
        userMapper.insert(user);
    }
}
