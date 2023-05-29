package com.zhou.dao;

import com.zhou.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ParcelMapper {

    //根据园区id，查询地块信息
    List<ParcelInformation> queryLand(String parkId);

    //根据地块id，查询农产品信息
//    List<Crop> queryAP(String landId);

    //根据id，查询地块信息
    ParcelInformation queryLandId(String landId);

    //根据名称，查询地块信息
    List<ParcelInformation> queryLandName(String landName);

    //根据地块id，查询农作物信息
    Crop queryCropId(String landId);

    //查询农产品信息
    List<AgriculturalProductInformation> queryAgriculturalProductInformation();

    //根据农产品名称，查询农产品信息
    AgriculturalProductInformation queryAgriculturalProductInformationName(String username);

    //根据农产品名称，查询农产品id
    String queryAgrId(String username);

    //查询种苗信息
    List<SeedInformation> querySeedInformation();

    //根据地块名称，查询地块id
    String queryParcelInformationLandName(String landName);

    //根据种苗名称，查询种苗id
    String querySeedInformationSeedName(String seedName);


    //修改地块信息
    int updateLand(Map<String, Object> map);

    //根据id删除地块信息
    int deleteLand(@Param("landId") String landId);

    //根据地块id，删除农作物信息
    int deleteCrop(@Param("landId") String landId);

    //根据农作物cropId,删除农产品信息
    int deleteAp(@Param("cropId") String cropId);

    //根据种植id,删除种植信息
    int deleteSeed(@Param("seedId") String seedId);

    //根据种植id,删除种植信息
    int deleteCropId(@Param("cropId") String cropId);

    //新增地块信息
    int insertLand(Map<String, Object> map);

    //新增农作物信息
    int insertCrop(Map<String, Object> map);

    //新增农产品信息
    int insertAp(Map<String, Object> map);

    //新增种苗信息
    int insertSeed(Map<String, Object> map);

    //根据园区id，查询农作物信息
    List<Crop> queryCrop(String parkId);

    //根据农作物id，查询地块信息、种苗信息
    Crop queryId(String cropId);

    //根据农作物id，修改农作物名称、地块名称、种苗名称
    int updateCrop(Map<String, Object> map);

    //根据农作物id，查询施肥信息和化肥信息
    List<FertilizationInformation> queryFertilize(String cropId);

    //新增施肥记录
    int insertFertilize(Map<String, Object> map);

    //根据化肥名称，查询化肥id
    String queryFertilizerName(String fertilizerName);

    //查询全部化肥
    List<FertilizerInformation> queryFertilizer();

    //新增施药记录
    int insertApplyMedicine(Map<String, Object> map);

    //根据农作物id，查询施药信息和农药信息
    List<ApplyInformation> queryApplyMedicineId(String cropId);

    //查询全部农药
    List<PesticideInformation> queryApplyMedicine();

    //根据名称，查询化肥id
    String queryApplyMedicineName(String pesticideName);

    //根据农作物id，查询灌溉记录
    List<IrrigationInformation> queryIrrigationInformation(String cropId);

    //新增灌溉记录
    int insertIrrigationInformation(Map<String, Object> map);
}
