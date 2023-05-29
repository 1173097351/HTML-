package com.zhou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//化肥信息
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FertilizerInformation {
    private String fertilizerId;        //化肥信息编号
    private String fertilizerName;      //化肥名称
    private String supplierId;      //农资商编号
    private double storageNum;      //库存量
    private double inNum;       //进库量
    private double outNum;      //出库量
    private Date updateTime;        //更新日期
    private int status;     //状态

    private Supplier supplier;  //农资商
}
