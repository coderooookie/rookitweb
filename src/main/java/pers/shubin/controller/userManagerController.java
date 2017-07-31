package pers.shubin.controller;
/**
 * @description:
 * @author: hongshubin
 * @requireNo:
 * @createdate: 2017-07-27 10:50
 * @lastdate:
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
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
public class userManagerController {
    @Autowired
    UserService userService;

    @RequestMapping(value = {"/userManager","/userManager/*"},method = {RequestMethod.GET})
    public String getPage(HttpServletRequest req){
        return "userManager";
    }


    @RequestMapping(value = "/userManager/add",method = {RequestMethod.POST})
    public ModelAndView insertUser(HttpServletRequest req, HttpServletResponse res) throws IOException {
        ModelAndView view = new ModelAndView("userManager");
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        Long id = userService.insertUser(username, pwd);
        Map result = new HashMap<String,Long>();
        result.put("id",id);
        view.addObject("resultString",result.toString());
        System.out.println(result.toString());
        return view;
    }
    @RequestMapping(value = "/userManager/delete",method = {RequestMethod.POST})
    public ModelAndView deleteUser(HttpServletRequest req, HttpServletResponse res) throws IOException {
        ModelAndView view = new ModelAndView("userManager");
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        int resultNum = userService.deleteUserByName(username, pwd);
        Map result = new HashMap<String,Integer>();
        result.put("resultNum",resultNum);
        System.out.println(result.toString());
        view.addObject("resultString",result.toString());
        return view;
    }

}