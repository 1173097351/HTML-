package com.zhou.service.impl;

import com.zhou.dao.ToolsInformationMapper;
import com.zhou.pojo.PesticideInformation;
import com.zhou.pojo.ToolsInformation;
import com.zhou.service.ToolsInformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author zhouquan
 * @description 针对表【tools_information】的数据库操作Service实现
 * @createDate 2023-04-12 20:03:42
 */
@Service("ToolsInformationServiceImpl")
public class ToolsInformationServiceImpl implements ToolsInformationService {
    @Resource
    ToolsInformationMapper toolsInformationMapper;

    public ToolsInformationServiceImpl(ToolsInformationMapper toolsInformationMapper) {
        this.toolsInformationMapper = toolsInformationMapper;
    }

    @Override
    public List<ToolsInformation> queryToolsInformationList(Map<String, Object> map) {
        return toolsInformationMapper.queryToolsInformationList(map);
    }

    @Override
    public ToolsInformation queryToolsInformationion(Map<String, Object> map) {
        return toolsInformationMapper.queryToolsInformationion(map);
    }

    @Override
    public int insertToolsInformation(Map<String, Object> map) {
        return toolsInformationMapper.insertToolsInformation(map);
    }

    @Override
    public int updateToolsInformation(Map<String, Object> map) {
        return toolsInformationMapper.updateToolsInformation(map);
    }

    @Override
    public int deleteToolsInformation(Map<String, Object> map) {
        return toolsInformationMapper.deleteToolsInformation(map);
    }
}




