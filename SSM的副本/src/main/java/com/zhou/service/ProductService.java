package com.zhou.service;

import com.zhou.pojo.*;

import java.util.List;
import java.util.Map;

public interface ProductService {
    //查询全部农产品信息
    List<AgriculturalProductInformation> queryProductList();

    //根据id查询农产品信息
    AgriculturalProductInformation queryProductId(String agrId);

    //根据名称，查询农产品信息
    AgriculturalProductInformation queryProductUsername(String username);

    //根据id，修改农产品信息
    int updateProduct(Map<String, Object> map);

    //根据id，删除农产品信息
    int deleteProductMap(Map<String, Object> map);

    //根据id，删除进库信息
    int deleteAgrinMap(Map<String, Object> map);

    //新增农产品
    int insertProduct(Map<String, Object> map);

    //根据农产品id，查询进库信息
    AgriculturalProductInformation queryAgrinList(String agrId);

    //新增农产品进库信息
    int insertAgrin(Map<String, Object> map);

    //查询农产品和进库记录的全部信息
    List<AgriculturalProductInformation> queryMacroscopical();

    //根据农产品名称查询进库量
    List<Agrin> queryMacroscopicalUsername(String username);

    //查询进库记录的日期、进库量
    List<Agrin> queryMicrocosmic();

    //根据map，查询销售记录
    List<Agrout> querySalesRecordList(Map<String, Object> map);

    //新增销售记录
    int insertSalesRecord(Map<String, Object> map);

    //查询全部经营商
    List<Agency> queryAgencyList();

    //查询全部销售记录
    List<Agrout> querySalesRecord();

}
