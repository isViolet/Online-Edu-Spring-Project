package code.wjf.ossservice.controller;

import code.wjf.commonutils.R;
import code.wjf.ossservice.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(description="阿里云文件管理")
@CrossOrigin //跨域
@RestController
@RequestMapping("/oss-service/file")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 文件上传
     *
     * @param file
     */
    @ApiOperation(value = "文件上传")
    @PostMapping("upload")
    public R upload(
            @ApiParam(name = "file", value = "文件", required = true) @RequestParam("file") MultipartFile file,
            @ApiParam(name = "host", value = "存放路径", required = false) @RequestParam("host") String host) {

        String uploadUrl = fileService.upload(file, host);
        //返回r对象
        return R.ok().message("文件上传成功").data("url", uploadUrl);

    }
}
