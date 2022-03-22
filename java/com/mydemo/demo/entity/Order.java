package com.mydemo.demo.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@TableName(value = "tb_order")
public class Order {

    private Integer pid;
    private Integer uid;
    private String name;
    private String username;
    private String classes;
    private String address;
    private String phone;

}
