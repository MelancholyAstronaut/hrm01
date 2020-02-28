package com.hrm.dept.handler;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hrm.commons.beans.DeptInf;
import com.hrm.dept.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    @Qualifier("DeptServiceImpl")
    private DeptService deptService;

    @RequestMapping("/showAll")
    public String showAll(Model model, @RequestParam(defaultValue = "1") int pageNum, DeptInf deptInf) {
        //System.out.println(deptInf);
        PageHelper.startPage(pageNum, 3);
        List<DeptInf> deptInfList = deptService.selectAllDept(deptInf);
        PageInfo<DeptInf> page = new PageInfo<DeptInf>(deptInfList);
        model.addAttribute("page", page);
        model.addAttribute("deptList", deptInfList);
        model.addAttribute("deptInf", deptInf);
        return "dept/dept";
    }

    @RequestMapping("/AddDept")
    public String AddDept(DeptInf dept) {
        deptService.AddDept(dept);
        return "redirect:/dept/showAll";
    }

    @RequestMapping("/removeDept/{id}")
    public String removeDept(@PathVariable Integer id) {
        deptService.removeDept(id);
        return "redirect:/dept/showAll";
    }

    @RequestMapping("/showUpdate/{id}")
    public String showUpdate(@PathVariable Integer id,Model model) {
        DeptInf dept = deptService.selectOneDept(id);
        model.addAttribute("dept",dept);
        return "dept/showUpdateDept";

    }
    @RequestMapping("/updateDept")
    public String updateDept(DeptInf d){
        deptService.updateOneDept(d);
        return "redirect:/dept/showAll";
    }
}

