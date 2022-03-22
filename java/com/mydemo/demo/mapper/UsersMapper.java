package com.mydemo.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mydemo.demo.entity.Users;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UsersMapper extends BaseMapper<Users> {

    @Select("SELECT * FROM t_user WHERE username = #{username}")
    Users SelectByUsername(String username);

    @Select("SELECT * FROM t_user")
    List<Users> selectAllUsers();

}
