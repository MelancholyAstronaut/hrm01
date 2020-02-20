package com.hrm.user.service;

import com.hrm.commons.beans.UserInf;

import java.util.Map;

public interface UserService {
    UserInf selectByNameAndPassword(Map<String, String> user);

}
