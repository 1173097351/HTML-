package com.zhou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 农资商（农资商编号，农资商名称，农资商地址，联系人，联系方式，更新日期，状态）
 *
 * @TableName supplier
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    private String supplierId;      //农资商编号
    private String supplierName;        //农资商名称
    private String supplierAddress;     //农资商地址
    private String concatPerson;        //联系人
    private String concatMethod;        //联系方式
    private Date updateTime;        //更新日期
    private Integer status;     //状态

}