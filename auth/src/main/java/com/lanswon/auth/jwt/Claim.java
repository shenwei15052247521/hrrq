package com.lanswon.auth.jwt;

import com.alibaba.druid.support.json.JSONUtils;
import com.lanswon.util.json.JsonUtil;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Jwt claim实体
 * <P>
 *     基于RFC-7519(Json Web Token)规范实现的claim实体
 *     RFC-7519对claim中内容进行了推荐，ClaimEntity对其进行了封装
 * </P>
 * @author Jaswine
 */
public class Claim<T> {

	/**
	 * 发行者
	 */
	@Getter
	@Setter
	private String issUser;

	/**
	 * 主体对象
	 */
	@Getter
	private String subject;
	/**
	 * 接受者
	 */
	@Getter
	@Setter
	private String audience;
	/**
	 * 到期时间
	 */
	@Getter
	@Setter
	private Date expirationTime;
	/**
	 * 在此时间后生效
	 */
	@Getter
	@Setter
	private Date notBeforeTime;
	/**
	 * 发行时间
	 */
	@Getter
	@Setter
	private Date issuedTime;
	/**
	 * jwt id
	 */
	@Getter
	@Setter
	private String jId;

	public void setSubject(T sub) throws Exception {
		this.subject = JsonUtil.obj2String(sub);
	}

}
