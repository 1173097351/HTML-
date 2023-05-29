package com.zhou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//用户信息
public class UserInformation {
    private String uinfoId;     //用户信息编号
    private String uid;     //用户编号
    private String parkId;      //园区编号
    UserAccount userAccount;
    ParkInformation parkInformation;

}
