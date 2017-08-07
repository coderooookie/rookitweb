package pers.shubin.controller;
/**
 * @description:
 * @author: hongshubin
 * @requireNo:
 * @createdate: 2017-07-27 10:50
 * @lastdate:
 */

import com.alibaba.fastjson.JSON;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pers.shubin.domain.User;
import pers.shubin.service.interfaces.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hongshubin on 2017/7/27.
 */

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login",method = {RequestMethod.GET})
    public String loginPage(HttpServletRequest req){
        return "login";
    }


    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    @ResponseBody
    public int login(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String targetUrl = req.getParameter("targetUrl");
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        if (targetUrl == ""){targetUrl = "index";}
        if (userService.checkUser(username, pwd) > 0){
            Cookie loginCookie = new Cookie("user_id","rookie");
            Cookie usernameCookie = new Cookie("username",username);
            res.addCookie(loginCookie);
            res.addCookie(usernameCookie);
            loginCookie.setMaxAge(100);
            usernameCookie.setMaxAge(100);
            return 0;
        }else {
            return -1;
        }
    }

    @RequestMapping(value = "/logout",method = {RequestMethod.GET})
    @ResponseBody
    public String logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Map<String, String> resultMap = new HashMap();
        try{
            Cookie[] cookies = req.getCookies();
            for (Cookie cookie : cookies){
                cookie.setMaxAge(0);
                res.addCookie(cookie);
            }
            resultMap.put("result","已登出");
            resultMap.put("rtn","200");
        }catch (Exception e){
            resultMap.put("result","登出出错");
            resultMap.put("rtn","100");
        }
        return JSON.toJSONString(resultMap);
    }

}
