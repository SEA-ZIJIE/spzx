package com.atguigu.spzx.manager.service.impl;

import cn.hutool.core.date.DateUtil;
import com.atguigu.spzx.common.exception.GuiguException;
import com.atguigu.spzx.manager.properties.MinioProperties;
import com.atguigu.spzx.manager.service.FileUploadService;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import io.minio.*;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.UUID;

/**
 * ClassName: FileUploadControllerServiceImpl
 * Package: com.atguigu.spzx.manager.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/22 22:02
 * @Version 1.0
 */

@Service
public class FileUploadControllerServiceImpl implements FileUploadService {
@Resource
private MinioProperties  minioProperties;
    @Override
    public String upload(MultipartFile file) {

            try {
                // 创建一个Minio的客户端对象
                MinioClient minioClient = MinioClient.builder()
                        .endpoint(minioProperties.getEndpointUrl())
                        .credentials(minioProperties.getAccessKey(),
                                minioProperties.getSecreKey())
                        .build();

                // 判断桶是否存在
                boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(minioProperties.getBucketName()).build());
                if (!found) {       // 如果不存在，那么此时就创建一个新的桶
                    minioClient.makeBucket(MakeBucketArgs.builder().bucket(minioProperties.getBucketName()).build());
                } else {  // 如果存在打印信息
                    System.out.println("Bucket 'spzx-bucket' already exists.");
                }
                // 获取上传文件名称uuid生成01.jpj
                // 根据日期把图片进行分组
                String dateDir = DateUtil.format(new Date(), "yyyyMMdd");
                String uuid = UUID.randomUUID().toString().replace("-", "");
                String filename = dateDir+"/"+uuid+file.getOriginalFilename();


                // 文件上传
                minioClient.putObject(
                        PutObjectArgs.builder().bucket(minioProperties.getBucketName())
                                .object(filename)
                                .stream(file.getInputStream(),file.getSize(),-1)
                                .build()
                );
                //获取上传了文件在minio的路径
                String url = minioProperties.getEndpointUrl()+"/"+minioProperties.getBucketName()+"/"+filename;

                return url;

            } catch (Exception e) {
                e.printStackTrace();
                throw new GuiguException(ResultCodeEnum.SYSTEM_ERROR);
            }
    }
}






