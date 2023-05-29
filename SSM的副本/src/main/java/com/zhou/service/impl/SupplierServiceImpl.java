package com.zhou.service.impl;


import com.zhou.dao.SupplierMapper;
import com.zhou.pojo.Supplier;
import com.zhou.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author zhouquan
 * @description 针对表【supplier(农资商（农资商编号，农资商名称，农资商地址，联系人，联系方式，更新日期，状态）)】的数据库操作Service实现
 * @createDate 2023-04-06 17:46:21
 */
@Service("SupplierServiceImpl")
public class SupplierServiceImpl implements SupplierService {

    @Resource
    SupplierMapper supplierMapper;

    @Override
    public List<Supplier> querySupplierList(Map<String, Object> map) {
        return supplierMapper.querySupplierList(map);
    }

    @Override
    public Supplier querySupplier(Map<String, Object> map) {
        return supplierMapper.querySupplier(map);
    }

    @Override
    public int insertSupplier(Map<String, Object> map) {
        return supplierMapper.insertSupplier(map);
    }

    @Override
    public int updateSupplier(Map<String, Object> map) {
        return supplierMapper.updateSupplier(map);
    }

    @Override
    public int deleteSupplierId(Map<String, Object> map) {
        return supplierMapper.deleteSupplierId(map);
    }
}




