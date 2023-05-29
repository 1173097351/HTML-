package com.zhou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//农产品信息
public class AgriculturalProductInformation {
    private String agrId;       //农产品编号
    private String cropId;      //农作物编号
    private String username;        //名称
    private double storageNum;      //库存量
    private double inNum;       //进库量
    private double outNum;      //销售量
    private Date updateTime;        //更新日期
    private int status;        //状态

    private List<Agrin> agrin;        //进库信息
}
