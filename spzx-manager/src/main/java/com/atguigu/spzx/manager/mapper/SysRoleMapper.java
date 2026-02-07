package com.atguigu.spzx.manager.mapper;/**
 * ClassName: SysRoleMapper
 * Package: com.atguigu.spzx.manager.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2026/2/3 21:55
 * @Version 1.0
 */

import com.atguigu.spzx.model.dto.system.SysRoleDto;
import com.atguigu.spzx.model.entity.system.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2026/2/3 21:55</p>
 * <p>作者：王贤 </p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 * 维护单：<br>
 * 修改日期：<br>
 * 修改人：<br>
 * 修改内容：<br>
 */
@Mapper
public interface SysRoleMapper {

    //删除角色

    static void deleteById(Long roleId) {

    }
    //查询角色

    List<SysRole> findByPage(SysRoleDto sysRoleDto);

    //添加角色

    void saveSysRole(SysRole sysRole);
    //修改角色

    void updateSysRole(SysRole sysRole);

}
