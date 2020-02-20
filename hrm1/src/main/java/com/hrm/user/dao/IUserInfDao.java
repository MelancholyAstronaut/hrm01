package com.hrm.user.dao;

import com.hrm.commons.beans.UserInf;

import java.util.Map;

public interface IUserInfDao {
    UserInf selectByNameAndPassword(Map<String, String> user);
}