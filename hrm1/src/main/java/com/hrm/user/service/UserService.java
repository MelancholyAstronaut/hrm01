package com.hrm.user.service;

import com.hrm.commons.beans.UserInf;

import java.util.List;
import java.util.Map;

public interface UserService {
    UserInf selectByNameAndPassword(Map<String, String> user);

    List<UserInf> findUser(UserInf user);

    UserInf findUserById(int id);
}
