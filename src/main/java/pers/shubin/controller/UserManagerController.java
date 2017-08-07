package pers.shubin.controller;
/**
 * @description:
 * @author: hongshubin
 * @requireNo:
 * @createdate: 2017-07-27 10:50
 * @lastdate:
 */

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pers.shubin.domain.User;
import pers.shubin.service.interfaces.UserService;

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
public class UserManagerController {
    @Autowired
    UserService userService;

    @RequestMapping(value = {"/userManager"},method = {RequestMethod.GET})
    public String getPage(HttpServletRequest req){
        return "userManager";
    }


    @RequestMapping(value = "/userManager/add",method = {RequestMethod.POST})
    @ResponseBody
    public String insertUser(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Map<String, String> resultMap = new HashMap();
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        User user = userService.getUserByName(username);
        if (user != null) {
            resultMap.put("msg","用户已存在");
            resultMap.put("rtn","100");
        } else {
            Long id = userService.insertUser(username, pwd);
            resultMap.put("msg",String.format("sign up %d users",id));
            resultMap.put("rtn","200");
        }
        return JSON.toJSONString(resultMap);
    }
    @RequestMapping(value = "/userManager/delete",method = {RequestMethod.POST})
    @ResponseBody
    public String deleteUser(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        int resultNum = userService.deleteUserByName(username, pwd);
        Map resultMap = new HashMap<String,Integer>();
        resultMap.put("msg",String.format("delete %d users",resultNum));
        resultMap.put("rtn",resultNum >= 1 ? "200" : "100");
        return JSON.toJSONString(resultMap);
    }
    @RequestMapping(value = "/userManager/find",method = {RequestMethod.POST})
    @ResponseBody
    public String findUser(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Map<String, String> resultMap = new HashMap();
        String username = req.getParameter("username");
        User user = userService.getUserByName(username);
        if (user == null){
            resultMap.put("msg","查无用户");
            resultMap.put("rtn","100");
        }else {
            Map userMap = new HashMap<String, Long>();
            userMap.put("username", user.getUsername());
            userMap.put("created", user.getCreated());
            userMap.put("modified", user.getModified());
            userMap.put("result", "success");
            resultMap.put("msg",JSON.toJSONString(userMap));
            resultMap.put("rtn","200");
        }
        return JSON.toJSONString(resultMap);
    }
}
