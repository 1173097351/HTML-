package com.zhou.controller;

import com.zhou.pojo.Supplier;
import com.zhou.service.SupplierService;
import com.zhou.service.ToolsInformationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ToolsInformationController {
    @Resource
    ToolsInformationService toolsInformationService;

    @Resource
    SupplierService supplierService;


    /**
     * 跳转到农具管理页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/toToolsInformation")
    public String toToolsInformation(Model model) {
        model.addAttribute("list", toolsInformationService.queryToolsInformationList(new HashMap<>()));
        return "toolManagement/toolsInformation";
    }

    /**
     * 跳转到修改农具信息页面
     *
     * @param model
     * @param toolId
     * @return
     */
    @RequestMapping("/toUpdateToolsInformation/{toolId}")
    public String toUpdateToolsInformation(Model model, @PathVariable("toolId") String toolId) {
        Map<String, Object> map = new HashMap<>();
        map.put("toolId", toolId);
        model.addAttribute("list", toolsInformationService.queryToolsInformationion(map));
        model.addAttribute("SeedInformation", supplierService.querySupplierList(new HashMap<>()));
        return "toolManagement/updateToolsInformation";
    }

    /**
     * 修改农具信息的请求
     *
     * @param toolId
     * @param toolName
     * @param supplierName
     * @return
     */
    @RequestMapping("/updateToolsInformation")
    public String updateToolsInformation(String toolId, String toolName, String supplierName) {
        Map<String, Object> map1 = new HashMap<>();
        map1.put("supplierName", supplierName);
        Supplier supplier = supplierService.querySupplier(map1);

        Map<String, Object> map = new HashMap<>();
        map.put("toolId", toolId);
        map.put("toolName", toolName);
        map.put("supplierId", supplier.getSupplierId());
        toolsInformationService.updateToolsInformation(map);
        return "redirect:/toToolsInformation";
    }

    /**
     * 删除农具信息的请求
     *
     * @param toolId
     * @return
     */
    @RequestMapping("/deleteToolsInformation/{toolId}")
    public String deleteToolsInformation(@PathVariable("toolId") String toolId) {
        Map<String, Object> map = new HashMap<>();
        map.put("toolId", toolId);
        toolsInformationService.deleteToolsInformation(map);
        return "redirect:/toToolsInformation";
    }

    /**
     * 跳转到新增农具信息页面
     *
     * @return
     */
    @RequestMapping("/toAddToolsInformation")
    public String toAddToolsInformation() {
        return "toolManagement/addToolsInformation";
    }


    /**
     * 新增农具信息的请求
     *
     * @param toolName
     * @return
     */
    @RequestMapping("/insertToolsInformation")
    public String insertToolsInformation(String toolName) {
        Map<String, Object> map = new HashMap<>();
        map.put("toolName", toolName);
        map.put("status", 1);
        toolsInformationService.insertToolsInformation(map);
        return "redirect:/toToolsInformation";
    }

    /**
     * 跳转到农具入库记录
     *
     * @param model
     * @return
     */
    @RequestMapping("/toToolsInformationWarehousing")
    public String toToolsInformationWarehousing(Model model) {
        model.addAttribute("list", toolsInformationService.queryToolsInformationList(new HashMap<>()));
        return "toolManagement/toolsInformationWarehousing";
    }

    /**
     * 跳转到农具管理页面
     *
     * @return
     */
    @RequestMapping("/tooToolsInformation")
    public String tooToolsInformation() {
        return "redirect:/toToolsInformation";
    }


    /**
     * 跳转到农具入库操作页面
     *
     * @param model
     * @param toolId
     * @return
     */
    @RequestMapping("/toUpdatToolsInformationWwarehousing/{toolId}")
    public String toUpdatToolsInformationWwarehousing(Model model, @PathVariable("toolId") String toolId) {
        Map<String, Object> map = new HashMap<>();
        map.put("toolId", toolId);
        model.addAttribute("list", toolsInformationService.queryToolsInformationion(map));
        model.addAttribute("SeedInformation", supplierService.querySupplierList(new HashMap<>()));
        return "toolManagement/updatToolsInformationWwarehousing";
    }

    /**
     * 农具入库操作的请求
     *
     * @param toolId
     * @param inNum
     * @param supplierName
     * @return
     */
    @RequestMapping("/updatToolsInformationWwarehousing")
    public String updatToolsInformationWwarehousing(String toolId, String inNum, String supplierName) {
        Date date = new Date();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("supplierName", supplierName);
        Supplier supplier = supplierService.querySupplier(map1);

        Map<String, Object> map = new HashMap<>();
        map.put("toolId", toolId);
        map.put("inNum", inNum);
        map.put("updateTime", date);
        map.put("supplierId", supplier.getSupplierId());
        toolsInformationService.updateToolsInformation(map);
        return "redirect:/toToolsInformation";
    }

}
