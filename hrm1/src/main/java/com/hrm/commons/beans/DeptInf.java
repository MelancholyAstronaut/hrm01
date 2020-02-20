package com.hrm.commons.beans;

import lombok.Data;

import java.io.Serializable;

/**
 * dept_inf
 * @author 
 */
@Data
public class DeptInf implements Serializable {
    private Integer id;

    private String name;

    private String remark;

}