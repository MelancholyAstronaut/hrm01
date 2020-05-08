package com.hrm.aynu_qhj.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;

/**
 * (DocumentInf)实体类
 *
 * @author qhj
 * @since 2020-04-12 16:23:35
 */
@Alias("doc")
@Data
public class DocumentInf implements Serializable {
    private static final long serialVersionUID = 862996344228813694L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String filename;
    private String remark;
    private Date CREATE_DATE;
    private UserInf userInf;
    @TableField(exist = false)
    private MultipartFile file;

}