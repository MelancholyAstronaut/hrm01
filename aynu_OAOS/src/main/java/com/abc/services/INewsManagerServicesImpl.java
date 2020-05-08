package com.abc.services;

import com.abc.dao.INewsManagerDao;
import com.abc.pojo.Newslabel;
import lombok.Setter;

import java.util.List;

public class INewsManagerServicesImpl implements INewsManagerServices {
    @Setter
    private INewsManagerDao iNewsManagerDao;

    @Override
    public List<Newslabel> checkAllLable() {
        return iNewsManagerDao.checkAllLable();
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
    public void update(Newslabel newslabel) {
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
    public List<Newslabel> queryAllChlidByParentId(int id) {
        return iNewsManagerDao.queryAllChlidByParentId(id);
    }

    @Override
    public void addLabel(Newslabel newslabel) {
        iNewsManagerDao.addLabel(newslabel);
    }

    @Override
    public int queryPidById(int id) {
        return iNewsManagerDao.queryPidById(id);
    }

    @Override
    public Integer login(String name, String pwd) {
        return iNewsManagerDao.login(name,pwd);
    }
}
