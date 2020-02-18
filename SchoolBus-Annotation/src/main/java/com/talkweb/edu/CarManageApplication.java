package com.talkweb.edu;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

@SpringBootApplication
@MapperScan("com.talkweb.edu.mapper")
public class CarManageApplication {

    @Bean
    public HttpMessageConverters fastJsonMessageConverter() {
        //创建FastJson的消息转换器
        FastJsonHttpMessageConverter convert = new FastJsonHttpMessageConverter();
        //创建FastJson的配置对象
        FastJsonConfig config = new FastJsonConfig();
        //对Json数据进行格式化
        config.setSerializerFeatures(SerializerFeature.PrettyFormat);
        convert.setFastJsonConfig(config);
        HttpMessageConverter<?> con = convert;
        return new HttpMessageConverters(con);
    }

    public static void main(String[] args) {
        SpringApplication.run(CarManageApplication.class, args);
    }

}
