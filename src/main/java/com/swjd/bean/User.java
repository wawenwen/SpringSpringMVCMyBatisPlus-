package com.swjd.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("user")
public class User {
    @TableId(value = "uid",type = IdType.AUTO)
    private int uid;
    @TableField("uname")
    private String uname;
    @TableField("realname")
    private String realname;
    @TableField("password")
    private String password;
    @TableField("flag")
    private String flag;
}
