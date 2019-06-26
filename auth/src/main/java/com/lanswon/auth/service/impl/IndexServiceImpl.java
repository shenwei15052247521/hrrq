package com.lanswon.auth.service.impl;

import com.lanswon.auth.bean.dto.ResultDTO;
import com.lanswon.auth.bean.vo.MenuVO;
import com.lanswon.auth.enums.ResultEnum;
import com.lanswon.auth.mapper.PermissionMapper;
import com.lanswon.auth.service.IndexService;
import com.lanswon.web.dto.DTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 菜单获取IndexServiceImpl
 *
 * @author cxf
 */
@Service
@Slf4j
public class IndexServiceImpl implements IndexService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public DTO getMenus(String uid) {
        DTO dto = new ResultDTO();
	    List<MenuVO> menus = permissionMapper.getAllMenusByUserId(uid);
	    if (menus.isEmpty()){
		    dto.setStatus(ResultEnum.EMPTY_RESULT.getCode());
		    dto.setMsg(ResultEnum.EMPTY_RESULT.getMsg());
		    log.error(ResultEnum.EMPTY_RESULT.toString());
		    return dto;
	    }

	    dto.setStatus(ResultEnum.SUCCESS.getCode());
	    dto.setMsg(ResultEnum.SUCCESS.getMsg());
	    dto.setData(menus);

	    log.info(ResultEnum.SUCCESS.toString());
        return dto;
    }
}
