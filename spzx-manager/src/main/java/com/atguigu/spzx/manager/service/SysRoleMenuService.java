package com.atguigu.spzx.manager.service;/**
 * ClassName: SysRoleMenuService
 * Package: com.atguigu.spzx.manager.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2026/2/4 23:32
 * @Version 1.0
 */

import com.atguigu.spzx.model.dto.system.AssginMenuDto;

import java.util.Map;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2026/2/4 23:32</p>
 * <p>作者：王贤 </p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 * 维护单：<br>
 * 修改日期：<br>
 * 修改人：<br>
 * 修改内容：<br>
 */
public interface SysRoleMenuService {
    //查询菜单

    Map<String, Object> findSysRoleMenuByRoleId(Long roleId);
    //保存菜单

    void doAssign(AssginMenuDto assginMenuDto);

}
