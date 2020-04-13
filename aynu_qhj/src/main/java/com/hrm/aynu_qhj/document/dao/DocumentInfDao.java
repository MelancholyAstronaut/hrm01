package com.hrm.aynu_qhj.document.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hrm.aynu_qhj.beans.DocumentInf;

import java.util.List;

/**
 * (DocumentInf)表数据库访问层
 *
 * @author qhj
 * @since 2020-04-12 16:23:36
 */
public interface DocumentInfDao extends BaseMapper<DocumentInf> {

    List<DocumentInf> queryAllDocument(String title);

    int insertDocument(DocumentInf doc);


    DocumentInf selectById(Integer id);

    int updateById(DocumentInf entity);

}