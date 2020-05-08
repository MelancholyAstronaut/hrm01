package com.hrm.aynu_qhj.job.service;


import com.hrm.aynu_qhj.beans.JobInf;

import java.util.List;

public interface JobService {
    List<JobInf> selectJob(JobInf jobInf);


    JobInf selectOne(Integer id);

    int updateJob(JobInf job);


    void deleteById(Integer id[]);

    void addJob(JobInf job);

    List<JobInf> selectAll();
}
