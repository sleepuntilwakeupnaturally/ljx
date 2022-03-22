package com.mydemo.demo.web;


import com.mydemo.demo.entity.Users;
import com.mydemo.demo.service.IUsersService;
import com.mydemo.demo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController extends BaseController{
    @Autowired
    private IUsersService userService;

    @RequestMapping("reg")
    public JsonResult<Void> reg(Users user) {
        userService.reg(user);
        return new JsonResult<>(OK);
    }

    @RequestMapping("login")
    public JsonResult<Users> login(String username,
                                   String pwd,
                                   HttpSession session){
        System.out.println(username);
        Users data = userService.login(username, pwd);
        //向session对象中完成数据的绑定（session全局的）
        session.setAttribute("id", data.getId());
        session.setAttribute("username", data.getUsername());
        //获取session中绑定的数据
        System.out.println(getIdFromSession(session));
        return new JsonResult<Users>(OK, data);
    }

    @RequestMapping("show_data")
    public JsonResult<Users> getById(HttpSession session){
        Users data = userService.getById(getIdFromSession(session));
        return new JsonResult<Users>(OK, data);
    }

    @RequestMapping("show_users")
    public JsonResult<List<Users>> selectAllUsers(){
        List<Users> data = userService.selectAllUsers();
        return new JsonResult<List<Users>>(OK, data);
    }

    @RequestMapping("{id}/delete")
    public JsonResult<Void> delete(@PathVariable("id") Integer id, HttpSession session){
        if(id == getIdFromSession(session)){
            return null;
        } else {
            userService.deleteById(id);
        }
        return new JsonResult<>(OK);
    }

    @RequestMapping("update")
    public JsonResult<Void> updateOrder(Users user, HttpSession session) {
        user.setId(getIdFromSession(session));
        System.out.println(getIdFromSession(session));
        userService.updateUsersById(user);
        return new JsonResult<>(OK);
    }

}
