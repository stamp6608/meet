package com.cn.meet.controller;

import com.cn.meet.common.FilePathConfig;
import com.cn.meet.enums.ResponseCodeEnum;
import com.cn.meet.handler.BodyRequestWrapper;
import com.cn.meet.model.common.ResponseEntity;
import com.cn.meet.req.oracle.FileReq;
import com.cn.meet.service.UserService;
import com.cn.meet.util.DateUtils;
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
    @Autowired
    private UserService userService;

    /**
     * @api {POST} http://url/file/upload  2.1注册文件上传
     * @apiVersion 1.0.0
     * @apiGroup 2文件上传和下载
     * @apiDescription 注册文件上传(建议先注册用户信息，再上传用户图片)
     * @apiParam {MultipartFile}   file   上传文件; 注意：上传文件名为 "手机号_文件名.文件后缀"
     * @apiSuccessExample {Object}  返回成功
     * {
     * "code":0,
     * "message:"success",
     * "data":{}
     * }
     * </b>
     * 加密此json对象后返回
     */
    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String fileName = file.getOriginalFilename();
        String realPath = filePathConfig.getRegister() + "/" + DateUtils.getNowDateStr() + "/" + FileUtils.getFileName(fileName);
        log.info("文件{}上传, 上传路径{}.....", fileName, realPath);
        String telephone = fileName.split("_")[0];
        boolean res = FileUtils.upload(file, realPath);
        if (res){
            userService.updateUserFilePath(telephone, realPath);
            log.info("【文件{}上传成功】", fileName);
            return ResponseEntity.initResponse();
        } else{
            log.error("【文件{}上传成功】", fileName);
            return ResponseEntity.initErrorResponseEntity(ResponseCodeEnum.FILE_UPLOAD_ERROR);
        }
    }


    /**
     * @api {POST} http://url/file/download  2.2注册文件下载
     * @apiVersion 1.0.0
     * @apiGroup 2文件上传和下载
     * @apiDescription 注册文件下载
     * @apiParam {String}   filePath  文件路径（一般是图片路径,直接取imgPath的值即可）
     * @apiSuccessExample {Object}   返回成功
     * ***返回文件（图片）数据流***
     * </b>
     * 加密此json对象后返回
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
