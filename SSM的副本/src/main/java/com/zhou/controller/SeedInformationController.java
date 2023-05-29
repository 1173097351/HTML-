package com.zhou.controller;

import com.zhou.pojo.Supplier;
import com.zhou.service.SeedInformationService;
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
public class SeedInformationController {

    @Resource
    SeedInformationService seedInformationService;

    @Resource
    SupplierService supplierService;

    /**
     * 跳转到种苗管理页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/toSeedInformation")
    public String toSeedInformation(Model model) {
        model.addAttribute("list", seedInformationService.querySeedInformationList(new HashMap<>()));
        return "seedlingManagement/seedInformation";
    }

    /**
     * 跳转到修改种苗信息页面
     *
     * @param model
     * @param seedId
     * @return
     */
    @RequestMapping("/toUpdateSeedInformation/{seedId}")
    public String toUpdateSeedInformation(Model model, @PathVariable("seedId") String seedId) {
        System.out.println("修改id：" + seedId);
        Map<String, Object> map = new HashMap<>();
        map.put("seedId", seedId);
        model.addAttribute("list", seedInformationService.querySeedInformation(map));
        return "seedlingManagement/updateSeedInformation";
    }

    /**
     * 修改种苗信息到请求
     *
     * @param seedName
     * @return
     */
    @RequestMapping("/updateSeedInformation")
    public String updateSeedInformation(String seedId, String seedName) {
//        Date date = new Date();
        Map<String, Object> map = new HashMap<>();
        map.put("seedId", seedId);
        map.put("seedName", seedName);
//        map.put("updateTime", date);
        seedInformationService.updateSeedInformation(map);
        return "redirect:/toSeedInformation";
    }

    /**
     * 删除种苗信息的请求
     *
     * @param seedId
     * @return
     */
    @RequestMapping("/deleteSeedInformationId/{seedId}")
    public String deleteSeedInformationId(@PathVariable("seedId") String seedId) {
        Map<String, Object> map = new HashMap<>();
        map.put("seedId", seedId);
        seedInformationService.deleteSeedInformationId(map);
        return "redirect:/toSeedInformation";
    }

    /**
     * 跳转到新增种苗信息页面
     *
     * @return
     */
    @RequestMapping("/toAddSeedInformation")
    public String toAddSeedInformation() {
        return "seedlingManagement/addSeedInformation";
    }


    /**
     * 新增种苗信息的请求
     *
     * @param seedName
     * @return
     */
    @RequestMapping("/insertSeedInformation")
    public String insertSeedInformation(String seedName) {
        Map<String, Object> map = new HashMap<>();
        map.put("seedName", seedName);
        map.put("status", 1);
        seedInformationService.insertSeedInformation(map);
        return "redirect:/toSeedInformation";
    }

    /**
     * 跳转到种苗入库记录
     *
     * @param model
     * @return
     */
    @RequestMapping("/toWarehousing")
    public String toWarehousing(Model model) {
        model.addAttribute("list", seedInformationService.querySeedInformationList(new HashMap<>()));
        return "seedlingManagement/warehousing";
    }

    /**
     * 跳转到种苗管理页面
     *
     * @return
     */
    @RequestMapping("/toS")
    public String toS() {
        return "redirect:/toSeedInformation";
    }


    /**
     * 跳转到种苗入库操作页面
     *
     * @param model
     * @param seedId
     * @return
     */
    @RequestMapping("/toUpdatWwarehousing/{seedId}")
    public String toUpdatWwarehousing(Model model, @PathVariable("seedId") String seedId) {
        Map<String, Object> map = new HashMap<>();
        map.put("seedId", seedId);
        model.addAttribute("list", seedInformationService.querySeedInformation(map));
        model.addAttribute("SeedInformation", supplierService.querySupplierList(new HashMap<>()));

        return "seedlingManagement/updatWwarehousing";
    }

    /**
     * 种苗入库操作的请求
     *
     * @param seedId
     * @param inNum
     * @param supplierName
     * @return
     */
    @RequestMapping("/updatWwarehousing")
    public String a(String seedId, String inNum, String supplierName) {
        Date date = new Date();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("supplierName", supplierName);
        Supplier supplier = supplierService.querySupplier(map1);

        Map<String, Object> map = new HashMap<>();
        map.put("seedId", seedId);
        map.put("inNum", inNum);
        map.put("updateTime", date);
        map.put("supplierId", supplier.getSupplierId());
        seedInformationService.updateSeedInformation(map);
        return "redirect:/toSeedInformation";
    }


}
