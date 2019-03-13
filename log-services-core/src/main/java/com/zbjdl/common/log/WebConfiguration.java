package com.zbjdl.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.remoting.http.servlet.DispatcherServlet;



@Configuration
public class WebConfiguration{
	private static final Logger logger = LoggerFactory
			.getLogger(WebConfiguration.class);

	@Bean
    public ServletRegistrationBean soa(){
    	//注册Dubbo Servlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet();   
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/soa/*");
        servletRegistrationBean.setName("soa");
        return servletRegistrationBean;

    }


}
