package com.hrm.dept.dao;

import com.hrm.commons.beans.DeptInf;

public interface DeptInfDao {
    int deleteByPrimaryKey(Integer id);

    int insert(DeptInf record);

    int insertSelective(DeptInf record);

    DeptInf selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeptInf record);

    int updateByPrimaryKey(DeptInf record);
}