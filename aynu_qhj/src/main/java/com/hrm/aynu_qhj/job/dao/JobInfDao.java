package com.hrm.aynu_qhj.job.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hrm.aynu_qhj.beans.JobInf;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface JobInfDao extends BaseMapper<JobInf> {
    int deleteByPrimaryKey(@Param("ids") Integer id[]);

    int insert(JobInf record);

    int insertSelective(JobInf record);

    JobInf selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobInf record);

    int updateByPrimaryKey(JobInf jobInf);

    List<JobInf> selectJob(JobInf jobInf);

    JobInf selectOne(Integer id);
}