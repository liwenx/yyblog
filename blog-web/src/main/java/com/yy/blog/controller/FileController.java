package com.yy.blog.controller;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author liwenxing
 * @date 2018/1/16 10:29
 */
@RestController
@RequestMapping(value = "file")
public class FileController {
//    public static final String FASTDFS_URL = "http://vps.liwx.xyz/";
    @Value("${fdfs.trackerList}")
    private String fastdfs_url;

    @Autowired
    private FastFileStorageClient storageClient;

    /**
     * 图片上传
     * @author liwenxing
     * @date 2018-1-23 22:37:15
     * @param multipartFile
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/uploadImg")
    public String uploadImg(@RequestParam("image") MultipartFile multipartFile) throws IOException {
        System.out.println(fastdfs_url);
        StorePath storePath = storageClient.uploadFile(multipartFile.getInputStream(), multipartFile.getSize(), FilenameUtils.getExtension(multipartFile.getOriginalFilename()), null);
        return "http://"+fastdfs_url.split(":")[0] + "/" + storePath.getFullPath();
    }

}
