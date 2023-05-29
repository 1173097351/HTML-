package com.zhou.service.impl;

import com.zhou.dao.FertilizerInformationMapper;
import com.zhou.pojo.FertilizerInformation;
import com.zhou.service.FertilizerInformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author zhouquan
 * @description 针对表【fertilizer_information】的数据库操作Service实现
 * @createDate 2023-04-12 11:03:26
 */
@Service("FertilizerInformationServiceImpl")
public class FertilizerInformationServiceImpl implements FertilizerInformationService {

    @Resource
    private FertilizerInformationMapper fertilizerInformationMapper;

    public FertilizerInformationMapper getFertilizerInformationMapper() {
        return fertilizerInformationMapper;
    }

    public FertilizerInformationServiceImpl(FertilizerInformationMapper fertilizerInformationMapper) {
        this.fertilizerInformationMapper = fertilizerInformationMapper;
    }


    @Override
    public List<FertilizerInformation> queryFertilizerInformationList(Map<String, Object> map) {
        return fertilizerInformationMapper.queryFertilizerInformationList(map);
    }

    @Override
    public FertilizerInformation queryFertilizerInformation(Map<String, Object> map) {
        return fertilizerInformationMapper.queryFertilizerInformation(map);
    }

    @Override
    public int insertFertilizerInformation(Map<String, Object> map) {
        return fertilizerInformationMapper.insertFertilizerInformation(map);
    }

    @Override
    public int updateFertilizerInformation(Map<String, Object> map) {
        return fertilizerInformationMapper.updateFertilizerInformation(map);
    }

    @Override
    public int deleteFertilizerInformation(Map<String, Object> map) {
        return fertilizerInformationMapper.deleteFertilizerInformation(map);
    }
}




