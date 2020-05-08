package com.hrm.aynu_qhj.user.service;


import com.hrm.aynu_qhj.beans.UserInf;

import java.util.List;
import java.util.Map;

public interface UserService {
    UserInf selectByNameAndPassword(Map<String, String> user);

    List<UserInf> findUser(UserInf user);

    UserInf findUserById(int id);

    void removeUser(Integer id[]);

    UserInf findUserByLoginUser(UserInf user);

    void modifyUser(UserInf user);

    void addUser(UserInf user);

    List<UserInf> findall();
}
