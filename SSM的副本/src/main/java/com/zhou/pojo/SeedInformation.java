package com.zhou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 种苗信息（种苗信息编号，种苗名称，农资商编号，库存量，进库量，出库量，更新日期，状态）
 *
 * @TableName seed_information
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeedInformation {
    private String seedId;      //种苗信息编号
    private String seedName;        //种苗名称
    private String supplierId;      //农资商编号
    private double storageNum;      //库存量
    private double inNum;       //进库量
    private double outNum;      //出库量
    private Date updateTime;        //更新日期
    private Integer status;        //状态

    private Supplier supplier;      //农资商

}
