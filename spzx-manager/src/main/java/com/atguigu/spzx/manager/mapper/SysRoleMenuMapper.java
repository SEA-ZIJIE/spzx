package com.atguigu.spzx.manager.mapper;

import com.atguigu.spzx.model.dto.system.AssginMenuDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: SysRoleMenuMapper
 * Package: com.atguigu.spzx.manager.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/25 8:42
 * @Version 1.0
 */

@Mapper
public interface SysRoleMenuMapper {
    List<Long> findSysRoleMenuByRoleId(Long roleId);

    //删除角色分配过的菜单数据
    void deleteByRoleId(Long roleId);

    //保存分配的数据
    void doAssign(AssginMenuDto assginMenuDto);

    // 将该id的菜单设置为半开
    void updateSysRoleMenuIsHalf(Long menuid);
}
