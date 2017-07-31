package pers.shubin.controller;
/**
 * @description:
 * @author: hongshubin
 * @requireNo:
 * @createdate: 2017-07-27 10:50
 * @lastdate:
 */

import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by hongshubin on 2017/7/27.
 */

@Controller
public class LoginController {
    @RequestMapping(value = "/login",method = {RequestMethod.GET})
    public String loginPage(HttpServletRequest req){
        return "login";
    }


    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    public String login(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String targetUrl = req.getParameter("targetUrl");
        if (targetUrl == ""){targetUrl = "index";}
        HttpSession session = req.getSession();
        session.setAttribute("user_id","rookie");
        session.setMaxInactiveInterval(10);
        return "redirect:"+targetUrl;
    }

}
