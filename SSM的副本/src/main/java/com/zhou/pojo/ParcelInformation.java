package com.zhou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//地块信息
public class ParcelInformation {

    private String landId;      //地块信息编号
    private String parkId;      //园区编号
    private String landNum;     //地块编号
    private String landName;        //地块名称
    private String lande;       //地块位置东
    private String landw;       //地块位置西
    private String lands;       //地块位置南
    private String landn;       //地块位置北
    private double landSize;        //地块大小
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updateTime;        //更新日期
    private int status;        //状态
    private String agrId;       //农产品id

    AgriculturalProductInformation agriculturalProductInformation;      //农产品信息
}
