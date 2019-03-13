package com.zbjdl.soa.services.log.service.impl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.dubbo.common.utils.NetUtils;
import com.zbjdl.common.log.LogServicesApplication;
import com.zbjdl.common.log.service.BizLogService;
import com.zbjdl.common.log.service.impl.BizLogServiceImpl;
import com.zbjdl.common.soa.log.BizLogDTO;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LogServicesApplication.class)
public class BizLogServiceImplTest extends BizLogServiceImpl {
	@Autowired
	BizLogService bizLogService;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSaveBizLogDTO() {

		BizLogDTO bizLog = new BizLogDTO();
		bizLog.setApplication("biz-log-test");
		bizLog.setLoggerName(this.getClass().getName());
		bizLog.setLogContent("testLogContent");
		bizLog.setLogTable(false);
		bizLog.setThreadName(Thread.currentThread().getName());
		bizLog.setCreateTime(new Date());
		bizLog.setHost(NetUtils.getLocalHost());
		bizLogService.save(bizLog);
	}

	@Test
	public void testSaveListOfBizLogDTO() {
		fail("Not yet implemented");
	}

}
