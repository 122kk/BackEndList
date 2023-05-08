package com.backendlist.yanZhengMa.KaptchaDemo.Utils;

import com.backendlist.ListTools.R;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *  验证码生成工具,生成验证码后返回base64码
 */
@Component
public class KaptchaUtils {
 
    @Resource(name = "captchaProducer")
    private DefaultKaptcha producer;
   // @Resource
   // private RedisUtils redisUtils;
 
    public R<Map<String,Object>> getCode() throws IOException {
        // 生成文字验证码
        String code = producer.createText();
        System.out.println("code:" + code);
        // 生成图片验证码
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BufferedImage image = producer.createImage(code);
        ImageIO.write(image, "jpg", outputStream);
        // 生成captcha的token
        Map<String, Object> map = new HashMap<>();
        UUID codeKey = UUID.randomUUID();
        System.out.println("codeKey:" + codeKey);
        //保存验证码和对应的key
        //redisUtils.set("code:" + codeKey, code, TimeUtils.MINUTES);
        map.put("codeKey", codeKey);
        map.put("img", Base64.getEncoder().encodeToString(outputStream.toByteArray()));
        return R.success(200,map);
    }
}