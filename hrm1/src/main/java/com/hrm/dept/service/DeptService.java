package com.hrm.dept.service;

import com.hrm.commons.beans.DeptInf;

import java.util.List;

public interface DeptService {
    List<DeptInf> selectAllDept(DeptInf deptInf);

    void AddDept(DeptInf dept);

    void removeDept(Integer id);

    DeptInf selectOneDept(Integer id);

    void updateOneDept(DeptInf d);
}
