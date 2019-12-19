package com.abc.services;

import com.abc.pojo.Newslabel;

import java.util.List;

public interface INewsManagerServices {
    List<Newslabel> checkAllLable();

    int checkCount();

    void deleteOne(int id);

    Newslabel queryById(int id);

    int queryIdByName(String select2);

    void update(Newslabel newslabel);

    List<Newslabel> checkAllParentLable();


    int queryCountChlidByParentId(int id);

    List<Newslabel> queryAllChlidByParentId(int id);

    void addLabel(Newslabel newslabel);


    int queryPidById(int id);

    Integer login(String name, String pwd);
}
