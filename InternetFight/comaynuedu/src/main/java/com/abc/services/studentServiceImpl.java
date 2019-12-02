package com.abc.services;

import com.abc.dao.IStudentDao;
import com.abc.pojo.personallearn;
import com.abc.pojo.student;

import java.util.List;

public class studentServiceImpl implements IStudentService {

    private IStudentDao studentDao;
    public void setStudentDao(IStudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public student verify(int userId) {
      return  this.studentDao.verify(userId);
    }

    @Override
    public List<student> queryStudents(String adminclass) {
      return this.studentDao.queryStudents(adminclass);
    }

    @Override
    public student queryStudent(String name) {
        return this.studentDao.queryStudent(name);
    }

    @Override
    public personallearn querypersonallearn(int id) {
        return this.studentDao.querypersonallearn(id);
    }


}
