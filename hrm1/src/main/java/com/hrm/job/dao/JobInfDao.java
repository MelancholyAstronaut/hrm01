package com.hrm.job.dao;

import com.hrm.commons.beans.JobInf;

import java.util.List;

public interface JobInfDao {
    int deleteByPrimaryKey(Integer id);

    int insert(JobInf record);

    int insertSelective(JobInf record);

    JobInf selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobInf record);

    int updateByPrimaryKey(JobInf record);

    List<JobInf> selectJob();
}