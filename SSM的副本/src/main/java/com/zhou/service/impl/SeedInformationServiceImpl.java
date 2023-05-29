package com.zhou.service.impl;


import com.zhou.dao.SeedInformationMapper;
import com.zhou.pojo.SeedInformation;
import com.zhou.service.SeedInformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author zhouquan
 * @description 针对表【seed_information】的数据库操作Service实现
 * @createDate 2023-04-10 11:29:22
 */
@Service("SeedInformationServiceImpl")
public class SeedInformationServiceImpl implements SeedInformationService {
    @Resource
    private SeedInformationMapper seedInformationMapper;

    @Override
    public List<SeedInformation> querySeedInformationList(Map<String, Object> map) {
        return seedInformationMapper.querySeedInformationList(map);
    }

    @Override
    public SeedInformation querySeedInformation(Map<String, Object> map) {
        return seedInformationMapper.querySeedInformation(map);
    }

    @Override
    public int insertSeedInformation(Map<String, Object> map) {
        return seedInformationMapper.insertSeedInformation(map);
    }

    @Override
    public int updateSeedInformation(Map<String, Object> map) {
        return seedInformationMapper.updateSeedInformation(map);
    }

    @Override
    public int deleteSeedInformationId(Map<String, Object> map) {
        return seedInformationMapper.deleteSeedInformationId(map);
    }
}




