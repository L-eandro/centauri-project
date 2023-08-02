package com.example.centaure.Centaure.Intermediario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Component

public class UsuarioConfig implements WebMvcConfigurer {
        @Autowired
        private UsuarioBloq interceptor;

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(interceptor)
                    .addPathPatterns(new String[] {"/usuario", "/usuario/**" });
        }
}
