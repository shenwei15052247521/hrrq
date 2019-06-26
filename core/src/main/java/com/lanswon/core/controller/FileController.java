package com.lanswon.core.controller;


import com.lanswon.core.service.FileService;
import com.lanswon.web.dto.DTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 文件相关操作
 * @author Jaswine
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

	@Resource
	private FileService fileService;

	/**
	 * 获得增量的文件名称
	 * @param date 时间戳(秒级)
	 * @return res
	 */
	@GetMapping("/filename/{date}")
	public DTO getFilename(@PathVariable long date){
		return fileService.getFilename(date);
	}

	/**
	 * 上传文件
	 * @param file 文件
	 * @param filename 文件名
	 * @return res
	 */
	@PostMapping(value = "/upload/" ,consumes = "multipart/form-data")
	public DTO uploadFile(@RequestParam("file")MultipartFile file, String filename) throws IOException {
		log.info("上传文件开始");
		return fileService.uploadFile(file,filename);
	}

}
