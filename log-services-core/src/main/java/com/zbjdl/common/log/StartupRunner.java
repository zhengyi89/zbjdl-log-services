package com.zbjdl.common.log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

//import com.zbjdl.common.utils.config.ConfigurationUtils;

public class StartupRunner implements CommandLineRunner {
    protected final Logger logger = LoggerFactory.getLogger(StartupRunner.class);
    @Override
    public void run(String... strings) throws Exception {
      // ConfigurationUtils.init();
    }
}