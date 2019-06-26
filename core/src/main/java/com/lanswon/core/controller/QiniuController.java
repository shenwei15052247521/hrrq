package com.lanswon.core.controller;

import com.qiniu.util.Auth;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 七牛云
 *
 * @author Jaswine
 */
@RestController
@RequestMapping("/qn")
public class QiniuController {

	private final String ACCESS_KEY = "xFHK8-yRrqM9zGwoa2ml9_vQUZ9psj_WKGaXcASw";
	private final String SECRET_KEY = "Rft1SCde75ljVSwl_ChU5b7FL_faC8i1lXQiNPtV";
	private final String BUCKET_NAME = "jaswine";

	@GetMapping("/token")
	public String token(){
		Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		return auth.uploadToken(BUCKET_NAME);
	}

}
