package com.zhou.controller;

import com.zhou.service.AgencyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AgencyController {

    @Resource
    private AgencyService agencyService;

    /**
     * 跳转到农资商管理页面
     *
     * @return
     */
    @RequestMapping("/toAgency")
    public String toAgency(Model model) {
        model.addAttribute("list", agencyService.queryAgencyList(new HashMap<>()));
        return "operatorManagement/agency";
    }

    /**
     * 跳转到新增经营商页面
     *
     * @return
     */
    @RequestMapping("/toAddAgency")
    public String toAddAgency() {
        return "operatorManagement/addAgency";
    }

    /**
     * 新增经营商信息
     *
     * @param distributoridName
     * @param distributoridAddress
     * @param contactPerson
     * @param contactMethod
     * @return
     */
    @RequestMapping("/insertAgency")
    public String insertAgency(String distributoridName, String distributoridAddress, String contactPerson, String contactMethod) {
        Map<String, Object> map = new HashMap<>();
        map.put("distributoridName", distributoridName);
        map.put("distributoridAddress", distributoridAddress);
        map.put("contactPerson", contactPerson);
        map.put("contactMethod", contactMethod);
        map.put("status", 1);
        agencyService.insertAgency(map);
        return "redirect:/toAgency";
    }

    /**
     * 跳转到修改经营商信息页面
     *
     * @return
     */
    @RequestMapping("/toUpdateAgency/{distributorId}")
    public String toUpdateAgency(@PathVariable("distributorId") String distributorId, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("distributorId", distributorId);
        model.addAttribute("list", agencyService.queryAgency(map));
        return "operatorManagement/updateAgency";
    }

    /**
     * 修改经营商的请求
     *
     * @param distributorId
     * @param distributoridName
     * @param distributoridAddress
     * @param contactPerson
     * @param contactMethod
     * @return
     */
    @RequestMapping("/updateAgency")
    public String updateAgency(String distributorId, String distributoridName, String distributoridAddress, String contactPerson, String contactMethod) {
        Map<String, Object> map = new HashMap<>();
        map.put("distributorId", distributorId);
        map.put("distributoridName", distributoridName);
        map.put("distributoridAddress", distributoridAddress);
        map.put("contactPerson", contactPerson);
        map.put("contactMethod", contactMethod);
        map.put("updateTime", new Date());
        agencyService.updateAgency(map);
        return "redirect:/toAgency";
    }

    /**
     * 根据id，删除经营商信息
     *
     * @param distributorId
     * @return
     */
    @RequestMapping("/deleteAgency/{distributorId}")
    public String deleteAgency(@PathVariable("distributorId") String distributorId) {
        Map<String, Object> map = new HashMap<>();
        map.put("distributorId", distributorId);
        agencyService.deleteAgency(map);
        return "redirect:/toAgency";
    }

}
