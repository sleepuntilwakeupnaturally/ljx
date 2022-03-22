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
@TableName(value = "t_user")
public class Users {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String num;
    private String username;
    private Integer admin;
    private String academy;
    private String pwd;
    private String dormitory;
    private String phone;

}
