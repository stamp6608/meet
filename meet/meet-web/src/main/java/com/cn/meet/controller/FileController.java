package com.cn.meet.controller;

import com.cn.meet.common.FilePathConfig;
import com.cn.meet.enums.ResponseCodeEnum;
import com.cn.meet.handler.BodyRequestWrapper;
import com.cn.meet.model.common.ResponseEntity;
import com.cn.meet.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;


/**
 * @Description: 文件上传和下载
 * @Author: Stamp.M
 * @Date: 2019/4/1
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

    private final ResourceLoader resourceLoader;

    @Autowired
    private FilePathConfig filePathConfig;

    @Autowired
    public FileController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /**
     * @Description: 注册文件上传
     * @Param: [file, request]
     * @return: com.cn.meet.model.common.ResponseEntity
     * @Author: Stamp.M
     * @Date: 2019/4/1
     */
    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity upload(MultipartFile file, BodyRequestWrapper request) {
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
    public void download(String filePath, HttpServletResponse response) {
        try {
            log.info("文件下载... cur filePath is {}......", filePath);
            // 由于是读取本机的文件，file是一定要加上的
            resourceLoader.getResource("file:" + filePath);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("文件下载失败......");
        }
    }

}
