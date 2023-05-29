package com.zhou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//施药信息
public class ApplyInformation {
    private String applyId;     //施药信息编号
    private String pesticideId;     //农药编号
    private String cropId;      //农作物编号
    private double applyNum;        //施药量
    private Date applyTime;     //施药日期
    private Date updateTime;        //更新日期
    private int status;        //状态
    PesticideInformation pesticideInformation;
}
