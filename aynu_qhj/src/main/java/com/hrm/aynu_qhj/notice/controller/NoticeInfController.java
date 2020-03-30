package com.hrm.aynu_qhj.notice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hrm.aynu_qhj.beans.NoticeInf;
import com.hrm.aynu_qhj.notice.dao.NoticeInfDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * (NoticeInf)表控制层
 *
 * @author makejava
 * @since 2020-03-29 01:22:28
 */
@Controller
@RequestMapping("notice")
public class NoticeInfController {
    /**
     * 服务对象
     */
    @Autowired
    private NoticeInfDao noticeInfDao;

    @RequestMapping("/noticeAll")
    public String noticeAll(Model model, @RequestParam(defaultValue = "1") int pageNum, NoticeInf noticeInf) {
        PageHelper.startPage(pageNum, 3);
        QueryWrapper<NoticeInf> qw = new QueryWrapper<>();
        List<NoticeInf> allNotice;
        if (noticeInf.getContent() != null && noticeInf.getTitle() != null) {
            qw.like("title", noticeInf.getTitle()).like("content", noticeInf.getContent());
            allNotice = noticeInfDao.selectList(qw);
        } else {
            allNotice = noticeInfDao.selectList(null);
        }

        PageInfo<NoticeInf> page = new PageInfo<NoticeInf>(allNotice);
        model.addAttribute("notices", allNotice);
        model.addAttribute("page", page);
        model.addAttribute("noticeInf", noticeInf);
        return "html/notice/notice";
    }

    @GetMapping("/previewNotice")
    public String previewNotice(int id, Model model) {
        NoticeInf noticeInf = noticeInfDao.selectById(id);
        System.out.println(noticeInf);
        model.addAttribute("notice", noticeInf);
        return "html/notice/previewNotice";
    }

    @GetMapping("/removeNotice")
    public String removeNotice(int[] ids) {
        System.out.println(Arrays.toString(ids));
        List<Integer> l = new LinkedList();
        for (int i : ids) {
            l.add(i);
        }
        noticeInfDao.deleteBatchIds(l);
        return "redirect:/notice/noticeAll";
    }

    @GetMapping("/updateNotice")
    public String updateNotice(int id, Model model) {
        NoticeInf noticeInf = noticeInfDao.selectById(id);
        model.addAttribute("notice", noticeInf);
        return "html/notice/showAddNotice";
    }

    @PostMapping("/updateNotices")
    public String updateNotice(NoticeInf notice) {
        UpdateWrapper<NoticeInf> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", notice.getId());

        int noticeInf = noticeInfDao.update(notice, updateWrapper);
        return "redirect:/notice/noticeAll";
    }
}