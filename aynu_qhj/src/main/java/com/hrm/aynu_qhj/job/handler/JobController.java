package com.hrm.aynu_qhj.job.handler;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hrm.aynu_qhj.beans.JobInf;
import com.hrm.aynu_qhj.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;

    @RequestMapping("/selectJob")
    public String selectJob(Model model, @RequestParam(defaultValue = "1") int pageNum, JobInf jobInf) {

        PageHelper.startPage(pageNum, 3);

        List<JobInf> jobs = jobService.selectJob(jobInf);

        model.addAttribute("jobs", jobs);
        model.addAttribute("job", jobInf);
        PageInfo<JobInf> page = new PageInfo(jobs);

        model.addAttribute("page", page);
        return "html/job/job";
    }

    @RequestMapping("/selectOneJob/{id}")
    public String selectJob(@PathVariable Integer id, Model model) {
        JobInf jobInf = jobService.selectOne(id);
        model.addAttribute("job", jobInf);
        return "html/job/showUpdateJob";

    }

    @RequestMapping("/updateJob")
    @ResponseBody
    public String updateJob(JobInf job, Model model) {
        int row  = jobService.updateJob(job);
        if (row > 0){
            return "OK";
        }else{
            return "OTHER";
        }
    }
    @RequestMapping("/toShowAddJob")
    public String toShowAddJob(){
        return "html/job/showAddJob";
    }

    @RequestMapping("/removeJob")
    public String removeJob(Integer ids[]){
        System.out.println(Arrays.toString(ids));
        jobService.deleteById(ids);
        return "redirect:/job/selectJob";
    }
    @RequestMapping("/addJob")
    public String addJob(JobInf job){
        jobService.addJob(job);
        return "redirect:/job/selectJob";
    }
}
