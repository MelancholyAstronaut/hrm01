package com.hrm.aynu_qhj.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (NoticeInf)实体类
 *
 * @author makejava
 * @since 2020-03-29 01:21:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeInf implements Serializable {
    private static final long serialVersionUID = -86399445867871369L;
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String title;

    private String content;

    private Date createDate;

    private Integer userId;


}