package pers.shubin.controller;
/**
 * @description:
 * @author: hongshubin
 * @requireNo:
 * @createdate: 2017-08-04 17:33
 * @lastdate:
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pers.shubin.domain.User;
import pers.shubin.service.interfaces.UserService;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by hongshubin on 2017/8/4.
 */
@Controller
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String getAllUsers(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users",users);
        return "profile";
    }
}
