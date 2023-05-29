package com.zhou.service;

import com.zhou.pojo.FertilizerInformation;

import java.util.List;
import java.util.Map;

/**
 * @author zhouquan
 * @description 针对表【fertilizer_information】的数据库操作Service
 * @createDate 2023-04-12 11:03:26
 */
public interface FertilizerInformationService {

    //查询全部化肥
    List<FertilizerInformation> queryFertilizerInformationList(Map<String, Object> map);

    //根据map查询农药
    FertilizerInformation queryFertilizerInformation(Map<String, Object> map);

    //新增农药
    int insertFertilizerInformation(Map<String, Object> map);

    //根据id，更新农药
    int updateFertilizerInformation(Map<String, Object> map);

    //根据id，删除农药
    int deleteFertilizerInformation(Map<String, Object> map);
}
