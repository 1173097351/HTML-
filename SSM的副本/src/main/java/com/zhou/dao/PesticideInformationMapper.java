package com.zhou.dao;

import com.zhou.pojo.PesticideInformation;

import java.util.List;
import java.util.Map;

/**
* @author zhouquan
* @description 针对表【pesticide_information】的数据库操作Mapper
* @createDate 2023-04-12 08:54:49
* @Entity generator.domain.PesticideInformation
*/
public interface PesticideInformationMapper {

    //查询全部农药
    List<PesticideInformation> queryPesticideInformationList(Map<String, Object> map);

    //根据map查询农药
    PesticideInformation queryPesticideInformation(Map<String, Object> map);

    //新增农药
    int insertPesticideInformation(Map<String, Object> map);

    //根据id，更新农药
    int updatePesticideInformation(Map<String, Object> map);

    //根据id，删除农药
    int deletePesticideInformation(Map<String, Object> map);
}




