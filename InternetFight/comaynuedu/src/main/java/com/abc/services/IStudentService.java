package com.abc.services;

import com.abc.pojo.personallearn;
import com.abc.pojo.student;

import java.util.List;

public interface IStudentService {
    public student verify(int userId);

    List<student> queryStudents(String adminclass);

    student queryStudent(String name);

    personallearn querypersonallearn(int id);
}
