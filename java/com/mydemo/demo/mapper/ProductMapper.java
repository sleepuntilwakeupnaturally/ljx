package com.mydemo.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mydemo.demo.entity.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper extends BaseMapper<Product> {

    @Select("SELECT * FROM tb_product")
    List<Product> selectProduct();

}
