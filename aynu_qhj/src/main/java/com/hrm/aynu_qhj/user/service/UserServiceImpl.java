package com.hrm.aynu_qhj.user.service;


import com.hrm.aynu_qhj.beans.UserInf;
import com.hrm.aynu_qhj.user.dao.IUserInfDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service(value = "UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private IUserInfDao IUserInfDao;

    @Override
    public UserInf selectByNameAndPassword(Map<String, String> user) {
        UserInf u = IUserInfDao.selectByNameAndPassword(user);
        return u;
    }

    @Override
    public List<UserInf> findUser(UserInf user) {
        return IUserInfDao.findUser(user);
    }

    @Override
    public UserInf findUserById(int id) {
        return IUserInfDao.findUserById(id);
    }

    @Override
    public void removeUser(Integer id[]) {
        IUserInfDao.removeUser(id);
    }

    @Override
    public UserInf findUserByLoginUser(UserInf user) {
        return IUserInfDao.findUserByLoginUser(user);
    }

    @Override
    public void modifyUser(UserInf user) {
        IUserInfDao.modifyUser(user);
    }

    @Override
    public void addUser(UserInf user) {
        IUserInfDao.addUser(user);
    }

    @Override
    public List<UserInf> findall() {
        return IUserInfDao.findall();
    }
}
