package com.hrm.aynu_qhj.job.service;

import com.hrm.aynu_qhj.beans.JobInf;
import com.hrm.aynu_qhj.job.dao.JobInfDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobInfDao jobInfDao;

        @Override
        public List<JobInf> selectJob(JobInf jobInf) {
            return jobInfDao.selectJob(jobInf);

    }

    @Override
    public int updateJob(JobInf job) {
        return jobInfDao.updateByPrimaryKey(job);
    }

    @Override
    public JobInf selectOne(Integer id) {
        return jobInfDao.selectOne(id);
    }

    @Override
    public void deleteById(Integer id[]) {
        jobInfDao.deleteByPrimaryKey(id);
    }

    @Override
    public void addJob(JobInf job) {
        jobInfDao.insert(job);
    }

    @Override
    public List<JobInf> selectAll() {
        return jobInfDao.selectList(null);
    }
}
