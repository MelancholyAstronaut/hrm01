package com.abc.controller;

import com.abc.pojo.Newslabel;
import com.abc.services.INewsManagerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
@RequestMapping("/newsLabel")
public class NewsLabelManagement {
    @Autowired
    INewsManagerServices iNewsManagerServices;

    @RequestMapping("/checkAll")
    public String CheckAll(Model model, int pages) {
        List<Newslabel> l = iNewsManagerServices.checkAllLable(pages);
        List<Newslabel> allParentLabel = iNewsManagerServices.checkAllParentLable();
        int count = iNewsManagerServices.checkCount();
        pages += 3;
        model.addAttribute("allLable", l);
        model.addAttribute("count", count);
        model.addAttribute("pages", pages);
        model.addAttribute("allParentLabel", allParentLabel);
        //查询栏目
        return "allLabelManager";
    }

    @RequestMapping(value = "/deleteIt/{id}")
    public String deleteOne(@PathVariable int id) {
//        System.out.println(id);
        iNewsManagerServices.deleteOne(id);
        return "redirect:/newsLabel/checkAll?pages=0";
    }

    @RequestMapping("/queryById/{id}")
    public String queryById(@PathVariable int id, Model model) {
        Newslabel newslabel = iNewsManagerServices.queryById(id);
        model.addAttribute("editNewsLabel", newslabel);
        return "labelUpdate";
    }

    @RequestMapping("/Update/{id}")
    public String updateById(@PathVariable int id, Model model, Newslabel newslabel) {
//        System.out.println(newslabel);
        int pid = iNewsManagerServices.queryIdByName(newslabel.getParent().getLabel_name());
        newslabel.setID(id);
        Map<String, Object> map = new TreeMap<>();
        map.put("newslabel", newslabel);
        map.put("pid", pid);
        iNewsManagerServices.update(map);
        return "redirect:/newsLabel/checkAll?pages=0";
    }

    /**
     *
     * @param id 上级栏目的id
     * @param pages 页码
     * @return
     */
    @RequestMapping("ajaxParentFlash/{id}/{pages}")
    public String SelectAllChildLabel(@PathVariable int id, @PathVariable int pages,Model model){
        //0.查询上级
        List<Newslabel> allParentLabel = iNewsManagerServices.checkAllParentLable();

        model.addAttribute("allParentLabel", allParentLabel);
        //1.先查询有几条记录
        int count  = iNewsManagerServices.queryCountChlidByParentId(id);

        //2.查询父栏目下面的子栏目
        List<Newslabel> allChild = iNewsManagerServices.queryAllChlidByParentId(id,pages);
        pages+=3;
        model.addAttribute("count", count);
        model.addAttribute("pages", pages);
        model.addAttribute("allChild", allChild);
        model.addAttribute("id", id);
        return "allChildInfo";
    }
    @RequestMapping("toAddLabel")
    public String toAddLabel(Model model){
        //0.查询上级
        List<Newslabel> allParentLabel = iNewsManagerServices.checkAllParentLable();
        model.addAttribute("allParentLabel", allParentLabel);
        return "addLabel";
    }
    @RequestMapping("addLabel")
    public String addLabel(Newslabel newslabel){
        iNewsManagerServices.addLabel(newslabel);
//        System.out.println(newslabel);
        return "redirect:/newsLabel/checkAll?pages=0";
    }
}
