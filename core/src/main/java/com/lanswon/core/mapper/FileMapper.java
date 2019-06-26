package com.lanswon.core.mapper;


import com.lanswon.core.bean.pojo.FaceInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileMapper {

	/**
	 * 获得新增图片列表
	 * @param date 时间戳
	 * @return res
	 */
	List<String> getFileNameList(@Param("date") long date);

	boolean addFileInfo(@Param("faceInfo") FaceInfo faceInfo);

	void updateFaceInfo(String faceid);
}
