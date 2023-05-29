package com.zhou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//农作物
public class Crop {
    private String cropId;      //农作物编号
    private String landId;      //地块编号
    private String seedId;      //种苗编号
    private String cropName;        //农作物名称
    private Date updateTime;        //更新日期
    private int status;        //状态
    AgriculturalProductInformation agriculturalProductInformation;      //农产品信息
    ParcelInformation parcelInformation;        //地块信息
    SeedInformation seedInformation;        //种苗信息

    List<FertilizationInformation> fertilizationInformation;      //施肥信息
    List<FertilizerInformation> fertilizerInformation;        //化肥信息

    List<ApplyInformation> ApplyInformation;      //施药信息
    List<PesticideInformation> PesticideInformation;        //农药信息
}
