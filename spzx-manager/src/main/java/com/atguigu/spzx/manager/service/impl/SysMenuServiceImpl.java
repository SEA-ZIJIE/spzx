package com.atguigu.spzx.manager.service.impl;/**
 * ClassName: SysMenuServiceImpl
 * Package: com.atguigu.spzx.manager.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/24 15:30
 * @Version 1.0
 */

import com.atguigu.spzx.common.exception.GuiguException;
import com.atguigu.spzx.manager.mapper.SysMenuMapper;
import com.atguigu.spzx.manager.service.SysMenuService;
import com.atguigu.spzx.manager.utils.MenuHelper;
import com.atguigu.spzx.model.entity.system.SysMenu;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.github.xiaoymin.knife4j.core.util.CollectionUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {


@Resource
private SysMenuMapper  sysMenuMapper;
    //菜单列表

    @Override
    public List<SysMenu> findNodes() {
        //查询所有菜单，返回 list集合
        List<SysMenu> sysMenuList =  sysMenuMapper.findAll();
        if(CollectionUtils.isEmpty(sysMenuList)) {
            return null;
        }

        // 调用工具类的方法，返回list集合封装要求数据格式
            List<SysMenu> treeList = MenuHelper.buildTree(sysMenuList);


        return treeList;
    }

    //菜单添加
    @Override
    public void save(SysMenu sysMenu) {
        sysMenuMapper.save(sysMenu);
    }

    //菜单修改
    @Override
    public void update(SysMenu sysMenu) {
        sysMenuMapper.update(sysMenu);

    }
    //菜单的删除
    @Override
    public void removeById(Long id) {
        //根据当前菜单id，查询是否包含子菜单
        int count = sysMenuMapper.selectCountById(id);
        //判断count大于0，包含子菜单
        if(count > 0) {
            throw new GuiguException(ResultCodeEnum.LOGIN_ERROR);
        }
        //count等于0，直接删除
        sysMenuMapper.delete(id);
    }
}
