package com.hrm.aynu_qhj.dept.handler;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hrm.aynu_qhj.beans.DeptInf;
import com.hrm.aynu_qhj.dept.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        return "html/dept/dept";
    }

    @RequestMapping("/AddDept")
    public String AddDept(DeptInf dept) {
        deptService.AddDept(dept);
        return "redirect:/dept/showAll";
    }

    @RequestMapping("/removeDept")
    public String removeDept(Integer[] ids) {
        deptService.removeDept(ids);
        return "redirect:/dept/showAll";
    }

    @RequestMapping("/showUpdate")
    public String showUpdate(Integer id, Model model,int pageNum) {
        DeptInf dept = deptService.selectOneDept(id);
        model.addAttribute("dept", dept);
        model.addAttribute("pageNum", pageNum);
        return "html/dept/showUpdateDept";

    }

    @RequestMapping("/showAddDept")
    public String toShowAddDept() {
        return "html/dept/showAddDept";
    }

    @RequestMapping("/modifyDept")
    @ResponseBody
    public String updateDept(DeptInf d) {
        System.out.println(d);
        int row = deptService.updateOneDept(d);
        if (row > 0) {
            return "OK";
        } else {
            return "OTHER";
        }
    }
}

