package com.zhou.controller;


import com.zhou.pojo.*;
import com.zhou.service.ParcelService;
import com.zhou.service.UserService;
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
public class ParcelController {

    @Resource
    private ParcelService parcelService;

    @Resource
    private UserService userService;

    static String id;

    static String park_id;      //园区id

    static String agrId;       //农产品id

    static String cropId;       //农作物id

    /**
     * 根据园区id，查询地块信息
     *
     * @param model
     * @return
     */
    @RequestMapping("/queryListParcel")
    public String queryListParcel(Model model) {
        List<ParcelInformation> parcelInformations = parcelService.queryLand(id);
        model.addAttribute("list", parcelInformations);
        return "parkInformation";
    }


    /**
     * 跳转到修改页面
     *
     * @param model
     * @param landId
     * @return
     */
    @RequestMapping("/toQueryLandId/{landId}")
    public String toQueryLandId(Model model, @PathVariable("landId") String landId) {
        ParcelInformation parcelInformation = parcelService.queryLandId(landId);
        List<AgriculturalProductInformation> list = parcelService.queryAgriculturalProductInformation();
        model.addAttribute("list", list);
        model.addAttribute("crop", parcelInformation);
        return "updateLand";
    }


    /**
     * 修改地块信息请求
     *
     * @param map
     * @param landId
     * @param landName
     * @param lande
     * @param lands
     * @param landw
     * @param landn
     * @param landSize
     * @param username
     * @return
     */
    @RequestMapping("/updateLand")
    public String updateLand(Map<String, Object> map, String landId, String landName, String lande,
                             String lands, String landw, String landn, String landSize, String username) {
        AgriculturalProductInformation agriculturalProductInformation = parcelService.queryAgriculturalProductInformationName(username);
        String agrId = agriculturalProductInformation.getAgrId();
        Date date = new Date();
        map.put("landId", landId);
        map.put("landName", landName);
        map.put("lande", lande);
        map.put("lands", lands);
        map.put("landw", landw);
        map.put("landn", landn);
        map.put("landSize", landSize);
        map.put("updateTime", date);
        map.put("agrId", agrId);
        parcelService.updateLand(map);
        return "redirect:/queryListParcel";
    }

    //跳转到主页
    @RequestMapping("/toLandMain")
    public String toMain(Model model) {
        String unick_name = UserController.user_account.getUnick_name();
        model.addAttribute("msg", unick_name);
        return "main";
    }

    //根据id删除地块信息的请求
    @RequestMapping("/deleteLand/{landId}")
    public String deleteLand(@PathVariable("landId") String landId) {
        parcelService.deleteLand(landId);
        return "redirect:/queryListParcel";
    }

    //跳转到增加地块信息页面
    @RequestMapping("/toInsertLand")
    public String toInsertLand(Model model) {
        List<AgriculturalProductInformation> list = parcelService.queryAgriculturalProductInformation();
        model.addAttribute("list", list);
        return "insertLand";
    }

    /**
     * 增加地块信息的请求
     *
     * @param map
     * @param landName
     * @param lande
     * @param lands
     * @param landw
     * @param landn
     * @param landSize
     * @param username
     * @param model
     * @return
     */
    @RequestMapping("/insertLand")
    public String insertLand(Map<String, Object> map, String landName, String lande, String lands, String landw, String landn,
                             String landSize, String username, Model model) {
        agrId = null;
        if (!username.equals("")) {
            AgriculturalProductInformation agriculturalProductInformation = parcelService.queryAgriculturalProductInformationName(username);
            agrId = agriculturalProductInformation.getAgrId();
        }
        Date date = new Date();
        List<UserInformation> list = userService.queryListUserInformation(UserController.user_account.getUid());
        for (UserInformation userInformation : list) {
            park_id = userInformation.getParkId();
        }
        List<ParcelInformation> parcelInformations = parcelService.queryLandName(landName);
        if (parcelInformations.isEmpty()) {
            map.put("parkId", park_id);
            map.put("landName", landName);
            map.put("lande", lande);
            map.put("lands", lands);
            map.put("landw", landw);
            map.put("landn", landn);
            map.put("landSize", landSize);
            map.put("updateTime", date);
            map.put("status", 1);
            map.put("agrId", agrId);
            parcelService.insertLand(map);
            return "redirect:/queryListParcel";
        } else {
            model.addAttribute("msg", "重复名称，请重新输入！");
            return "insertLand";
        }
    }

    /**
     * 根据园区id，查询农作物信息
     *
     * @param model
     * @return
     */
    @RequestMapping("/queryCrop")
    public String queryCrop(Model model) {
        List<Crop> crops = parcelService.queryCrop(id);
        model.addAttribute("list", crops);
        return "crop";
    }


