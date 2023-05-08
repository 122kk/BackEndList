package com.backendlist.yanZhengMa.hutoolDemo;

import cn.hutool.captcha.*;
import cn.hutool.core.codec.Base64;
import com.backendlist.ListTools.R;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kj
 * @date 2023/5/8
 * @apiNote 利用hutool实现一些验证码生成
 */
public class VerificationHuTool {
    public static R<Map<String,String>> getCode(){
        // 参数设置请查看源码
        //圆圈干扰
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(150, 50,4,10);
        //干扰线
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(150, 50, 4, 100);
        //直线干扰
        ShearCaptcha shearCaptcha = CaptchaUtil.createShearCaptcha(150, 50,4,4);
        //gif验证码
        GifCaptcha gifCaptcha = CaptchaUtil.createGifCaptcha(150, 50, 4);
        Map<String, String> map = new HashMap<>();
        //这里是因为是案例的书写,在实际中不讲code传给前端
        map.put(captcha.getCode(),captcha.getImageBase64());
        map.put(lineCaptcha.getCode(),lineCaptcha.getImageBase64());
        map.put(shearCaptcha.getCode(),shearCaptcha.getImageBase64());
        map.put(gifCaptcha.getCode(),gifCaptcha.getImageBase64());
        return R.success(200,map);
    }
}
