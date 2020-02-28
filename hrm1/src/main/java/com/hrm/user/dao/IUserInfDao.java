package com.hrm.user.dao;

import com.hrm.commons.beans.UserInf;

import java.util.List;
import java.util.Map;

public interface IUserInfDao {
    UserInf selectByNameAndPassword(Map<String, String> user);

    List<UserInf> findUser(UserInf user);

    UserInf findUserById(int id);

    void removeUser(Integer id);

    UserInf findUserByLoginUser(UserInf user);

    void modifyUser(UserInf user);
    void addUser(UserInf user);
}