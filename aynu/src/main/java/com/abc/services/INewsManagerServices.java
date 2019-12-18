package com.abc.services;

import com.abc.pojo.Newslabel;

import java.util.List;
import java.util.Map;

public interface INewsManagerServices {
    List<Newslabel> checkAllLable(int pages);

    int checkCount();

    void deleteOne(int id);

    Newslabel queryById(int id);

    int queryIdByName(String select2);

    void update(Map<String, Object> newslabel);

    List<Newslabel> checkAllParentLable();


    int queryCountChlidByParentId(int id);

    List<Newslabel> queryAllChlidByParentId(int id,int pages);

    void addLabel(Newslabel newslabel);
}
