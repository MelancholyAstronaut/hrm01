package com.mp.simple.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mp.simple.pojo.user;

import java.util.List;

public interface UserMapper extends BaseMapper<user> {
    public List<user> findAll();

}
