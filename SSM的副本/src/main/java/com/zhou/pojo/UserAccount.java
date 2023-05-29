package com.zhou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
//用户账号
public class UserAccount {
    private String uid;     //用户编号
    private String unick_name;      //用户昵称
    private String uaccount;        //用户账号
    private String upassword;       //用户密码
    private int role_flag;      //用户角色标志
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date update_time;       //更新日期
    private int status;     //用户状态

}

