package com.zhou.service.impl;

import com.zhou.dao.ParcelMapper;
import com.zhou.pojo.*;
import com.zhou.service.ParcelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("ParcelServiceImpl")
public class ParcelServiceImpl implements ParcelService {
    @Resource
    private ParcelMapper parcelMapper;

    public void setParcelMapper(ParcelMapper parcelMapper) {
        this.parcelMapper = parcelMapper;
    }


    @Override
    public List<AgriculturalProductInformation> queryAgriculturalProductInformation() {
        return parcelMapper.queryAgriculturalProductInformation();
    }

    @Override
    public AgriculturalProductInformation queryAgriculturalProductInformationName(String username) {
        return parcelMapper.queryAgriculturalProductInformationName(username);
    }


    @Override
    public String queryAgrId(String username) {
        return parcelMapper.queryAgrId(username);
    }

    @Override
    public Crop queryCropId(String landId) {
        return parcelMapper.queryCropId(landId);
    }

    @Override
    public String queryParcelInformationLandName(String landName) {
        return parcelMapper.queryParcelInformationLandName(landName);
    }

    @Override
    public String querySeedInformationSeedName(String seedName) {
        return parcelMapper.querySeedInformationSeedName(seedName);
    }

    @Override
    public List<SeedInformation> querySeedInformation() {
        return parcelMapper.querySeedInformation();
    }

    @Override
    public int updateLand(Map<String, Object> map) {
        return parcelMapper.updateLand(map);
    }

    @Override
    public int deleteLand(String landId) {
        return parcelMapper.deleteLand(landId);
    }

    @Override
    public int deleteCrop(String landId) {
        return parcelMapper.deleteCrop(landId);
    }

    @Override
    public int deleteAp(String cropId) {
        return parcelMapper.deleteAp(cropId);
    }

    @Override
    public int deleteSeed(String seedId) {
        return parcelMapper.deleteSeed(seedId);
    }

    @Override
    public int deleteCropId(String cropId) {
        return parcelMapper.deleteCropId(cropId);
    }

    @Override
    public int insertLand(Map<String, Object> map) {
        return parcelMapper.insertLand(map);
    }

    @Override
    public int insertCrop(Map<String, Object> map) {
        return parcelMapper.insertCrop(map);
    }

    @Override
    public int insertAp(Map<String, Object> map) {
        return parcelMapper.insertAp(map);
    }

    @Override
    public int insertSeed(Map<String, Object> map) {
        return parcelMapper.insertSeed(map);
    }

    @Override
    public List<Crop> queryCrop(String parkId) {
        return parcelMapper.queryCrop(parkId);
    }

    @Override
    public Crop queryId(String cropId) {
        return parcelMapper.queryId(cropId);
    }

    @Override
    public int updateCrop(Map<String, Object> map) {
        return parcelMapper.updateCrop(map);
    }

    @Override
    public List<FertilizationInformation> queryFertilize(String cropId) {
        return parcelMapper.queryFertilize(cropId);
    }

    @Override
    public int insertFertilize(Map<String, Object> map) {
        return parcelMapper.insertFertilize(map);
    }

    @Override
    public String queryFertilizerName(String fertilizerName) {
        return parcelMapper.queryFertilizerName(fertilizerName);
    }


    @Override
    public List<FertilizerInformation> queryFertilizer() {
        return parcelMapper.queryFertilizer();
    }

    @Override
    public int insertApplyMedicine(Map<String, Object> map) {
        return parcelMapper.insertApplyMedicine(map);
    }

    @Override
    public List<ApplyInformation> queryApplyMedicineId(String cropId) {
        return parcelMapper.queryApplyMedicineId(cropId);
    }

    @Override
    public List<PesticideInformation> queryApplyMedicine() {
        return parcelMapper.queryApplyMedicine();
    }

    @Override
    public String queryApplyMedicineName(String pesticideName) {
        return parcelMapper.queryApplyMedicineName(pesticideName);
    }

    @Override
    public List<IrrigationInformation> queryIrrigationInformation(String cropId) {
        return parcelMapper.queryIrrigationInformation(cropId);
    }

    @Override
    public int insertIrrigationInformation(Map<String, Object> map) {
        return parcelMapper.insertIrrigationInformation(map);
    }


    @Override
    public List<ParcelInformation> queryLand(String parkId) {
        return parcelMapper.queryLand(parkId);
    }


//    @Override
//    public List<Crop> queryAP(String landId) {
//        return parcelMapper.query(landId);
//    }

    @Override
    public ParcelInformation queryLandId(String landId) {
        return parcelMapper.queryLandId(landId);
    }

    @Override
    public List<ParcelInformation> queryLandName(String landName) {
        return parcelMapper.queryLandName(landName);
    }


}
