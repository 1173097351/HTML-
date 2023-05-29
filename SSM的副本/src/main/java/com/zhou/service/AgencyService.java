package com.zhou.service;

import com.zhou.pojo.Agency;

import java.util.List;
import java.util.Map;

/**
 * @author zhouquan
 * @description 针对表【agency】的数据库操作Service
 * @createDate 2023-04-18 10:02:03
 */
public interface AgencyService {

    //查询全部经营商
    List<Agency> queryAgencyList(Map<String, Object> map);

    //根据map查询经营商
    Agency queryAgency(Map<String, Object> map);

    //新增经营商
    int insertAgency(Map<String, Object> map);

    //根据id，更新经营商
    int updateAgency(Map<String, Object> map);

    //根据id，删除经营商
    int deleteAgency(Map<String, Object> map);
}
