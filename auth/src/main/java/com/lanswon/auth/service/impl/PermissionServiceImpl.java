package com.lanswon.auth.service.impl;

import com.lanswon.auth.bean.pojo.Permission;
import com.lanswon.auth.bean.dto.ResultDTO;
import com.lanswon.auth.enums.ResultEnum;
import com.lanswon.auth.mapper.PermissionMapper;
import com.lanswon.auth.security.SecurityResultEnum;
import com.lanswon.auth.service.PermissionService;
import com.lanswon.util.utils.UUIDUtil;
import com.lanswon.web.dto.DTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 权限ServiceImpl
 *
 * @author Jaswine
 */

@Service
@Slf4j
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public DTO addPermission(Permission permission) {
        DTO dto = new ResultDTO();
        log.info("新增权限信息");
        permission.setId(UUIDUtil.generateUUID());
        /* 新增是否成功 */
        if (!permissionMapper.addPermission(permission)) {
            dto.setStatus(SecurityResultEnum.ERROR_BAD_SQL.getCode());
            dto.setMsg(SecurityResultEnum.ERROR_BAD_SQL.getMsgZH());

            log.error(SecurityResultEnum.ERROR_BAD_SQL.toString());

            return dto;
        }

        dto.setStatus(SecurityResultEnum.SUCCESS.getCode());
        dto.setMsg(SecurityResultEnum.SUCCESS.getMsgZH());
        log.info(SecurityResultEnum.SUCCESS.toString());
        return dto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DTO delPermission(String permissionid) {
        DTO dto = new ResultDTO();
        log.info("删除权限信息");
        /* 删除权限 */
        permissionMapper.delPermission(permissionid);
        /* 删除权限角色关联关系 */
        permissionMapper.delPermission2Role(permissionid);

        dto.setStatus(SecurityResultEnum.SUCCESS.getCode());
        dto.setMsg(SecurityResultEnum.SUCCESS.getMsgZH());

        log.info(SecurityResultEnum.SUCCESS.toString());

        return dto;

    }

    @Override
    public DTO updatePermission(Permission permission) {
        DTO dto = new ResultDTO();
        log.info("更新权限信息");
        /* 更新是否成功*/
        if (!permissionMapper.updatePermission(permission)) {
            dto.setStatus(SecurityResultEnum.ERROR_BAD_SQL.getCode());
            dto.setMsg(SecurityResultEnum.ERROR_BAD_SQL.getMsgZH());
            log.error(SecurityResultEnum.ERROR_BAD_SQL.toString());
            return dto;
        }

        dto.setStatus(SecurityResultEnum.SUCCESS.getCode());
        dto.setMsg(SecurityResultEnum.SUCCESS.getMsgZH());

        log.info(SecurityResultEnum.SUCCESS.toString());

        return dto;
    }

    @Override
    public DTO getPermissionInfo() {
        DTO dto = new ResultDTO();
        log.info("获得权限信息");

        /* 获取权限信息 */
        List<Permission> permissionList = permissionMapper.getPermissionInfo();
        if(permissionList != null && permissionList.size() >0) {
            dto.setStatus(SecurityResultEnum.SUCCESS.getCode());
            dto.setMsg(SecurityResultEnum.SUCCESS.getMsgZH());
            dto.setData(permissionList);

            log.info(SecurityResultEnum.SUCCESS.toString());

            return dto;
        }
        dto.setMsg(SecurityResultEnum.ERROR_EMPTY_RESULT.getMsgZH());
        dto.setStatus(SecurityResultEnum.ERROR_EMPTY_RESULT.getCode());
        log.error(SecurityResultEnum.ERROR_EMPTY_RESULT.toString());
        return dto;
    }

    @Override
    public DTO getPermissionInfoById(String id) {

        DTO dto = new ResultDTO();
        log.info("根据权限id"+id+"获得权限信息");
        /**通过id获取权限信息*/
        Permission permission = permissionMapper.getPermissionInfoById(id);

        // 判空
        if (permission == null) {
            dto.setStatus(SecurityResultEnum.ERROR_EMPTY_RESULT.getCode());
            dto.setMsg(SecurityResultEnum.ERROR_EMPTY_RESULT.getMsgZH());
            log.error(SecurityResultEnum.ERROR_EMPTY_RESULT.toString());
            return dto;
        }

        dto.setStatus(SecurityResultEnum.SUCCESS.getCode());
        dto.setMsg(SecurityResultEnum.SUCCESS.getMsgZH());
        dto.setData(permission);

        log.info(SecurityResultEnum.SUCCESS.toString());

        return dto;

    }
}
