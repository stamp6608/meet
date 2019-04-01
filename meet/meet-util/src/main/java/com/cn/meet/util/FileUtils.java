package com.cn.meet.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Description: 文件上传工具
 * @Author: Stamp.M
 * @Date: 2019/4/1
 */
public class FileUtils {

    /**
     * @Description: 文件上传
     * @Param: [file, filePath, fileName]
     * @return: boolean
     * @Author: Stamp.M
     * @Date: 2019/4/1
     */
    public static boolean upload(MultipartFile file, String filePath, String fileName) {

        String realPath = filePath + "/" + DateUtils.getNowDateStr() + "/" + getFileName(fileName);
        File dest = new File(realPath);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest);
            //todo 待更新注册用户中imgPath
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * @Description: 生成文件名
     * @Param: [fileOriginName]
     * @return: java.lang.String
     * @Author: Stamp.M
     * @Date: 2019/4/1
     */
    public static String getFileName(String fileOriginName) {
        return GeneralUtils.buildToken() + getSuffix(fileOriginName);
    }

    /**
     * @Description: 获取文件后缀
     * @Param: [fileName]
     * @return: java.lang.String
     * @Author: Stamp.M
     * @Date: 2019/4/1
     */
    public static String getSuffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

}
