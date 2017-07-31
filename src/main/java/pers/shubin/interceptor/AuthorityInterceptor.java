package pers.shubin.interceptor;
/**
 * @description:
 * @author: hongshubin
 * @requireNo:
 * @createdate: 2017-07-28 18:13
 * @lastdate:
 */

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by hongshubin on 2017/7/28.
 */
public class AuthorityInterceptor extends HandlerInterceptorAdapter{
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handle) throws IOException, ServletException {
        HttpSession session = req.getSession();
        String UID = (String) session.getAttribute("user_id");
        if (UID != null && UID.equals("rookie")){return true;}
        else{
            String targetUrl = req.getRequestURI();
            String redirectUrl = new StringBuilder(String.format("/login?targetUrl=%s",targetUrl)).toString();
            res.sendRedirect(redirectUrl);
            return false;
        }
    }
}
