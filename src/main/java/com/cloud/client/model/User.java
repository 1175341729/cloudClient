package com.cloud.client.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/***
 *  @Author dengwei
 *  @Description: TODO
 *  @Date 2018/12/12 13:57
 */
@TableName("t_user")
@Data
public class User {
    private Integer id;
    private String name;
    private Integer age;
}
