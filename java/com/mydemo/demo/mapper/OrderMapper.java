package com.mydemo.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mydemo.demo.entity.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper extends BaseMapper<Order> {

    @Select("SELECT * FROM tb_order WHERE uid = #{uid}")
    List<Order> SelectByUid(Integer uid);

    @Delete("DELETE FROM tb_order WHERE pid = #{pid}")
    Integer DeleteOrderByPid(Integer pid);

    @Select("SELECT * FROM tb_order")
    List<Order> selectAllOrder();
}
