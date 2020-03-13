package com.hrm.aynu_qhj.employee.handler;


import com.hrm.aynu_qhj.beans.EmployeeInf;
import com.hrm.aynu_qhj.beans.JobInf;
import com.hrm.aynu_qhj.employee.dao.EmployeeInfDao;
import com.hrm.aynu_qhj.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeHandler {
    @Autowired
    private EmployeeInfDao employeeInfDao;
    @Autowired
    private JobService jobService;
    @RequestMapping("/allEmployee")
    public String allEmployee(Model model) {
        List<EmployeeInf> employeeInfList = employeeInfDao.selectList(null);
        //查询所有job
        List<JobInf> jobInfList =  jobService.selectAll();


        model.addAttribute("empList" ,employeeInfList);
        model.addAttribute("jobList" ,jobInfList);
        return "html/employee/employee";
    }
}