    /**
     * 跳转到修改农作物页面
     *
     * @param model
     * @param cropId
     * @return
     */
    @RequestMapping("/toUpdateCrop/{cropId}")
    public String toUpdateCrop(Model model, @PathVariable("cropId") String cropId) {
        Crop crop = parcelService.queryId(cropId);
        model.addAttribute("crop", crop);

        List<ParcelInformation> ParcelInformation = parcelService.queryLand(id);
        model.addAttribute("list", ParcelInformation);

        List<SeedInformation> seedInformation = parcelService.querySeedInformation();
        model.addAttribute("seed", seedInformation);
        return "updateCrop";
    }

    /**
     * 修改农作物信息的请求
     *
     * @param map
     * @param cropId
     * @param cropName
     * @param seed
     * @param parcel
     * @return
     */
    @RequestMapping("/updateCrop")
    public String updateCrop(Map<String, Object> map, String cropId, String cropName, String seed, String parcel) {
        Date date = new Date();
        map.put("cropId", cropId);
        String i = parcelService.queryParcelInformationLandName(parcel);
        map.put("landId", i);
        String i1 = parcelService.querySeedInformationSeedName(seed);
        map.put("seedId", i1);
        map.put("cropName", cropName);
        map.put("updateTime", date);
        parcelService.updateCrop(map);
        return "redirect:/queryCrop";
    }

    /**
     * 根据农作物id，删除农作物
     *
     * @param cropId
     * @return
     */
    @RequestMapping("/deleteCrop/{cropId}")
    public String deleteCrop(@PathVariable("cropId") String cropId) {
        parcelService.deleteCropId(cropId);
        return "redirect:/queryCrop";
    }


    /**
     * 跳转到增加农作物信息页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/toInsertCrop")
    public String toInsertCrop(Model model) {
        List<ParcelInformation> ParcelInformation = parcelService.queryLand(id);
        model.addAttribute("list", ParcelInformation);
        List<SeedInformation> seedInformation = parcelService.querySeedInformation();
        model.addAttribute("seed", seedInformation);
        return "insertCrop";
    }


    /**
     * 新增农作物信息的请求
     *
     * @param map
     * @param cropName
     * @param list
     * @param seed
     * @return
     */
    @RequestMapping("/insertCrop")
    public String insertCrop(Map<String, Object> map, String cropName, String list, String seed, Model model) {
        String i = new String();
        Date date = new Date();
        try {
            i = parcelService.queryParcelInformationLandName(list);
        } catch (Exception e) {
            model.addAttribute("msg", "该地块已被选择");
            e.printStackTrace();
        }
        map.put("landId", i);
        String i1 = parcelService.querySeedInformationSeedName(seed);
        map.put("seedId", i1);
        map.put("cropName", cropName);
        map.put("updateTime", date);
        map.put("status", 1);
        parcelService.insertCrop(map);
        return "redirect:/queryCrop";
    }


    /**
     * 根据农作物id，查询施肥信息、化肥信息
     *
     * @param cropId
     * @param model
     * @return
     */
    @RequestMapping("/queryFertilize/{cropId}")
    public String queryFertilize(@PathVariable("cropId") String cropId, Model model) {
        List<FertilizationInformation> crops = parcelService.queryFertilize(cropId);
        for (FertilizationInformation crop : crops) {
            this.cropId = crop.getCropId();
        }
        model.addAttribute("list", crops);
        return "fertilizationRecord";
    }

    //跳转到农作物信息页面
    @RequestMapping("/toCrop")
    public String toCrop() {
        return "redirect:/queryCrop";
    }

    /**
     * 跳转到新增施肥记录页面
     *
     * @param cropId
     * @param model
     * @return
     */
    @RequestMapping("/toInsertFertilize/{cropId}")
    public String toInsertFertilize(@PathVariable("cropId") String cropId, Model model) {
        List<FertilizerInformation> fertilizerInformations = parcelService.queryFertilizer();
        model.addAttribute("list", fertilizerInformations);
        model.addAttribute("crop", cropId);
        return "insertFertilize";
    }

    /**
     * 新增施肥记录的请求
     *
     * @param map
     * @param cropId
     * @param fertilizerName
     * @param applyNum
     * @return
     */
    @RequestMapping("/insertFertilize")
    public String insertFertilize(Map<String, Object> map, String cropId, String fertilizerName,
                                  String applyNum) {
        String fertilizerId = parcelService.queryFertilizerName(fertilizerName);
        Date date = new Date();
        map.put("fertilizerId", fertilizerId);
        map.put("cropId", cropId);
        map.put("applyNum", applyNum);
        map.put("applyTime", date);
        map.put("status", 1);
        parcelService.insertFertilize(map);
        return "redirect:/queryCrop";
    }

