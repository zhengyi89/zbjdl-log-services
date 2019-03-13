package com.zbjdl.common.log.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbjdl.common.log.service.BizLogService;
import com.zbjdl.common.soa.log.BizLogDTO;
import com.zbjdl.common.soa.service.SoaBizLogService;
import com.zbjdl.common.utils.CheckUtils;


@Service
public class SoaBizLogFacadeImpl implements SoaBizLogService {
	@Autowired
	private BizLogService bizLogService;

	@Override
	public void save(BizLogDTO bizLog) {
		CheckUtils.notNull(bizLog, "bizLog");
		CheckUtils.notEmpty(bizLog.getLoggerName(), "loggerName");
		CheckUtils.notEmpty(bizLog.getLogContent(), "logContent");
		if (bizLog.isLogTable()) {
			CheckUtils.notEmpty(bizLog.getColumns(), "columns");
		}
		bizLogService.save(bizLog);
	}

	@Override
	public void batchSave(List<BizLogDTO> bizLogs) {
		CheckUtils.notEmpty(bizLogs, "bizLogs");
		bizLogService.save(bizLogs);
	}
}
