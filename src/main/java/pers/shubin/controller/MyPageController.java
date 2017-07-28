package pers.shubin.controller;
/**
 * @description:
 * @author: hongshubin
 * @requireNo:
 * @createdate: 2017-07-27 18:07
 * @lastdate:
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hongshubin on 2017/7/27.
 */
@Controller
public class MyPageController {
    @RequestMapping("/mypage")
    public String getMyPage(){
        return "mypage";
    }
}
