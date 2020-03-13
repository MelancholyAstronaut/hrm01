package com.hrm.aynu_qhj.dept.service;


import com.hrm.aynu_qhj.beans.DeptInf;

import java.util.List;

public interface DeptService {
    List<DeptInf> selectAllDept(DeptInf deptInf);

    void AddDept(DeptInf dept);

    void removeDept(Integer id[]);

    DeptInf selectOneDept(Integer id);

    int updateOneDept(DeptInf d);
}
