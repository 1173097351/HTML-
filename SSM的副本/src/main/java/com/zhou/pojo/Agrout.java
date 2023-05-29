package com.zhou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//农产品销售
public class Agrout {
    private String agroutId;        //农产品销售编号
    private double outNum;      //销售量
    private String distributorId;       //经营商编号
    private String agrId;      //农产品编号
    private Date updateTime;        //更新日期
    private int status;        //状态

    private AgriculturalProductInformation agriculturalProductInformation;      //农产品信息
    private Agency agency;      //经营商信息
}
