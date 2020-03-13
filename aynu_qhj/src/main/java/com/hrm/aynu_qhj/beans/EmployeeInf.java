package com.hrm.aynu_qhj.beans;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * employee_inf
 *
 * @author
 */
@Data
@Alias("emp")
public class EmployeeInf implements Serializable {
    private Integer id;

    private Integer deptId;

    private Integer jobId;

    private String name;

    private String cardId;

    private String address;

    private String postCode;

    private String tel;

    private String phone;

    private String qqNum;

    private String email;

    private Integer sex;

    private String party;

    private Date birthday;

    private String race;

    private String education;

    private String speciality;

    private String hobby;

    private String remark;

    private Date createDate;

    private JobInf job;

    private DeptInf dept;

    private static final long serialVersionUID = 1L;
}