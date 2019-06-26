package com.lanswon.core.bean.dto;


import com.lanswon.core.bean.vo.StatementCountVO;
import com.lanswon.web.dto.BaseDto;

import java.util.List;

/**
 * 结果返回dto对象
 * @author Jaswine
 */
public class ResultDTO extends BaseDto {

	@Override
	public void setToken(String token){
		this.put("token",token);
	}

	public  void setCount(List<StatementCountVO> count){
		this.put("count",count);
	}
}
