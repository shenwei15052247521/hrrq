package com.lanswon.auth.bean.dto;

import com.lanswon.web.dto.BaseDto;

/**
 * 返回提
 * @author Jaswine
 */
public class ResultDTO extends BaseDto {

	@Override
	public void setToken(String token) {
		this.put("token", token);
	}
}
