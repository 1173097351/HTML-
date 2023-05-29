package com.zhou.dao;

import com.zhou.pojo.ParcelInformation;
import com.zhou.pojo.UserAccount;
import com.zhou.pojo.UserInformation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //查询全部用户
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
