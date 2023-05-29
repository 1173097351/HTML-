package com.zhou.service;

import com.zhou.pojo.UserAccount;
import com.zhou.pojo.UserInformation;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserService {

    //查询全部Books,返回list集合
    List<UserAccount> queryListUser();

    //查询账号，密码
    UserAccount queryUser(@Param("uaccount") String uaccount, @Param("upassword") String upassword);

    //查询用户信息，农园信息
    List<UserInformation> queryListUserInformation(@Param("uid") String uid);

    //根据uid查询用户信息表
    UserInformation userInformation(@Param("uid") String uid);

    //修改用户信息、农园信息
    int updateUser(Map<String,Object> map);


}
