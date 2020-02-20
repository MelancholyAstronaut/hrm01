package com.hrm.commons.beans;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * user_inf
 * @author 
 */
@Data
public class UserInf implements Serializable {
    private Integer id;

    private String loginname;

    private String password;

    private Integer status;

    private Date createdate;

    private String username;

}