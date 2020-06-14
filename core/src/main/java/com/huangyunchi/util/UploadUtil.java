package com.huangyunchi.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

public class UploadUtil {

    private static String uploadPath = null;

    private static final String basePath = "/WEB-INF/upload";

    public static String getUploadPath(HttpServletRequest request) {
        // 得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
        assert request != null;
        uploadPath = request.getServletContext().getRealPath(basePath);
        System.out.println(uploadPath);
        File dir = new File(uploadPath);
        // 判断savePath对应的目录是否存在
        if (!dir.exists() && !dir.isDirectory()) {
            System.out.println(uploadPath + "目录不存在，需要创建");
            //创建目录
            dir.mkdir();
        }

        return uploadPath;
    }


    public static List<FileItem> parseRequest(HttpServletRequest req) throws FileUploadException {
        // 使用Apache文件上传组件处理文件上传步骤：
        // 1、创建一个DiskFileItemFactory工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setDefaultCharset("UTF-8");
        // 2、创建一个文件上传解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 解决上传文件名的中文乱码
        upload.setHeaderEncoding("UTF-8");

        // 3、判断提交上来的数据是否是上传表单的数据
        if (!ServletFileUpload.isMultipartContent(req)) {
            //按照传统方式获取数据
            return null;
        }
        return upload.parseRequest(req);
    }
}
