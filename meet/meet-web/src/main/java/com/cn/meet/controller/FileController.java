package com.cn.meet.controller;

import com.cn.meet.common.FilePathConfig;
import com.cn.meet.enums.ResponseCodeEnum;
import com.cn.meet.handler.BodyRequestWrapper;
import com.cn.meet.model.common.ResponseEntity;
import com.cn.meet.req.oracle.FileReq;
import com.cn.meet.util.FileUtils;
import com.cn.meet.util.GeneralUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


/**
 * @Description: 文件上传和下载
 * @Author: Stamp.M
 * @Date: 2019/4/1
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

    @Autowired
    private FilePathConfig filePathConfig;

    /**
     * @Description: 注册文件上传
     * @Param: [file, request]
     * @return: com.cn.meet.model.common.ResponseEntity
     * @Author: Stamp.M
     * @Date: 2019/4/1
     */
    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        log.info("文件{}上传.....", file.getOriginalFilename());
        boolean res = FileUtils.upload(file, filePathConfig.getRegister(), file.getOriginalFilename());
        if (res)
            return ResponseEntity.initResponse();
        else
            return ResponseEntity.initErrorResponseEntity(ResponseCodeEnum.FILE_UPLOAD_ERROR);
    }

    /**
     * @Description: 文件下载
     * @Param: [filePath, response]
     * @return: void
     * @Author: Stamp.M
     * @Date: 2019/4/1
     */
    @PostMapping("/download")
    @ResponseBody
    public void download(BodyRequestWrapper request, HttpServletResponse response) {
        FileReq fileReq = (FileReq) GeneralUtils.mapperParams(request, FileReq.class);
        String filePath = fileReq.getFilePath();
        try {
            log.info("文件下载... cur filePath is {}......", filePath);
            File file = new File(filePath);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开            
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream outputStream = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        outputStream.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("文件下载失败......");
        }
    }
}
