package com.hrm.job.service;

import com.hrm.commons.beans.JobInf;
import com.hrm.job.dao.JobInfDao;
import org.eclipse.core.runtime.jobs.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobInfDao jobInfDao;

    @Override
    public List<JobInf> selectJob() {
        return jobInfDao.selectJob();

    }
}
