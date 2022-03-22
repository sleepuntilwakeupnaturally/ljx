package com.mydemo.demo.web;

import com.mydemo.demo.service.ex.PasswordNotMatchException;
import com.mydemo.demo.service.ex.UserNotFoundException;
import com.mydemo.demo.service.ex.UsernameDuplicateException;
import com.mydemo.demo.util.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController//相当于@Controller + @ResponseBody
@RequestMapping("users")
public class BaseController {

    /**
     * 表示操作成功
     */
    public static final int OK = 200;

    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameDuplicateException) {
            result.setState(4000);
            result.setMessage("用户名被占用");
        } else if (e instanceof UserNotFoundException) {
            result.setState(4001);
            result.setMessage("用户数据不存在异常");
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(4002);
            result.setMessage("用户密码错误的异常");
        }

        return result;
    }

    /**
     * 获取session对象
     * @param session session 对象
     * @return 当前登录id的值
     */
    protected final Integer getIdFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("id").toString());
    }

    /**
     * 获取当前登录用户的username
     * @param session session对象
     * @return 当前用户的用户名
     */
    protected final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }
}
