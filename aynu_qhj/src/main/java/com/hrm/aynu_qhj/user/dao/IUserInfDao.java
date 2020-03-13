package com.hrm.aynu_qhj.user.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hrm.aynu_qhj.beans.UserInf;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
@Mapper
public interface IUserInfDao extends BaseMapper<UserInf> {
     UserInf selectByNameAndPassword(Map<String, String> user);

    List<UserInf> findUser(UserInf user);

    UserInf findUserById(int id);

    void removeUser(@Param("ids") Integer id[]);

    UserInf findUserByLoginUser(UserInf user);

    void modifyUser(UserInf user);
    void addUser(UserInf user);

    List<UserInf> findall();
}