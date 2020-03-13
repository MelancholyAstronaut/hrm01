package com.hrm.aynu_qhj.dept.service;


import com.hrm.aynu_qhj.beans.DeptInf;
import com.hrm.aynu_qhj.dept.dao.DeptInfDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DeptServiceImpl")
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptInfDao deptInfDao;

    @Override
    public List<DeptInf> selectAllDept(DeptInf deptInf) {
        return deptInfDao.selectAllDept(deptInf);
    }

    @Override
    public void AddDept(DeptInf dept) {
        deptInfDao.AddDept(dept);
    }

    @Override
    public void removeDept(Integer id[]) {
        deptInfDao.removeDept(id);
    }


    @Override
    public DeptInf selectOneDept(Integer id) {
        return  deptInfDao.selectOneDept(id);
    }

    @Override
    public int updateOneDept(DeptInf d) {
       return deptInfDao.updateOneDept(d);
    }
}
