package com.webservice.ahiru.config;

import com.webservice.ahiru.handler.ServiceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

 /*   @Bean
    public ServiceInterceptor getServiceInterceptor(){
        return new ServiceInterceptor();
    }*/

    @Autowired
    private ServiceInterceptor serviceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
/*        registry.addInterceptor(serviceInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/wechat/**")
                .excludePathPatterns("/mempdtl/bind");*/
    }
}
