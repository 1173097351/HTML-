package com.zhou.controller;

import com.zhou.pojo.UserAccount;
import com.zhou.pojo.UserInformation;
import com.zhou.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    static UserAccount user_account;

    static UserInformation userInformation;


    //跳转到登陆页面
    @RequestMapping("/gologin")
    public String test() {
        return "login";
    }

    /**
     * 登陆功能的请求
     *
     * @param session
     * @param model
     * @param uaccount
     * @param upassword
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpSession session, Model model, String uaccount, String upassword) {
        user_account = userService.queryUser(uaccount, upassword);
        session.setAttribute("uaccount", uaccount);
        if (session.getAttribute("uaccount") != null && user_account != null) {
            model.addAttribute("msg", user_account.getUnick_name());
            List<UserInformation> list = userService.queryListUserInformation(user_account.getUid());
            for (UserInformation information : list) {
                String parkId = information.getParkId();
                ParcelController.id = parkId;
                ProductController.id = parkId;
            }
            return "main";
        }
        model.addAttribute("msg", "请重新登陆！");
        return "login";
    }


    /**
     * 注销功能的请求
     *
     * @param session
     * @return
     */
    @RequestMapping("/zx")
    public String zx(HttpSession session) {
        //让session过期
        session.invalidate();
        return "login";
    }

    /**
     * 查看用户信息、农园信息的请求
     *
     * @param model
     * @return
     */
    @RequestMapping("/userInformation")
    public String userInformation(Model model) {
        List<UserInformation> list = userService.queryListUserInformation(user_account.getUid());
        model.addAttribute("list", list);
        return "userInformation";
    }

    /**
     * 跳转到修改页面
     *
     * @param model
     * @param uid
     * @return
     */
    @RequestMapping("/toUpdateUser/{uid}")
    public String toUpdateUser(Model model, @PathVariable("uid") String uid) {
        userInformation = userService.userInformation(uid);
        model.addAttribute("userInformation", userInformation);
        return "updateUserInformation";
    }

    /**
     * 修改用户信息请求
     *
     * @param map
     * @param uid
     * @param unick_name
     * @param upassword
     * @param parkName
     * @return
     */
    @RequestMapping("/updateUser")
    public String updateUser(Map<String, Object> map, String uid, String unick_name, String upassword, String parkName,
                             String parkAddress, String concatPerson, String concatMethod) {
        Date date = new Date();
        map.put("uid", uid);
        map.put("unick_name", unick_name);
        map.put("upassword", upassword);
        map.put("updateTime", date);
        map.put("parkName", parkName);
        map.put("parkAddress", parkAddress);
        map.put("concatPerson", concatPerson);
        map.put("concatMethod", concatMethod);
        map.put("updateTime", date);
        userService.updateUser(map);
        user_account.setUid(uid);
        return "redirect:/userInformation";
    }

    //跳转到主页
    @RequestMapping("/toMain")
    public String toMain(Model model) {
        model.addAttribute("msg", user_account.getUnick_name());
        return "main";
    }


}
