package com.mydemo.demo.service.impl;

import com.mydemo.demo.entity.Users;
import com.mydemo.demo.mapper.UsersMapper;
import com.mydemo.demo.service.IUsersService;
import com.mydemo.demo.service.ex.InsertException;
import com.mydemo.demo.service.ex.PasswordNotMatchException;
import com.mydemo.demo.service.ex.UserNotFoundException;
import com.mydemo.demo.service.ex.UsernameDuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements IUsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public void reg(Users users) {
        //调用findByUsername(username)判断是否被注册过
        String username = users.getUsername();
        Users result = usersMapper.SelectByUsername(username);
        if (result != null){
            throw new UsernameDuplicateException("用户名被占用");
        }
        Integer rows = usersMapper.insert(users);
        if(rows != 1){
            throw new InsertException("在用户注册过程中产生未知异常");
        }
    }

    @Override
    public Users login(String username, String pwd) {
        Users result = usersMapper.SelectByUsername(username);
        if (result == null){
            throw  new UserNotFoundException("用户不存在");
        }

        if (!pwd.equals(result.getPwd())){
            throw new PasswordNotMatchException("密码不正确");
        }

        return result;
    }

    @Override
    public Users getById(Integer id) {
        return usersMapper.selectById(id);
    }

    @Override
    public List<Users> selectAllUsers() {
        return usersMapper.selectAllUsers();
    }

    @Override
    public Integer deleteById(Integer id) {
        int row = usersMapper.deleteById(id);
        return row;
    }

    @Override
    public Integer updateUsersById(Users users) {
        //调用findByUsername(username)判断是否被注册过
        String username = users.getUsername();
        Users result = usersMapper.SelectByUsername(username);
        if (result != null){
            throw new UsernameDuplicateException("用户名被占用");
        }
        return usersMapper.updateById(users);
    }
}
