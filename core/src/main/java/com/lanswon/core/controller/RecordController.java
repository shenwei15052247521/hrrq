package com.lanswon.core.controller;

import com.lanswon.core.bean.dto.QueryRecordDTO;
import com.lanswon.core.service.RecordService;
import com.lanswon.web.dto.DTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 交易记录流水controller
 *
 * <p>
 *     交易记录查看
 *     0.消费记录
 *     1.充值记录
 *     2.退费记录
 *     3.所有记录
 * </p>
 *
 * @author Jaswine
 */
@RestController
@RequestMapping(value = "/record")
@Api(value = "交易记录相关API")
@Slf4j(topic = "RecordController")
public class RecordController {

	@Resource
	private RecordService recordService;

	/**
	 * 获得所有交易流水
	 * @return 交易流水
	 */
	@PostMapping
	@ApiOperation(value = "所有交易记录")
	public DTO getAllRecordInfo(@RequestBody QueryRecordDTO queryRecordDTO){

		switch (queryRecordDTO.getType()){
			case "0" :
				log.info("获得消费记录信息_start");
				return recordService.getAllPayRecordInfo(queryRecordDTO);
			case "1" :
				log.info("获得充值记录信息_start");
				return recordService.getAllLoadRecordInfo(queryRecordDTO);
			case "2":
				log.info("获得退费记录信息_start");
				return recordService.getAllRefundRecordInfo(queryRecordDTO);
			default:
				log.info("获得所有交易记录信息_start");
				return recordService.getAllRecordInfo(queryRecordDTO);
		}
	}



	/**
	 * 导出流水表
	 * @return 日报表
	 */
	@CrossOrigin
	@PostMapping("/export")
	public void exportRecord(HttpServletResponse response, @RequestBody QueryRecordDTO queryRecordDTO) {
		log.info("导出日报表");
		try {
			 recordService.exportRecord(queryRecordDTO,response);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
