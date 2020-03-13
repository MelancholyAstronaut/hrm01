package com.hrm.aynu_qhj.beans;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * job_inf
 * @author 
 */
@Alias("job")
@Data
public class JobInf implements Serializable {
    private Integer id;

    private String name;

    private String remark;

    private static final long serialVersionUID = 1L;
}