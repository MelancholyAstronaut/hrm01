package com.abc.services;

import com.abc.dao.INewsManagerDao;
import com.abc.pojo.Newslabel;
import lombok.Setter;

import java.util.List;
import java.util.Map;

public class INewsManagerServicesImpl  implements INewsManagerServices{
    @Setter
    private INewsManagerDao iNewsManagerDao;

    @Override
    public List<Newslabel> checkAllLable(int pages) {
        return iNewsManagerDao.checkAllLable( pages);
    }

    @Override
    public int checkCount() {
        return iNewsManagerDao.checkCount();
    }

    @Override
    public void deleteOne(int id) {
         iNewsManagerDao.deleteOne(id);
    }

    @Override
    public Newslabel queryById(int id) {
        return iNewsManagerDao.queryById(id);
    }

    @Override
    public int queryIdByName(String select2) {
        return iNewsManagerDao.queryIdByName(select2);
    }

    @Override
    public void update(Map<String, Object> newslabel) {
         iNewsManagerDao.update(newslabel);
    }

    @Override
    public List<Newslabel> checkAllParentLable() {
        return iNewsManagerDao.checkAllParentLable();
    }


    @Override
    public int queryCountChlidByParentId(int id) {
        return iNewsManagerDao.queryCountChlidByParentId(id);
    }

    @Override
    public List<Newslabel> queryAllChlidByParentId(int id,int pages) {
        return iNewsManagerDao.queryAllChlidByParentId(id,pages);
    }

    @Override
    public void addLabel(Newslabel newslabel) {
         iNewsManagerDao.addLabel(newslabel);
    }
}
