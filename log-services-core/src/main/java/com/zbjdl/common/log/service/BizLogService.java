package com.zbjdl.common.log.service;

import java.util.List;

import com.zbjdl.common.soa.log.BizLogDTO;



public interface BizLogService {
	public void save(BizLogDTO bizLog);

	public void save(List<BizLogDTO> bizLogs);
}
