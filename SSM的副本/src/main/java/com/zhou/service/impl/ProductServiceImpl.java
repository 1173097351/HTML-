package com.zhou.service.impl;

import com.zhou.dao.ProductMapper;
import com.zhou.pojo.*;
import com.zhou.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("ProductServiceImpl")
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;

    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }


    @Override
    public List<AgriculturalProductInformation> queryProductList() {
        return productMapper.queryProductList();
    }

    @Override
    public AgriculturalProductInformation queryProductId(String agrId) {
        return productMapper.queryProductId(agrId);
    }

    @Override
    public AgriculturalProductInformation queryProductUsername(String username) {
        return productMapper.queryProductUsername(username);
    }


    @Override
    public int updateProduct(Map<String, Object> map) {
        return productMapper.updateProduct(map);
    }

    @Override
    public int deleteProductMap(Map<String, Object> map) {
        return productMapper.deleteProductMap(map);
    }

    @Override
    public int deleteAgrinMap(Map<String, Object> map) {
        return productMapper.deleteAgrinMap(map);
    }

    @Override
    public int insertProduct(Map<String, Object> map) {
        return productMapper.insertProduct(map);
    }

    @Override
    public AgriculturalProductInformation queryAgrinList(String agrId) {
        return productMapper.queryAgrinList(agrId);
    }

    @Override
    public int insertAgrin(Map<String, Object> map) {
        return productMapper.insertAgrin(map);
    }

    @Override
    public List<AgriculturalProductInformation> queryMacroscopical() {
        return productMapper.queryMacroscopical();
    }

    @Override
    public List<Agrin> queryMacroscopicalUsername(String username) {
        return productMapper.queryMacroscopicalUsername(username);
    }

    @Override
    public List<Agrin> queryMicrocosmic() {
        return productMapper.queryMicrocosmic();
    }

    @Override
    public List<Agrout> querySalesRecordList(Map<String, Object> map) {
        return productMapper.querySalesRecordList(map);
    }

    @Override
    public int insertSalesRecord(Map<String, Object> map) {
        return productMapper.insertSalesRecord(map);
    }

    @Override
    public List<Agency> queryAgencyList() {
        return productMapper.queryAgencyList();
    }

    @Override
    public List<Agrout> querySalesRecord() {
        return productMapper.querySalesRecord();
    }

}
