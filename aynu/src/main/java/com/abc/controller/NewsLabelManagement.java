package com.abc.controller;

import com.abc.pojo.Newslabel;
import com.abc.services.INewsManagerServices;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/newsLabel")
public class NewsLabelManagement {
    @Autowired
    INewsManagerServices iNewsManagerServices;

    @RequestMapping("/login")
    @ResponseBody
    public String login(String name, String pwd, String remember, HttpServletRequest request) {
        request.getSession().setAttribute("name",name);

        //1.如果remember被选中,设置session过期时间
        if (remember.equals("1")) {
            System.out.println("已经设置session过期时间");
            HttpSession session = request.getSession();
            session.setAttribute(name, name);
            session.setAttribute(pwd, pwd);
            session.setMaxInactiveInterval(60 * 60 * 24 * 7);
        }
        Integer flag = iNewsManagerServices.login(name, pwd);
        if (flag != null && flag > 0) {
            return "1";
        } else {
            return "0";
        }
    }

    @RequestMapping("/checkAll")
    public String CheckAll(Model model, @RequestParam(defaultValue = "1") int pageName) {
        //第一页开始显示,pageSize为3
        PageHelper.startPage(pageName, 3);
//      List<Newslabel> l = iNewsManagerServices.checkAllLable(pages);
        List<Newslabel> l = iNewsManagerServices.checkAllLable();

        PageInfo<Newslabel> page = new PageInfo<Newslabel>(l);

        List<Newslabel> allParentLabel = iNewsManagerServices.checkAllParentLable();
        model.addAttribute("allLable", l);
        model.addAttribute("page", page);
        model.addAttribute("allParentLabel", allParentLabel);
        //查询栏目
        return "allLabelManager";
    }

    @RequestMapping("/deleteIt/{id}")
    public String deleteOne(@PathVariable int id) {
        int fatherId = iNewsManagerServices.queryPidById(id);
        iNewsManagerServices.deleteOne(id);
        return "redirect:/newsLabel/ajaxParentFlash?id=" + fatherId;
    }

    @RequestMapping("/queryById/{id}")
    public String queryById(@PathVariable int id, Model model) {
        Newslabel newslabel = iNewsManagerServices.queryById(id);
        List<Newslabel> allParentLabel = iNewsManagerServices.checkAllParentLable();
        System.out.println(allParentLabel);
        model.addAttribute("editNewsLabel", newslabel);
        model.addAttribute("allParentLabel", allParentLabel);

        return "labelUpdate";
    }

    @RequestMapping("/Update")
    public String updateById(int id, Newslabel newslabel) {
        // int pid = iNewsManagerServices.queryIdByName(newslabel.getParent().getLabel_name());
        newslabel.setID(id);
        System.out.println(newslabel);
        iNewsManagerServices.update(newslabel);
        return "redirect:/newsLabel/ajaxParentFlash?id=" + newslabel.getPid();
    }


    @RequestMapping("ajaxParentFlash")
    public String SelectAllChildLabel(int id, Model model, @RequestParam(defaultValue = "1") int pageNum) {
        if (id == 0) {
            return "redirect:/newsLabel/checkAll";
        }
        //0.查询上级
        List<Newslabel> allParentLabel = iNewsManagerServices.checkAllParentLable();
        model.addAttribute("allParentLabel", allParentLabel);
        PageHelper.startPage(pageNum, 3);
        //2.查询父栏目下面的子栏目
        List<Newslabel> allChild = iNewsManagerServices.queryAllChlidByParentId(id);
        PageInfo<Newslabel> page = new PageInfo<Newslabel>(allChild);
        model.addAttribute("allChild", allChild);
        model.addAttribute("page", page);
        model.addAttribute("id", id);
        return "allChildInfo";
    }

    @RequestMapping("toAddLabel")
    public String toAddLabel(Model model) {
        //0.查询上级
        List<Newslabel> allParentLabel = iNewsManagerServices.checkAllParentLable();
        model.addAttribute("allParentLabel", allParentLabel);
        return "addLabel";
    }

    @RequestMapping("addLabel")
    public String addLabel(Newslabel newslabel) {
        iNewsManagerServices.addLabel(newslabel);
//        System.out.println(newslabel);
        return "redirect:/newsLabel/ajaxParentFlash?id=" + newslabel.getPid();
    }
    @RequestMapping("goIndex")
    public String goIndex(HttpServletRequest re){

        return "redirect:" + re.getContextPath() +"/html/index.jsp";
    }

}
