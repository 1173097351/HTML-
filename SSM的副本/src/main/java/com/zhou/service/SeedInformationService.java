package com.zhou.service;


import com.zhou.pojo.SeedInformation;
import com.zhou.pojo.Supplier;

import java.util.List;
import java.util.Map;

/**
* @author zhouquan
* @description 针对表【seed_information】的数据库操作Service
* @createDate 2023-04-10 11:29:22
*/
public interface SeedInformationService {

    //查询全部种苗
    List<SeedInformation> querySeedInformationList(Map<String, Object> map);

    //根据map查询种苗
    SeedInformation querySeedInformation(Map<String, Object> map);

    //新增种苗
    int insertSeedInformation(Map<String, Object> map);

    //根据id，更新种苗
    int updateSeedInformation(Map<String, Object> map);

    //根据id，删除种苗
    int deleteSeedInformationId(Map<String, Object> map);
}
