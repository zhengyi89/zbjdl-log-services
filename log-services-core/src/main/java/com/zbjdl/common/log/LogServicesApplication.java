package com.zbjdl.common.log;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@SpringBootApplication
@ImportResource("classpath*:/log-services-spring/applicationContext-log-services.xml")

public class LogServicesApplication extends SpringBootServletInitializer {

	private static final Logger logger = LoggerFactory
			.getLogger(LogServicesApplication.class);
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LogServicesApplication.class);
    }

    
    @RequestMapping("/")
    @ResponseBody
	public String home(){
		
        return "Welcome!";
	}
    @Bean
    public StartupRunner schedulerRunner() {
        return new StartupRunner();
    } 
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(LogServicesApplication.class);
        springApplication.addListeners(new ApplicationContainerListener());
        springApplication.addListeners(new ApplicationStartup());
        springApplication.run(args);
//		SpringApplication.run(SoaCenterApplication.class, args);
        logger.info("Spring boot loaded");
	}
}

