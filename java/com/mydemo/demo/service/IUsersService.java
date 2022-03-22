package com.mydemo.demo.service;

import com.mydemo.demo.entity.Users;

import java.util.List;

public interface IUsersService {

    /**
     * 用户注册方法
     * @param users 用户
     */
    void reg(Users users);

    /**
     * 登录
     * @param username
     * @param pwd
     * @return
     */
    Users login(String username, String pwd);

    /**
     * 根据用户名查找用户
     * @param id
     * @return
     */
    Users getById(Integer id);

    /**
     * 查找所有用户
     * @return
     */
    List<Users> selectAllUsers();

    Integer deleteById(Integer id);

    Integer updateUsersById(Users users);

}
