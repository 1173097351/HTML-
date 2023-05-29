package com.zhou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//农药信息
public class PesticideInformation {
    private String pesticideId;     //农药信息编号
    private String pesticideName;       //农药名称
    private String supplierId;      //农资商编号
    private double storageNum;      //库存量
    private double inNum;       //进库量
    private double outNum;      //出库量
    private Date updateTime;        //更新日期
    private int status;     //状态

    private Supplier supplier;  //农资商信息
}
