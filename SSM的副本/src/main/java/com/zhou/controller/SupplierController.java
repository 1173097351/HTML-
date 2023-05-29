package com.zhou.controller;

import com.zhou.service.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SupplierController {

    @Resource
    SupplierService supplierService;

    /**
     * 跳转到农资商展示页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/toSupplier")
    public String toSupplier(Model model) {
        model.addAttribute("list", supplierService.querySupplierList(new HashMap<>()));
        return "AgriculturalBusinessManagement/supplier";
    }

    /**
     * 跳转到新增农资商页面
     *
     * @return
     */
    @RequestMapping("/toAddSupplier")
    public String toAddSupplier() {
        return "AgriculturalBusinessManagement/addSupplier";
    }


    /**
     * 新增农资商的请求
     *
     * @param supplierName
     * @param supplierAddress
     * @param concatPerson
     * @param concatMethod
     * @return
     */
    @RequestMapping("/addSupplier")
    public String addSupplier(String supplierName, String supplierAddress, String concatPerson, String concatMethod) {
        Map<String, Object> map = new HashMap<>();
        map.put("supplierName", supplierName);
        map.put("supplierAddress", supplierAddress);
        map.put("concatPerson", concatPerson);
        map.put("concatMethod", concatMethod);
        map.put("status", 1);
        supplierService.insertSupplier(map);
        return "redirect:/toSupplier";
    }

    /**
     * 根据id，删除农资商的请求
     *
     * @param supplierId
     * @return
     */
    @RequestMapping("/deleteSupplierId/{supplierId}")
    public String deleteSupplierId(@PathVariable("supplierId") String supplierId) {
        Map<String, Object> map = new HashMap<>();
        map.put("supplierId", supplierId);
        supplierService.deleteSupplierId(map);
        return "redirect:/toSupplier";
    }


    /**
     * 跳转到修改农资商页面
     *
     * @param model
     * @param supplierId
     * @return
     */
    @RequestMapping("/toUpdateSupplier/{supplierId}")
    public String toUpdateSupplier(Model model, @PathVariable("supplierId") String supplierId) {
        Map<String, Object> map = new HashMap<>();
        map.put("supplierId", supplierId);
        model.addAttribute("list", supplierService.querySupplier(map));
        return "AgriculturalBusinessManagement/updateSupplier";
    }


    /**
     * 修改农资商到请求
     *
     * @param supplierId
     * @param supplierName
     * @param supplierAddress
     * @param concatPerson
     * @param concatMethod
     * @return
     */
    @RequestMapping("/updateSupplier")
    public String updateSupplier(String supplierId, String supplierName,
                                 String supplierAddress, String concatPerson, String concatMethod) {
        Date date = new Date();
        Map<String, Object> map = new HashMap<>();
        map.put("supplierId", supplierId);
        map.put("supplierName", supplierName);
        map.put("supplierAddress", supplierAddress);
        map.put("concatPerson", concatPerson);
        map.put("concatMethod", concatMethod);
        map.put("updateTime", date);
        supplierService.updateSupplier(map);
        return "redirect:/toSupplier";
    }
}
