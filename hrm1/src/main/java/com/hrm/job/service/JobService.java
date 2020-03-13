package com.hrm.job.service;

import com.hrm.commons.beans.JobInf;

import java.util.List;

public interface JobService {
    List<JobInf> selectJob();
}
