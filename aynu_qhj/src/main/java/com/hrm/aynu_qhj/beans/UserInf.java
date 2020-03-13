package com.hrm.aynu_qhj.beans;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * user_inf
 * @author 
 */
@Data
@Alias("user")
public class UserInf implements Serializable {
    private Integer id;

    private String loginname;

    private String password;

    private Integer status;

    private Date createdate;

    private String username;

}