package com.zbjdl.common.log;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.zbjdl.common.soa.service.SoaBizLogService;


public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {
	private static final Logger logger = LoggerFactory
			.getLogger(ApplicationStartup.class);
	@Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
		logger.info(event.toString());
//		try {
//			DataSource logDataSource = (DataSource)event.getApplicationContext().getBean("logDataSource");
//			logger.info(logDataSource.getConnection().toString());
//		} catch (BeansException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		BizLogService bizLogService = (BizLogService)event.getApplicationContext().getBean("bizLogService");
//		logger.info(bizLogService.toString());
	}
}