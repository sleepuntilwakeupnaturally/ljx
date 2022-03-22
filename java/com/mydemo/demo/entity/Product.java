package com.mydemo.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@TableName(value = "tb_product")
public class Product {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String syn;
    private Integer hot;


}
