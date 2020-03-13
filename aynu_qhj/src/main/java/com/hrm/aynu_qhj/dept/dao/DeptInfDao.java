package com.hrm.aynu_qhj.dept.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hrm.aynu_qhj.beans.DeptInf;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface DeptInfDao  extends BaseMapper<DeptInf> {
    List<DeptInf> selectAllDept(DeptInf deptInf);

    void AddDept(DeptInf dept);

    void removeDept(@Param("ids") Integer id[]);

    DeptInf selectOneDept(Integer id);

    int updateOneDept(DeptInf d);
}