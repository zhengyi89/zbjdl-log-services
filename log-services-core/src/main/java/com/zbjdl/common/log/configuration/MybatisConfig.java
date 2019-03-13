package com.zbjdl.common.log.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@MapperScan(basePackages="com.zbjdl.common.log.repository")
public class MybatisConfig {


}
