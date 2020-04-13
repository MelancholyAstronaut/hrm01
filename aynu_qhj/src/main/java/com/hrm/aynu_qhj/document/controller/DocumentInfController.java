package com.hrm.aynu_qhj.document.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hrm.aynu_qhj.beans.DocumentInf;
import com.hrm.aynu_qhj.beans.UserInf;
import com.hrm.aynu_qhj.document.dao.DocumentInfDao;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;
import sun.awt.AWTCharset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * (DocumentInf)表控制层
 *
 * @author qhj
 * @since 2020-04-12 16:23:36
 */
@Controller
@RequestMapping("document")
public class DocumentInfController {
    @Autowired
    private DocumentInfDao documentInfDao;
    private final String PATH = "C:/Users/Hao/Desktop/aynu_qhj/src/main/resources/public/upload";

    @RequestMapping("/document")
    public String queryAllDocument(Model model, @RequestParam(defaultValue = "1") int pageNum, String title) {
        PageHelper.startPage(pageNum, 4);
        List<DocumentInf> docList = documentInfDao.queryAllDocument(title);
        PageInfo<DocumentInf> page = new PageInfo(docList);
        model.addAttribute("documentList", docList);
        model.addAttribute("page", page);
        return "html/document/document";
    }

    @GetMapping("showAddDocument")
    public String toUploadDoc() {
        return "html/document/showAddDocument";
    }

    @PostMapping("/addDocument")
    public String addDocument(DocumentInf doc, HttpSession session, Model model) throws IOException {
        File f = new File(PATH);
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        String fileName = UUID.randomUUID() + doc.getFile().getOriginalFilename();
        doc.getFile().transferTo(new File(PATH, fileName));
        //给fillName赋值
        doc.setFilename(fileName);
        UserInf user = (UserInf) session.getAttribute("user");
        doc.setUserInf(user);
        System.out.println(doc);
        int row = documentInfDao.insertDocument(doc);
        if (row > 0) {
            PageHelper.startPage(1, 4);
            PageInfo<DocumentInf> page = new PageInfo(documentInfDao.queryAllDocument(null));
            int pageNum = page.getPages();
            //上传文件之后到达最后一页
            String suffix = "?pageNum=" + pageNum;
            return "redirect:/document/document" + suffix;
        } else {
            model.addAttribute("reason", "文件上传出现错误");
            return "html/error/404";
        }
    }

    /**
     * @param flag 辨别方法 =1 查询 --- =2 修改
     * @param
     * @return
     * @author: qhj
     */
    @RequestMapping("updateDocument")
    public String updateDocument(DocumentInf document, Model model, int flag, HttpSession session) throws IOException {
        if (flag == 1) {
            DocumentInf doc = documentInfDao.selectById(document.getId());
            model.addAttribute("document", doc);
            return "html/document/showUpdateDocument";
        } else {
            File f = new File(PATH);
            if (!f.getParentFile().exists()) {
                f.getParentFile().mkdirs();
            }
            String fileName = UUID.randomUUID() + document.getFile().getOriginalFilename();
            document.getFile().transferTo(new File(PATH, fileName));
            //给fillName赋值
            document.setFilename(fileName);
            UserInf user = (UserInf) session.getAttribute("user");
            document.setUserInf(user);
            documentInfDao.updateById(document);
            return "redirect:/document/document";
        }

    }

    @RequestMapping("/downLoad")
    @ResponseBody
    public ResponseEntity<Object> downLoad(int id, HttpServletRequest request) throws IOException {
        DocumentInf doc = documentInfDao.selectById(id);
        String filename = doc.getFilename();
        File file = new File(PATH, filename);
        if (file.exists()) {
            filename = getFileName(request, filename);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            httpHeaders.setContentDispositionFormData("attachment", filename);
            return new ResponseEntity<Object>(FileUtils.readFileToByteArray(file), httpHeaders, HttpStatus.OK);
        } else {

            String html = "<a href=\"/document/document\">返回首页</a>";
            String error = " 文件不存在 !!!" + html;
            HttpHeaders headers = new HttpHeaders();
            MediaType m = new MediaType("text", "html", AWTCharset.forName("utf-8"));

            headers.setContentType(m);
            return new ResponseEntity<Object>(error, headers, HttpStatus.OK);
        }
    }

    @RequestMapping("removeDocument")
    public String removeDocument(Integer[] ids) {
        for (Integer id : ids) {
            DocumentInf doc = documentInfDao.selectById(id);
            File targetFile = new File(PATH, doc.getFilename());
            if (targetFile.exists()) {
                targetFile.delete();
            }
        }
        List l = Arrays.stream(ids).collect(Collectors.toList());
        documentInfDao.deleteBatchIds(l);
        return "redirect:/document/document";
    }

    public static String getFileName(HttpServletRequest request, String filename) {
        String finalFileName = "";
        try {
            final String userAgent = request.getHeader("USER-AGENT");
            if (StringUtils.contains(userAgent, "Edge")) {
                finalFileName = URLEncoder.encode(filename, "UTF8");
            } else if (StringUtils.contains(userAgent, "MSIE") || StringUtils.contains(userAgent, "Trident")) {
                // IE浏览器
                finalFileName = URLEncoder.encode(filename, "UTF8");
            } else if (StringUtils.contains(userAgent, "Mozilla")) {
                // google,火狐浏览器
                finalFileName = new String(filename.getBytes(), "ISO8859-1");
            } else {
                //其他浏览器
                finalFileName = URLEncoder.encode(filename, "UTF8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finalFileName;
    }
}