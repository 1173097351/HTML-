package com.zhou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//园区信息
public class ParkInformation {
    private String parkId;      //园区编号
    private String parkName;        //园区名称
    private String parkAddress;     //园区地址
    private String concatPerson;        //联系人
    private String concatMethod;        //联系方式
    private Date updateTime;      //更新日期
    private int status;        //状态

}
