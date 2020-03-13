package com.hrm.job.handler;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hrm.commons.beans.JobInf;
import com.hrm.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;

    @RequestMapping("/selectJob")
    public String selectJob(Model model, @RequestParam(defaultValue = "1") int pageNum) {

        PageHelper.startPage(pageNum, 3);

        List<JobInf> jobs = jobService.selectJob();

        model.addAttribute("jobs", jobs);
        PageInfo<JobInf> page = new PageInfo(jobs);

        model.addAttribute("page", page);
        return "job/job";

    }
}
