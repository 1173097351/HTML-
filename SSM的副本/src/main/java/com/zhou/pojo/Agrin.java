package com.zhou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//农产品进库
public class Agrin {
    private String agrin;       //农产品进库编号
    private String agrId;       //农产品编号
    private double inNum;       //进库量
    private Date updateTime;      //进库时间
    private long status;        //状态
}
