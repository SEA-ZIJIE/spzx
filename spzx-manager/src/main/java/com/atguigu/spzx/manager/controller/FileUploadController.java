package com.atguigu.spzx.manager.controller;

import com.atguigu.spzx.manager.service.FileUploadService;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * ClassName: FileUploadController
 * Package: com.atguigu.spzx.manager.controller
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/22 22:00
 * @Version 1.0
 */
@Tag(name = "用户头像管理")
@RestController
@RequestMapping("/admin/system")
public class FileUploadController {


    @Resource
    private FileUploadService fileUploadService;

    @PostMapping("/fileUpload")
    public Result<Void> fileUpload(@RequestParam("file") MultipartFile file) {
        // 1 获取上传的文件
        // 2 调用service的方法上传，返回minio路径
        String url = fileUploadService.upload(file);
        return Result.build(null, ResultCodeEnum.SUCCESS);


    }
}
