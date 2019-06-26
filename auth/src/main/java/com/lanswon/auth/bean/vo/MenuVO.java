package com.lanswon.auth.bean.vo;

import lombok.Getter;
import lombok.Setter;


/**
 * 菜单实体类
 * @author cxf
 */
public class MenuVO {

	/**
	 * 菜单id
	 */
	@Getter
	@Setter
    private String id;
	/**
	 * 父id
	 */
	@Getter
	@Setter
    private String pid;
    /**
     * 菜单url
     */
    @Getter
    @Setter
    private String url;
    /**
     * 菜单名
     */
    @Getter
    @Setter
    private String name;
}
