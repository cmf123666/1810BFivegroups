package com.jk.utils;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
public class FileUtil  {
    private static final String url = "/upload";

    /**
     * 上传文件方法
     * @param file 上传的文件
     * @param request request对象
     * @return
     */
    public static String FileUpload(MultipartFile file, HttpServletRequest request){

        //保存文件的目标目录
        String savePath = request.getRealPath("/");
        //	String savePath = request.getSession().getServletContext().getRealPath("/")+url;

        //获取源文件后缀名称
        //12345.jpg
        int suffixIndex = file.getOriginalFilename().lastIndexOf(".");
        //  .jpg
        String suffixName = file.getOriginalFilename().substring(suffixIndex);

        //生成新的文件名称，原因：防止文件名称一样后者上传的文件会覆盖前者上传的文件（前提是文件名称必须一样并且在用一个目录下）
        //生成新的文件名称，保证文件名称唯一有两种方法：
        // 	  1.通过UUID实现文件名称唯一 （UUID会生成32位字母+数字唯一的一个字符串）
        //	  2.通过时间戳现文件名称唯一  （时间戳是毫秒级时间 时间会一直往上加，生成13位数字）注意只有java生成13位 其他则是10位比如oracle、mysql、php
        //  获取时间戳
        //long currentTimeMillis = System.currentTimeMillis();
        //System.out.println(currentTimeMillis);

        String newFileName = UUID.randomUUID().toString().replace("-", "") + suffixName;

        //检测目标目录是否存在
        File targetFile = new File(savePath, newFileName);
        if(!targetFile.exists()){
            //创建目标目录
            targetFile.mkdirs();
        }

        try {
            // 使用transferTo（dest）方法将上传文件写到服务器上指定的文件。
            file.transferTo(targetFile);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return newFileName;
    }

    /**
     * 文件下载方法
     * @param fileName 文件名称
     * @param request request对象
     * @return
     */
    public static ResponseEntity<byte[]> FileDownload(String fileName, HttpServletRequest request){

        ResponseEntity<byte[]> entity = null;

        //获取源文件地址
        String sourceUrl = request.getRealPath("/")+"/"+fileName;
        //获取源文件
        File sourceFile = new File(sourceUrl);
        //设置头部信息（文件信息包括文件名称和下载文件类型）
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", fileName.substring(7));
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        //文件下载
 /*       try {
            entity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(sourceFile), headers, HttpStatus.CREATED);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/

        return entity;
    }
}
