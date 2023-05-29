package com.zhou.service.impl;

import com.zhou.dao.PesticideInformationMapper;
import com.zhou.pojo.PesticideInformation;
import com.zhou.service.PesticideInformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author zhouquan
 * @description 针对表【pesticide_information】的数据库操作Service实现
 * @createDate 2023-04-12 08:54:49
 */
@Service("PesticideInformationServiceImpl")
public class PesticideInformationServiceImpl implements PesticideInformationService {
    @Resource
    PesticideInformationMapper pesticideInformationMapper;

    @Override
    public List<PesticideInformation> queryPesticideInformationList(Map<String, Object> map) {
        return pesticideInformationMapper.queryPesticideInformationList(map);
    }

    @Override
    public PesticideInformation queryPesticideInformation(Map<String, Object> map) {
        return pesticideInformationMapper.queryPesticideInformation(map);
    }

    @Override
    public int insertPesticideInformation(Map<String, Object> map) {
        return pesticideInformationMapper.insertPesticideInformation(map);
    }

    @Override
    public int updatePesticideInformation(Map<String, Object> map) {
        return pesticideInformationMapper.updatePesticideInformation(map);
    }

    @Override
    public int deletePesticideInformation(Map<String, Object> map) {
        return pesticideInformationMapper.deletePesticideInformation(map);
    }
}




