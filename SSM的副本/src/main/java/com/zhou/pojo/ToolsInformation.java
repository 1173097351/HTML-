package com.zhou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @TableName tools_information
 * 农具信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToolsInformation {
    private String toolId;      //农具信息编号
    private String toolName;        //农具名称
    private String supplierId;      //农资商编号
    private Double storageNum;      //库存量
    private Double inNum;       //进库量
    private Double outNum;      //出库量
    private Date updateTime;        //更新日期
    private Integer status;     //状态

    private Supplier supplier;      //农资商
}