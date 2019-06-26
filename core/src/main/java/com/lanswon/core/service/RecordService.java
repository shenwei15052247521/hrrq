package com.lanswon.core.service;

import com.lanswon.core.bean.dto.QueryRecordDTO;
import com.lanswon.web.dto.DTO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 记录Service
 * @author Jaswine
 */
public interface RecordService {

	/**
	 * 获得所有消费记录
	 * @param queryRecordDTO 查询条件
	 * @return res
	 */
	DTO getAllPayRecordInfo(QueryRecordDTO queryRecordDTO);

	/**
	 * 获得所有充值记录
	 * @param queryRecordDTO 查询条件
	 * @return res
	 */
	DTO getAllLoadRecordInfo(QueryRecordDTO queryRecordDTO);

	/**
	 * 获得所有退费记录
	 * @param queryRecordDTO 查询条件
	 * @return res
	 */
	DTO getAllRefundRecordInfo(QueryRecordDTO queryRecordDTO);

	/**
	 * 获得所有记录
	 * @param queryRecordDTO 查询条件
	 * @return res
	 */
	DTO getAllRecordInfo(QueryRecordDTO queryRecordDTO);
	/**
	 * 导出交易流水
	 * @param
	 * @return res
	 */
    void exportRecord(QueryRecordDTO queryRecordDTO, HttpServletResponse response) throws IOException;
}
