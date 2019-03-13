package com.zbjdl.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;


public class ApplicationContainerListener implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ApplicationContainerListener.class);
	@Override
    public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
		LOGGER.info(event.toString());
//		ApplicationContextHelper.setServerPort(event.getEmbeddedServletContainer().getPort());

    }
}