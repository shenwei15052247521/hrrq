package com.lanswon.core.service;

import com.lanswon.web.dto.DTO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 文件服务
 * @author jaswine
 */
public interface FileService {

	/**
	 * 增量获得文件名
	 * @param date 时间戳
	 * @return res
	 */
	DTO getFilename(long date);

	/**
	 * 上传文件
	 * @param file 文件
	 * @param filename 文件名
	 * @return res
	 */
    DTO uploadFile(MultipartFile file,String filename) throws IOException;

	/**
	 * 删除文件
	 * @param filename 文件名
	 * @return res
	 */
	boolean delFile(String filename) throws IOException;
}
