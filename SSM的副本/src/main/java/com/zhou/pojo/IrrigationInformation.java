package com.zhou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//灌溉信息
public class IrrigationInformation {
    private String irrigationId;        //灌溉信息编号
    private String cropId;      //农作物编号
    private double irrigationNum;       //灌溉量
    private Date irrigationTime;        //灌溉日期
    private Date updateTime;        //更新日期
    private int status;        //状态
}
