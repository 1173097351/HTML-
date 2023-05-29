package com.zhou.service;


import com.zhou.dao.ToolsInformationMapper;
import com.zhou.pojo.PesticideInformation;
import com.zhou.pojo.ToolsInformation;

import java.util.List;
import java.util.Map;

/**
 * @author zhouquan
 * @description 针对表【tools_information】的数据库操作Service
 * @createDate 2023-04-12 20:03:42
 */
public interface ToolsInformationService {

    //查询全部农具
    List<ToolsInformation> queryToolsInformationList(Map<String, Object> map);

    //根据map查询农具
    ToolsInformation queryToolsInformationion(Map<String, Object> map);

    //新增农具
    int insertToolsInformation(Map<String, Object> map);

    //根据id，更新农具
    int updateToolsInformation(Map<String, Object> map);

    //根据id，删除农具
    int deleteToolsInformation(Map<String, Object> map);
}
