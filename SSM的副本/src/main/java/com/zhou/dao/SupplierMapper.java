package com.zhou.dao;


import com.zhou.pojo.Supplier;

import java.util.List;
import java.util.Map;

/**
* @author zhouquan
* @description 针对表【supplier(农资商（农资商编号，农资商名称，农资商地址，联系人，联系方式，更新日期，状态）)】的数据库操作Mapper
* @createDate 2023-04-06 17:46:21
* @Entity generator.domain.Supplier
*/
public interface SupplierMapper {

    //查询全部农资商
    List<Supplier> querySupplierList(Map<String, Object> map);

    //根据map查询农资商
    Supplier querySupplier(Map<String, Object> map);

    //新增农资商
    int insertSupplier(Map<String, Object> map);

    //根据id，更新农资商
    int updateSupplier(Map<String, Object> map);

    //根据id，删除农资商
    int deleteSupplierId(Map<String, Object> map);

}




