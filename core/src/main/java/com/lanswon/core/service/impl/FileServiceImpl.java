package com.lanswon.core.service.impl;

import com.lanswon.core.enums.ResultEnum;
import com.lanswon.core.mapper.FileMapper;
import com.lanswon.core.bean.dto.ResultDTO;
import com.lanswon.core.service.FileService;
import com.lanswon.core.util.FtpUtilsApache;
import com.lanswon.web.dto.DTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.List;

/**
 * 文件ServiceImpl
 * @author Jaswine
 */
@Service
@Slf4j
public class FileServiceImpl implements FileService {

	@Resource
	private FileMapper fileMapper;
	@Value("${ftp.ip}")
	private String ip;
	@Value("${ftp.port}")
	private int port;
	@Value("${ftp.username}")
	private String username;
	@Value("${ftp.password}")
	private String password;
	@Value("${ftp.filepath}")
	private String filepath;


	@Override
	public DTO getFilename(long date) {
		DTO dto = new ResultDTO();
		// 图片url  list
		List<String> fileNameList = fileMapper.getFileNameList(date);

		if (fileNameList.isEmpty()){
			dto.setStatus(ResultEnum.EMPTY_RESULT.getCode());
			dto.setMsg(ResultEnum.EMPTY_RESULT.getMsg());
		}

		dto.setStatus(ResultEnum.SUCCESS.getCode());
		dto.setMsg(ResultEnum.SUCCESS.getMsg());
		dto.setData(fileNameList);

		return dto;
	}

	@Override
	public DTO uploadFile(MultipartFile file,String filename) throws IOException {
		DTO dto = new ResultDTO();
		FTPClient client = FtpUtilsApache.login(ip, port, username, password);

		// 判断文件是否存在
		if (FtpUtilsApache.isFileExsits(client,filepath,filename)){
			dto.setStatus(ResultEnum.ERROR_FILE_HAS_EXIST.getCode());
			dto.setMsg(ResultEnum.ERROR_FILE_HAS_EXIST.getMsg());

			log.error(ResultEnum.ERROR_FILE_HAS_EXIST.toString());
			return dto;
		}

		// 存储文件
		boolean b = FtpUtilsApache.uploadFile(client, filepath, filename, file.getInputStream());
		if (!b){
			dto.setStatus(ResultEnum.ERROR_FILE_UPLOAD_FAILED.getCode());
			dto.setMsg(ResultEnum.ERROR_FILE_UPLOAD_FAILED.getMsg());

			log.error(ResultEnum.ERROR_FILE_UPLOAD_FAILED.toString());
			return dto;
		}

//		FtpUtilsApache.logout(client);
		dto.setStatus(ResultEnum.SUCCESS.getCode());
		dto.setMsg(ResultEnum.SUCCESS.getMsg());


		log.info(ResultEnum.SUCCESS.toString());
		return dto;
	}

	@Override
	public boolean delFile(String filename) throws IOException {
		FTPClient client = FtpUtilsApache.login(ip, port, username, password);
		// 判断文件是否存在
		if (!FtpUtilsApache.isFileExsits(client,filepath,filename)){

			log.error(ResultEnum.ERROR_FILE_ISEMPTY.toString());
			return false;
		}
		// 删除文件
		if (!FtpUtilsApache.deleteFile(client, filepath, filename)){

			log.error(ResultEnum.ERROR_FILE_DELETE_FAILED.toString());
			return false;
		}
		FtpUtilsApache.logout(client);

		return true;
	}
}
