package com.zhou.service.impl;

import com.zhou.dao.UserMapper;
import com.zhou.pojo.UserInformation;
import com.zhou.pojo.UserAccount;
import com.zhou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<UserAccount> queryListUser() {
        return userMapper.queryListUser();
    }

    @Override
    public UserAccount queryUser(String uaccount, String upassword) {
        return userMapper.queryUser(uaccount, upassword);
    }

    @Override
    public List<UserInformation> queryListUserInformation(String uid) {
        return userMapper.queryListUserInformation(uid);
    }

    @Override
    public UserInformation userInformation(String uid) {
        return userMapper.userInformation(uid);
    }

    @Override
    public int updateUser(Map<String, Object> map) {
        return userMapper.updateUser(map);
    }

}
