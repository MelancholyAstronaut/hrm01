package com.abc.dao;

import com.abc.pojo.personallearn;
import com.abc.pojo.student;

import java.util.List;

public interface IStudentDao {
    public student verify(int userId);

    List<student> queryStudents(String adminclass);

    student queryStudent(String name);


    personallearn querypersonallearn(int id);
}
