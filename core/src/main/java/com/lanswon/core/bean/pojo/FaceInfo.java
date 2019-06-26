package com.lanswon.core.bean.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 人脸信息
 *
 * 对应表{#face_info}
 *
 * @author Jaswine
 */
@Data
public class FaceInfo {

	/**
	 * id
	 */
	private String id;
	/**
	 * URI
	 */
	private String uri;
	/**
	 * 人脸id
	 */
	private String fkFaceId;
	/**
	 * 创建时间
	 */
	private Date createTime;
}