    //跳转到施肥记录宏观分析页面
    @RequestMapping("/toFertilizeMacroAnalysis")
    public String toFertilizeMacroAnalysis() {
        return "fertilizeMacroAnalysis";
    }

    //施肥记录宏观分析的请求
    @RequestMapping("/fertilizeMacroAnalysis")
    @ResponseBody
    public Map<String, Object> fertilizeMacroAnalysis() {
        List<FertilizationInformation> crops = parcelService.queryFertilize(cropId);
        String[] btArr = new String[crops.size()];      //化肥名称
        double[] numArr = new double[crops.size()];       //施肥量
        int i = 0;
        for (FertilizationInformation crop : crops) {
            btArr[i] = crop.getFertilizerInformation().getFertilizerName();
            numArr[i] = crop.getApplyNum();
            i++;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("btArr", btArr);
        map.put("numArr", numArr);
        return map;
    }

    //跳转到施肥记录微观分析页面
    @RequestMapping("/toFertilizeMicroscopicAnalysis")
    public String toFertilizeMicroscopicAnalysis() {
        return "fertilizeMicroscopicAnalysis";
    }

    //施肥记录微观分析的请求
    @RequestMapping("/fertilizeMicroscopicAnalysis")
    @ResponseBody
    public Map<String, Object> fertilizeMicroscopicAnalysis() {
        List<FertilizationInformation> crops = parcelService.queryFertilize(cropId);
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String[] fertilizerName = new String[crops.size()];      //化肥名称
        String[] applyTime = new String[crops.size()];       //施肥日期
        int i = 0;
        for (FertilizationInformation crop : crops) {
            fertilizerName[i] = crop.getFertilizerInformation().getFertilizerName();
            String s = ft.format(crop.getApplyTime());
            applyTime[i] = s;
            i++;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("fertilizerName", fertilizerName);
        map.put("applyTime", applyTime);
        return map;
    }

    /**
     * 跳转到新增施药记录页面
     *
     * @param cropId
     * @param model
     * @return
     */
    @RequestMapping("/toInsertApplyMedicine/{cropId}")
    public String toInsertApplyMedicine(@PathVariable("cropId") String cropId, Model model) {
        List<PesticideInformation> pesticideInformations = parcelService.queryApplyMedicine();
        model.addAttribute("list", pesticideInformations);
        model.addAttribute("crop", cropId);
        return "insertApplyMedicine";
    }


    /**
     * 新增施药记录的请求
     *
     * @param map
     * @param cropId
     * @param pesticideName
     * @param applyNum
     * @return
     */
    @RequestMapping("/insertApplyMedicine")
    public String insertApplyMedicine(Map<String, Object> map, String cropId, String pesticideName,
                                      String applyNum) {
        String pesticideId = parcelService.queryApplyMedicineName(pesticideName);
        Date date = new Date();
        map.put("pesticideId", pesticideId);
        map.put("cropId", cropId);
        map.put("applyNum", applyNum);
        map.put("applyTime", date);
        map.put("updateTime", date);
        map.put("status", 1);
        parcelService.insertApplyMedicine(map);
        return "redirect:/queryCrop";
    }

    /**
     * 跳转到施药记录的页面的请求
     *
     * @param model
     * @param cropId
     * @return
     */
    @RequestMapping("/queryApplyMedicine/{cropId}")
    public String queryApplyMedicine(Model model, @PathVariable("cropId") String cropId) {
        List<ApplyInformation> applyInformations = parcelService.queryApplyMedicineId(cropId);
        for (ApplyInformation applyInformation : applyInformations) {
            this.cropId = applyInformation.getCropId();
        }
        model.addAttribute("list", applyInformations);
        return "ApplyMedicine";
    }


    //跳转到施药记录宏观分析页面
    @RequestMapping("/toApplyMedicineMacroscopical")
    public String toApplyMedicineMacroscopical() {
        return "ApplyMedicineMacroscopical";
    }

    //施药记录宏观分析的请求
    @RequestMapping("/applyMedicineMacroscopical")
    @ResponseBody
    public Map<String, Object> applyMedicineMacroscopical() {
        List<ApplyInformation> applyInformations = parcelService.queryApplyMedicineId(cropId);
        String[] btArr = new String[applyInformations.size()];      //农药名称
        double[] numArr = new double[applyInformations.size()];       //施药量
        int i = 0;
        for (ApplyInformation applyInformation : applyInformations) {
            btArr[i] = applyInformation.getPesticideInformation().getPesticideName();
            numArr[i] = applyInformation.getApplyNum();
            i++;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("btArr", btArr);
        map.put("numArr", numArr);
        return map;
    }

    //跳转到施药记录微观分析页面
    @RequestMapping("/toApplyMedicineMicrocosmic")
    public String toApplyMedicineMicrocosmic() {
        return "ApplyMedicineMicrocosmic";
    }

    //施药记录微观分析的请求
    @RequestMapping("/applyMedicineMicrocosmic")
    @ResponseBody
    public Map<String, Object> applyMedicineMicrocosmic() {
        List<ApplyInformation> applyInformations = parcelService.queryApplyMedicineId(cropId);
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String[] fertilizerName = new String[applyInformations.size()];      //农药名称
        String[] applyTime = new String[applyInformations.size()];       //施药日期
        int i = 0;
        for (ApplyInformation applyInformation : applyInformations) {
            fertilizerName[i] = applyInformation.getPesticideInformation().getPesticideName();
            applyTime[i] = ft.format(applyInformation.getApplyTime());
            i++;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("fertilizerName", fertilizerName);
        map.put("applyTime", applyTime);
        return map;
    }

    /**
     * 查询灌溉记录的请求
     *
     * @param model
     * @param cropId
     * @return
     */
    @RequestMapping("/queryIrrigationInformation/{cropId}")
    public String queryIrrigationInformation(Model model, @PathVariable("cropId") String cropId) {
        List<IrrigationInformation> irrigationInformations = parcelService.queryIrrigationInformation(cropId);
        for (IrrigationInformation irrigationInformation : irrigationInformations) {
            this.cropId = irrigationInformation.getCropId();
        }
        model.addAttribute("list", irrigationInformations);
        return "irrigationInformation";
    }

    /**
     * 跳转到新增灌溉记录页面
     *
     * @param cropId
     * @param model
     * @return
     */
    @RequestMapping("/toInsertIrrigationInformation/{cropId}")
    public String toInsertIrrigationInformation(@PathVariable("cropId") String cropId, Model model) {
        model.addAttribute("crop", cropId);
        return "InsertIrrigationInformation";
    }

    /**
     * 新增灌溉记录的请求
     *
     * @param cropId
     * @param model
     * @param map
     * @param irrigationNum
     * @return
     */
    @RequestMapping("/insertIrrigationInformation")
    public String insertIrrigationInformation(String cropId, Model model, Map<String, Object> map, double irrigationNum) {
        Date date = new Date();
        map.put("cropId", cropId);
        map.put("irrigationNum", irrigationNum);
        map.put("irrigationTime", date);
        map.put("status", 1);
        parcelService.insertIrrigationInformation(map);
        model.addAttribute("crop", cropId);
        return "redirect:/queryCrop";
    }


    //跳转到施药记录宏观分析页面
    @RequestMapping("/toIrrigationMacroscopical")
    public String toIrrigationMacroscopical() {
        return "irrigationMacroscopical";
    }

    //灌溉记录宏观分析的请求
    @RequestMapping("/irrigationMacroscopical")
    @ResponseBody
    public Map<String, Object> irrigationMacroscopical() {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        List<IrrigationInformation> irrigationInformations = parcelService.queryIrrigationInformation(cropId);
        String[] time = new String[irrigationInformations.size()];      //灌溉时间
        double[] quantity = new double[irrigationInformations.size()];       //灌溉量
        int i = 0;
        for (IrrigationInformation irrigationInformation : irrigationInformations) {
            time[i] = ft.format(irrigationInformation.getIrrigationTime());
            quantity[i] = irrigationInformation.getIrrigationNum();
            i++;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("time", time);
        map.put("quantity", quantity);
        return map;
    }

//    //返回到灌溉记录页面
//    @RequestMapping("toIrrigationInformation")
//    public String toIrrigationInformation(){
//        return "irrigationInformation";
//    }


    //跳转到施药记录微观分析页面
    @RequestMapping("/toIrrigationmicrocosmic")
    public String toIrrigationmicrocosmic() {
        return "irrigationmicrocosmic";
    }

    //施药记录微观分析的请求
    @RequestMapping("/irrigationmicrocosmic")
    @ResponseBody
    public Map<String, Object> irrigationmicrocosmic() {
        List<ApplyInformation> applyInformations = parcelService.queryApplyMedicineId(cropId);
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String[] fertilizerName = new String[applyInformations.size()];      //农药名称
        String[] applyTime = new String[applyInformations.size()];       //施药日期
        int i = 0;
        for (ApplyInformation applyInformation : applyInformations) {
            fertilizerName[i] = applyInformation.getPesticideInformation().getPesticideName();
            String s = ft.format(applyInformation.getApplyTime());
            applyTime[i] = s;
            i++;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("fertilizerName", fertilizerName);
        map.put("applyTime", applyTime);
        return map;
    }

}
