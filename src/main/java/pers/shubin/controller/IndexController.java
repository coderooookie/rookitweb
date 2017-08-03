package pers.shubin.controller;
/**
 * @description:
 * @author: hongshubin
 * @requireNo:
 * @createdate: 2017-07-27 15:43
 * @lastdate:
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pers.shubin.service.interfaces.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hongshubin on 2017/7/27.
 */
@Controller
public class IndexController {
    @Autowired
    private UserService userService;
    @RequestMapping(value={"","/index"},method = RequestMethod.GET)
    public String getIndex(HttpServletRequest req, HttpServletResponse res){
        return "index";
    }

    @RequestMapping(value="/index",method = RequestMethod.POST)
    @ResponseBody
    public String test(HttpServletRequest req, HttpServletResponse res){
        String result = userService.getUserByName(req.getParameter("username")).toString();
        return result;
    }
}
