package com.example.centaure.Centaure.Intermediario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class MotoristaConfig implements WebMvcConfigurer {

    @Autowired
    private MotoristaBloq interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(interceptor).addPathPatterns(new String[] {"/motorista", "/motorista/**"});
    }
}
