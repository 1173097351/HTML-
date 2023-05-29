package com.zhou.controller;

import com.zhou.pojo.*;
import com.zhou.service.ParcelService;
import com.zhou.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    @Resource
    ProductService productService;

    @Resource
    ParcelService parcelService;

    static String id;       //园区id


    //跳转到农产品信息页面
    @RequestMapping("/toAgriculturalProductInformation")
    public String toAgriculturalProductInformation(Model model) {
        List<AgriculturalProductInformation> list = productService.queryProductList();
        model.addAttribute("list", list);
        return "product/agriculturalProductInformation";
    }

    //跳转到修改农产品信息页面
    @RequestMapping("/toUpdateAgriculturalProductInformation/{agrId}")
    public String toUpdateAgriculturalProductInformation(Model model, @PathVariable("agrId") String agrId) {
        AgriculturalProductInformation agriculturalProductInformation = productService.queryProductId(agrId);
        model.addAttribute("list", agriculturalProductInformation);
        return "product/updateAgriculturalProductInformation";
    }

    //修改农产品信息的请求
    @RequestMapping("/updateAgriculturalProductInformation")
    public String updateAgriculturalProductInformation(String agrId, String username, String storageNum, String inNum,
                                                       Map<String, Object> map) {
        Date date = new Date();
        System.out.println(agrId);
        map.put("username", username);
        map.put("storageNum", storageNum);
        map.put("inNum", inNum);
        map.put("updateTime", date);
        productService.updateProduct(map);
        return "redirect:/toAgriculturalProductInformation";
    }

    //删除农产品信息的请求
    @RequestMapping("/deleteProductMap/{agrId}")
    public String deleteProductMap(@PathVariable("agrId") String agrId, Map<String, Object> map) {
        map.put("agrId", agrId);
        productService.deleteProductMap(map);
        productService.deleteAgrinMap(map);
        return "redirect:/toAgriculturalProductInformation";
    }

    //跳转到新增农产品信息页面
    @RequestMapping("/toInsertAgriculturalProductInformation")
    public String toInsertAgriculturalProductInformation(Model model) {
        List<Crop> list = parcelService.queryCrop(id);
        model.addAttribute("list", list);
        return "product/insertAgriculturalProductInformation";
    }


    //新增农产品信息的请求
    @RequestMapping("/insertProduct")
    public String insertProduct(String cropId, String username, String storageNum, String inNum, Map<String, Object> map) {
        map.put("cropId", cropId);
        map.put("username", username);
        map.put("storageNum", storageNum);
        map.put("inNum", inNum);
        map.put("status", 1);
        productService.insertProduct(map);
        return "redirect:/toAgriculturalProductInformation";
    }

    //查询农产品进库记录的请求
    @RequestMapping("/queryAgrinList/{agrId}")
    public String queryAgrinList(@PathVariable("agrId") String agrId, Model model) {
        AgriculturalProductInformation agriculturalProductInformation = productService.queryAgrinList(agrId);
        model.addAttribute("username", agriculturalProductInformation.getUsername());
        model.addAttribute("list", agriculturalProductInformation.getAgrin());
        return "product/agrin";
    }

    //跳转农产品信息页面
    @RequestMapping("/toApi")
    public String toApi() {
        return "redirect:/toAgriculturalProductInformation";
    }

    //跳转新增农产品进库记录页面
    @RequestMapping("/toInsertAgrin")
    public String toInsertAgrin(Model model) {
        List<AgriculturalProductInformation> list = productService.queryProductList();
        model.addAttribute("list", list);
        return "product/insertAgrin";
    }

    //新增农产品进库记录的请求
    @RequestMapping("/insertAgrin")
    public String insertAgrin(String username, String inNum, Map<String, Object> map) {
        Date date = new Date();
        map.put("agrId", productService.queryProductUsername(username).getAgrId());
        map.put("inNum", inNum);
        map.put("updateTime", date);
        map.put("status", 1);
        productService.insertAgrin(map);
        return "redirect:/toAgriculturalProductInformation";
    }

    //跳转到进库的宏观分析页面
    @RequestMapping("/toAgriculturalProductsMacroscopical")
    public String toAgriculturalProductsMacroscopical() {
        return "product/agriculturalProductsMacroscopical";
    }


    //进库的宏观分析的请求
    @RequestMapping("product/agriculturalProductsMacroscopical")
    @ResponseBody
    public Map<String, Object> agriculturalProductsMacroscopical() {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        List<AgriculturalProductInformation> list = productService.queryMacroscopical();
        String[] username = new String[list.size()];      //农产品名称
        double[] inNum = new double[list.size()];       //进库量
        int i = 0;
        for (AgriculturalProductInformation agriculturalProductInformation : list) {
            username[i] = agriculturalProductInformation.getUsername();
            for (Agrin cm : productService.queryMacroscopicalUsername(username[i])) {
                inNum[i] += cm.getInNum();
            }
            i++;
        }

        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("inNum", inNum);
        return map;
    }

    //跳转到进库的微观分析页面
    @RequestMapping("/toAgriculturalProductsMicrocosmic")
    public String toAgriculturalProductsMicrocosmic() {
        return "product/agriculturalProductsMicrocosmic";
    }

    //进库的微观分析的请求
    @RequestMapping("product/agriculturalProductsMicrocosmic")
    @ResponseBody
    public Map<String, Object> agriculturalProductsMicrocosmic() {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        List<Agrin> agrins = productService.queryMicrocosmic();
        String[] updateTime = new String[agrins.size()];      //进库日期名称
        double[] inNum = new double[agrins.size()];       //进库量
        int i = 0;
        for (Agrin agrin : agrins) {
            updateTime[i] = ft.format(agrin.getUpdateTime());
            inNum[i] = agrin.getInNum();
            i++;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("updateTime", updateTime);
        map.put("inNum", inNum);
        return map;
    }

    //销售记录查询的请求
    @RequestMapping("/toSalesRecord/{agrId}")
    public String toSalesRecord(@PathVariable("agrId") String agrId, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("agrId", agrId);
        model.addAttribute("list", productService.querySalesRecordList(map));
        return "product/salesRecord";
    }

    //跳转到新增销售记录页面
    @RequestMapping("/toInsertSalesRecord")
    public String toInsertSalesRecord(Model model) {
        model.addAttribute("agency", productService.queryAgencyList());
        model.addAttribute("list", productService.queryProductList());
        return "product/insertSalesRecord";
    }

    //新增销售记录的请求
    @RequestMapping("/insertSalesRecord")
    public String insertSalesRecord(String outNum, String agrId, String distributorId, Model model) {
        Date date = new Date();
        List<Agency> agency = productService.queryAgencyList();
        model.addAttribute("agency", agency);
        List<AgriculturalProductInformation> list = productService.queryProductList();
        model.addAttribute("list", list);
        Map<String, Object> map = new HashMap<>();
        map.put("outNum", outNum);
        map.put("agrId", agrId);
        map.put("distributorId", distributorId);
        map.put("updateTime", date);
        map.put("status", 1);
        productService.insertSalesRecord(map);
        return "redirect:/toAgriculturalProductInformation";
    }


    //跳转到销售的宏观分析页面
    @RequestMapping("/toSalesRecordMacroAnalysis")
    public String toSalesRecordMacroAnalysis() {
        return "product/salesRecordMacroAnalysis";
    }

    //销售的宏观分析的请求
    @RequestMapping("product/salesRecordMacroAnalysis")
    @ResponseBody
    public Map<String, Object> salesRecordMacroAnalysis() {
        List<Agrout> agrouts = productService.querySalesRecord();
        String[] username = new String[agrouts.size()];      //农产品名称
        double[] outNum = new double[agrouts.size()];       //销售量
        int i = 0;
        for (Agrout agrout : agrouts) {
            username[i] = agrout.getAgriculturalProductInformation().getUsername();
            outNum[i] += agrout.getOutNum();
            i++;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("outNum", outNum);
        return map;
    }

    //跳转到销售的微观分析页面
    @RequestMapping("/toSalesRecordMicroscopicAnalysis")
    public String toSalesRecordMicroscopicAnalysis() {
        return "product/salesRecordMicroscopicAnalysis";
    }

    //销售的微观分析的请求
    @RequestMapping("product/salesRecordMicroscopicAnalysis")
    @ResponseBody
    public Map<String, Object> salesRecordMicroscopicAnalysis() {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        List<Agrout> agrouts = productService.querySalesRecord();
        String[] updateTime = new String[agrouts.size()];      //进库日期名称
        double[] inNum = new double[agrouts.size()];       //进库量
        int i = 0;
        for (Agrout Agrout : agrouts) {
            updateTime[i] = ft.format(Agrout.getUpdateTime());
            inNum[i] = Agrout.getOutNum();
            i++;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("updateTime", updateTime);
        map.put("inNum", inNum);
        return map;
    }

}