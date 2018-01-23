package com.yy.blog.controller;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author liwenxing
 * @date 2018/1/16 10:29
 */
@RestController
public class FileController {

    @Autowired
    private FastFileStorageClient storageClient;

    /**
     * 单个文件上传
     * @author liwenxing
     * @date 2018-1-16 10:39:20
     * @param multipartFile
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/uploadFile")
    public String uploadFile(MultipartFile multipartFile) throws IOException {
        StorePath storePath = storageClient.uploadFile(multipartFile.getInputStream(), multipartFile.getSize(), FilenameUtils.getExtension(multipartFile.getOriginalFilename()), null);
        return storePath.getFullPath();
    }
}
