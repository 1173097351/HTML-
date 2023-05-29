package com.zhou.pojo;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


//施肥信息
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FertilizationInformation {
    private String applyId;     //施肥信息编号
    private String fertilizerId;        //化肥编号
    private String cropId;      //农作物编号
    private double applyNum;        //施肥量
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date applyTime;     //施肥日期
    private Date updateTime;        //更新日期
    private int status;     //状态
    FertilizerInformation fertilizerInformation;
}
