package com.lanswon.core.bean.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 绑定人脸DTO
 * @author Jaswine
 */
public class BindFaceDTO {

	/**
	 * 用户Id
	 */
	@Getter
	@Setter
	private String userId;
	/**
	 * 人脸Id
	 */
	@Getter
	@Setter
	private String faceId;
	/**
	 * 人脸url
	 */
	@Getter
	@Setter
	private String faceUrl;

}
