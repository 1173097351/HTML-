package com.zhou.service.impl;

import com.zhou.dao.AgencyMapper;
import com.zhou.pojo.Agency;
import com.zhou.service.AgencyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author zhouquan
 * @description 针对表【agency】的数据库操作Service实现
 * @createDate 2023-04-18 10:02:03
 */
@Service("AgencyServiceImpl")
public class AgencyServiceImpl implements AgencyService {
    @Resource
    private AgencyMapper agencyMapper;

    public AgencyServiceImpl(AgencyMapper agencyMapper) {
        this.agencyMapper = agencyMapper;
    }

    @Override
    public List<Agency> queryAgencyList(Map<String, Object> map) {
        return agencyMapper.queryAgencyList(map);
    }

    @Override
    public Agency queryAgency(Map<String, Object> map) {
        return agencyMapper.queryAgency(map);
    }

    @Override
    public int insertAgency(Map<String, Object> map) {
        return agencyMapper.insertAgency(map);
    }

    @Override
    public int updateAgency(Map<String, Object> map) {
        return agencyMapper.updateAgency(map);
    }

    @Override
    public int deleteAgency(Map<String, Object> map) {
        return agencyMapper.deleteAgency(map);
    }
}




