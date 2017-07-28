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
public class HelloController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/hello",method = RequestMethod.POST)
    @ResponseBody
    public String hello(HttpServletRequest req, HttpServletResponse res){
        String result = userService.getUserByName(req.getParameter("username")).toString();
        return result;
    }
}
