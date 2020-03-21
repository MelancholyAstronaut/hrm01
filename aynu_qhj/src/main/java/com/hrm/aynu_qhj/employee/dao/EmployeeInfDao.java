package com.hrm.aynu_qhj.employee.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hrm.aynu_qhj.beans.DeptInf;
import com.hrm.aynu_qhj.beans.EmployeeInf;
import com.hrm.aynu_qhj.beans.JobInf;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeInfDao extends BaseMapper<EmployeeInf> {
    List<EmployeeInf> selectAll(EmployeeInf example);

    List<JobInf> selectAllJob();

    List<DeptInf> selectAllDept();

}