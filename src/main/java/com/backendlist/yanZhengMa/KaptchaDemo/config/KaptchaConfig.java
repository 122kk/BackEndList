package com.backendlist.yanZhengMa.KaptchaDemo.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;
//Kaptcha是一个谷歌提供的验证码的生成工具

/**
 * 这是一个简单的Kaptcha的配置类
 */

@Configuration
public class KaptchaConfig {
    @Bean(name = "captchaProducer")
    public DefaultKaptcha captchaProducer() {
        Properties properties = new Properties();
        // 是否显示边框
        properties.setProperty("kaptcha.border","no");
        // 边框颜色
        properties.setProperty("kaptcha.border.color","105,179,90");
        // 字体颜色
        properties.setProperty("kaptcha.textproducer.font.color","blue");
        // 字体大小
        properties.setProperty("kaptcha.textproducer.font.size","35");
        // 图片宽度
        properties.setProperty("kaptcha.image.width","300");
        // 图片高度
        properties.setProperty("kaptcha.image.height","100");
        // 文字个数
        properties.setProperty("kaptcha.textproducer.char.length","4");
        //文字大小
        properties.setProperty("kaptcha.textproducer.font.size","100");
        //文字随机字体
        properties.setProperty("kaptcha.textproducer.font.names", "宋体");
        //文字距离
        properties.setProperty("kaptcha.textproducer.char.space","16");
        //干扰线颜色
        properties.setProperty("kaptcha.noise.color","blue");
        // 干扰实现类
        //properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise");
        // 文本内容 从设置字符中随机抽取
        properties.setProperty("kaptcha.textproducer.char.string","0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
        // 图片样式 水纹com.google.code.kaptcha.impl.WaterRipple
        // 鱼眼com.google.code.kaptcha.impl.FishEyeGimpy
        // 阴影com.google.code.kaptcha.impl.ShadowGimpy
        properties.setProperty("kaptcha.obscurificator.impl", "com.google.code.kaptcha.impl.WaterRipple");
        DefaultKaptcha kaptcha = new DefaultKaptcha();
        kaptcha.setConfig(new Config(properties));
        return kaptcha;
    }
}