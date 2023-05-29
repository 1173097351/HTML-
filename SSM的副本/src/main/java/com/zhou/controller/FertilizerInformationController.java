package com.zhou.controller;

import com.zhou.pojo.Supplier;
import com.zhou.service.FertilizerInformationService;
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
public class FertilizerInformationController {

    @Resource
    SupplierService supplierService;

    @Resource
    FertilizerInformationService fertilizerInformationService;

    String fertilizerId;        //化肥编号

    /**
     * 跳转到化肥管理页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/toFertilizer")
    public String toFertilizer(Model model) {
        model.addAttribute("list", fertilizerInformationService.queryFertilizerInformationList(new HashMap<>()));
        return "fertilizerManagement/fertilizer";
    }

    /**
     * 跳转到修改化肥信息页面
     *
     * @param model
     * @param fertilizerId
     * @return
     */
    @RequestMapping("/toUpdateFertilizer/{fertilizerId}")
    public String toUpdateFertilizer(Model model, @PathVariable("fertilizerId") String fertilizerId) {
        this.fertilizerId = fertilizerId;
        Map<String, Object> map = new HashMap<>();
        map.put("fertilizerId", this.fertilizerId);
        model.addAttribute("list", fertilizerInformationService.queryFertilizerInformation(map));
        model.addAttribute("SeedInformation", supplierService.querySupplierList(new HashMap<>()));
        return "fertilizerManagement/updateFertilizer";
    }

    /**
     * 修改化肥信息的请求
     *
     * @param fertilizerId
     * @param fertilizerName
     * @param supplierName
     * @return
     */
    @RequestMapping("/updateFertilizerInformation")
    public String updateFertilizerInformation(String fertilizerId, String fertilizerName, String supplierName, Model model) {
        if (supplierName == "") {
            model.addAttribute("msg", "不能为空");
            Map<String, Object> map = new HashMap<>();
            map.put("fertilizerId", this.fertilizerId);
            model.addAttribute("list", fertilizerInformationService.queryFertilizerInformation(map));
            model.addAttribute("SeedInformation", supplierService.querySupplierList(new HashMap<>()));
            return "fertilizerManagement/updateFertilizer";
        } else {
            Map<String, Object> map1 = new HashMap<>();
            System.out.println("农资商id" + this.fertilizerId);
            map1.put("supplierName", supplierName);
            Supplier supplier = supplierService.querySupplier(map1);

            Map<String, Object> map = new HashMap<>();
            map.put("fertilizerId", this.fertilizerId);
            map.put("fertilizerName", fertilizerName);
            map.put("supplierId", supplier.getSupplierId());
            fertilizerInformationService.updateFertilizerInformation(map);
            return "redirect:/toFertilizer";
        }
    }

    /**
     * 删除化肥信息的请求
     *
     * @param fertilizerId
     * @return
     */
    @RequestMapping("/deleteFertilizerInformation/{fertilizerId}")
    public String deleteFertilizerInformation(@PathVariable("fertilizerId") String fertilizerId) {
        Map<String, Object> map = new HashMap<>();
        map.put("fertilizerId", fertilizerId);
        fertilizerInformationService.deleteFertilizerInformation(map);
        return "redirect:/toFertilizer";
    }

    /**
     * 跳转到新增化肥信息页面
     *
     * @return
     */
    @RequestMapping("/toAddFertilizer")
    public String toAddFertilizer() {
        return "fertilizerManagement/addFertilizer";
    }


    /**
     * 新增化肥信息的请求
     *
     * @param fertilizerName
     * @return
     */
    @RequestMapping("/insertFertilizerInformation")
    public String insertFertilizerInformation(String fertilizerName) {
        Map<String, Object> map = new HashMap<>();
        map.put("fertilizerName", fertilizerName);
        map.put("status", 1);
        fertilizerInformationService.insertFertilizerInformation(map);
        return "redirect:/toFertilizer";
    }

    /**
     * 跳转到化肥入库记录
     *
     * @param model
     * @return
     */
    @RequestMapping("/toFertilizerWarehousing")
    public String toFertilizerWarehousing(Model model) {
        model.addAttribute("list", fertilizerInformationService.queryFertilizerInformationList(new HashMap<>()));
        return "fertilizerManagement/fertilizerWarehousing";
    }

    /**
     * 跳转到化肥入库操作页面
     *
     * @param model
     * @param fertilizerId
     * @return
     */
    @RequestMapping("/toUpdatFertilizerWwarehousing/{fertilizerId}")
    public String toUpdatFertilizerWwarehousing(Model model, @PathVariable("fertilizerId") String fertilizerId) {
        Map<String, Object> map = new HashMap<>();
        map.put("fertilizerId", fertilizerId);
        model.addAttribute("list", fertilizerInformationService.queryFertilizerInformation(map));
        model.addAttribute("SeedInformation", supplierService.querySupplierList(new HashMap<>()));

        return "fertilizerManagement/updatFertilizerWwarehousing";
    }

    /**
     * 化肥入库操作的请求
     *
     * @param fertilizerId
     * @param inNum
     * @param supplierName
     * @return
     */
    @RequestMapping("/updatFertilizerWwarehousing")
    public String updatFertilizerWwarehousing(String fertilizerId, String inNum, String supplierName) {
        Date date = new Date();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("supplierName", supplierName);
        Supplier supplier = supplierService.querySupplier(map1);

        Map<String, Object> map = new HashMap<>();
        map.put("fertilizerId", fertilizerId);
        map.put("inNum", inNum);
        map.put("updateTime", date);
        map.put("supplierId", supplier.getSupplierId());
        fertilizerInformationService.updateFertilizerInformation(map);
        return "redirect:/toFertilizer";
    }


}
