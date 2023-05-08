package com.backendlist.controller;

import com.backendlist.ListTools.R;
import com.backendlist.yanZhengMa.KaptchaDemo.Utils.KaptchaUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

/**
 * @author kj
 * @date 2023/5/8
 * @apiNote 获取验证码接口
 */
@RestController
@Api(tags = "秒杀案例接口", description = "秒杀案例接口")
public class VerificationController {
    @Autowired
    KaptchaUtils kaptchaUtils;

    @GetMapping("captchaImage")
    @ApiOperation("获取验证码")
    public R<Map<String, Object>> getCode() throws IOException {
        return kaptchaUtils.getCode();
    }

}
