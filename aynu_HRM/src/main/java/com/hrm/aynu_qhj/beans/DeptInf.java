package com.hrm.aynu_qhj.beans;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * dept_inf
 * @author 
 */
@Alias("dept")
@Data

public class DeptInf implements Serializable {
    private Integer id;

    private String name;

    private String remark;

}