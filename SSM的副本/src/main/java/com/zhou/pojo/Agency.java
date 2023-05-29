package com.zhou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//经营商
public class Agency {
    private String distributorId;       //经营商编号
    private String distributoridName;       //经营商名称
    private String distributoridAddress;        //地址
    private String contactPerson;       //联系人
    private String contactMethod;       //联系方式
    private Date updateTime;        //更新日期
    private Integer status;        //状态
}
