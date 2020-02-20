package com.hrm.user.service;

import com.hrm.commons.beans.UserInf;
import com.hrm.user.dao.IUserInfDao;
import lombok.Setter;

import java.util.Map;

public class UserServiceImpl implements UserService {
    @Setter
    private IUserInfDao IUserInfDao;
    @Override
    public UserInf selectByNameAndPassword(Map<String, String> user) {
        UserInf u = IUserInfDao.selectByNameAndPassword(user);
        return u;
    }
}
