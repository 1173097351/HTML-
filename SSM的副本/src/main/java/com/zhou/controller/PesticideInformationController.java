package com.zhou.controller;

import com.zhou.pojo.Supplier;
import com.zhou.service.PesticideInformationService;
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
public class PesticideInformationController {

    @Resource
    SupplierService supplierService;

    @Resource
    PesticideInformationService pesticideInformationService;

    /**
     * 跳转到农药管理页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/toPesticide")
    public String toPesticide(Model model) {
        model.addAttribute("list", pesticideInformationService.queryPesticideInformationList(new HashMap<>()));
        return "pesticideManagement/pesticide";
    }

    /**
     * 跳转到修改农药信息页面
     *
     * @param model
     * @param pesticideId
     * @return
     */
    @RequestMapping("/toUpdatePesticide/{pesticideId}")
    public String toUpdatePesticide(Model model, @PathVariable("pesticideId") String pesticideId) {
        Map<String, Object> map = new HashMap<>();
        map.put("pesticideId", pesticideId);
        model.addAttribute("list", pesticideInformationService.queryPesticideInformation(map));
        model.addAttribute("SeedInformation", supplierService.querySupplierList(new HashMap<>()));

        return "pesticideManagement/updatePesticide";
    }

    /**
     * 修改种苗信息的请求
     *
     * @param pesticideId
     * @param pesticideName
     * @param supplierName
     * @return
     */
    @RequestMapping("/updatePesticideInformation")
    public String updatePesticideInformation(String pesticideId, String pesticideName, String supplierName) {
        Map<String, Object> map1 = new HashMap<>();
        map1.put("supplierName", supplierName);
        Supplier supplier = supplierService.querySupplier(map1);
        System.out.println("农资商id:" + supplier.getSupplierId());

        Map<String, Object> map = new HashMap<>();
        map.put("pesticideId", pesticideId);
        map.put("pesticideName", pesticideName);
        map.put("supplierId", supplier.getSupplierId());
        pesticideInformationService.updatePesticideInformation(map);
        return "redirect:/toPesticide";
    }

    /**
     * 删除农药信息的请求
     *
     * @param pesticideId
     * @return
     */
    @RequestMapping("/deletePesticideInformation/{pesticideId}")
    public String deletePesticideInformation(@PathVariable("pesticideId") String pesticideId) {
        Map<String, Object> map = new HashMap<>();
        map.put("pesticideId", pesticideId);
        pesticideInformationService.deletePesticideInformation(map);
        return "redirect:/toPesticide";
    }

    /**
     * 跳转到新增农药信息页面
     *
     * @return
     */
    @RequestMapping("/toAddPesticide")
    public String toAddSeedInformation() {
        return "pesticideManagement/addPesticide";
    }


    /**
     * 新增农药信息的请求
     *
     * @param pesticideName
     * @return
     */
    @RequestMapping("/insertPesticideInformation")
    public String insertPesticideInformation(String pesticideName) {
        Map<String, Object> map = new HashMap<>();
        map.put("pesticideName", pesticideName);
        map.put("status", 1);
        pesticideInformationService.insertPesticideInformation(map);
        return "redirect:/toPesticide";
    }

    /**
     * 跳转到种苗入库记录
     *
     * @param model
     * @return
     */
    @RequestMapping("/toPesticideWarehousing")
    public String toWarehousing(Model model) {
        model.addAttribute("list", pesticideInformationService.queryPesticideInformationList(new HashMap<>()));
        return "pesticideManagement/pesticideWarehousing";
    }

    /**
     * 跳转到农药管理页面
     *
     * @return
     */
    @RequestMapping("/tooPesticide")
    public String tooPesticide() {
        return "redirect:/toPesticide";
    }


    /**
     * 跳转到农药入库操作页面
     *
     * @param model
     * @param pesticideId
     * @return
     */
    @RequestMapping("/toUpdatPesticideWwarehousing/{pesticideId}")
    public String toUpdatPesticideWwarehousing(Model model, @PathVariable("pesticideId") String pesticideId) {
        Map<String, Object> map = new HashMap<>();
        map.put("pesticideId", pesticideId);
        model.addAttribute("list", pesticideInformationService.queryPesticideInformation(map));
        model.addAttribute("SeedInformation", supplierService.querySupplierList(new HashMap<>()));

        return "pesticideManagement/updatPesticideWwarehousing";
    }

    /**
     * 农药入库操作的请求
     *
     * @param pesticideId
     * @param inNum
     * @param supplierName
     * @return
     */
    @RequestMapping("/updatPesticideWwarehousing")
    public String updatPesticideWwarehousing(String pesticideId, String inNum, String supplierName) {
        Date date = new Date();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("supplierName", supplierName);
        Supplier supplier = supplierService.querySupplier(map1);

        Map<String, Object> map = new HashMap<>();
        map.put("pesticideId", pesticideId);
        map.put("inNum", inNum);
        map.put("updateTime", date);
        map.put("supplierId", supplier.getSupplierId());
        pesticideInformationService.updatePesticideInformation(map);
        return "redirect:/toPesticide";
    }

}
