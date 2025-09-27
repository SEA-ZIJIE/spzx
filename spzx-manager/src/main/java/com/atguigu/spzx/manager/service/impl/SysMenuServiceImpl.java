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
import com.atguigu.spzx.manager.mapper.SysRoleMenuMapper;
import com.atguigu.spzx.manager.service.SysMenuService;
import com.atguigu.spzx.manager.utils.MenuHelper;
import com.atguigu.spzx.model.entity.system.SysMenu;
import com.atguigu.spzx.model.entity.system.SysUser;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.atguigu.spzx.model.vo.system.SysMenuVo;
import com.atguigu.spzx.utils.AuthContextUtil;
import com.github.xiaoymin.knife4j.core.util.CollectionUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {


    @Resource
    private SysMenuMapper  sysMenuMapper;
    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;


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
        //新添加子菜单，把父菜单isHalf改为半开状态1
        updateSysRoleMenu(sysMenu);
    }
    //新添加子菜单，把父菜单isHalf改为半开状态1

    private void updateSysRoleMenu(SysMenu sysMenu) {
        //获取当前添加菜单的父菜单
        SysMenu parentMenu = sysMenuMapper.selectParentMenu(sysMenu.getParentId());
        if (parentMenu != null) {
            // 将该id的菜单设置为半开
            sysRoleMenuMapper.updateSysRoleMenuIsHalf(parentMenu.getId()) ;
            // 递归调用
            updateSysRoleMenu(parentMenu);
        }

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


    //查询用户可以操作的菜单
    @Override
    public List<SysMenuVo> findMenuByUserId() {
        //获取当前用户id
        SysUser sysUser = AuthContextUtil.get();
        Long userId = sysUser.getId();

        //根据用户id查询可以操作的菜单

        // 封装成要求数据格式返回
        List<SysMenu> sysMenuList = MenuHelper.buildTree(sysMenuMapper.findMenuByUserId(userId));
        List<SysMenuVo> sysMenuVos = this.buildMenus(sysMenuList);


        return sysMenuVos;
    }

    // 将List<SysMenu>对象转换成List<SysMenuVo>对象
    private List<SysMenuVo> buildMenus(List<SysMenu> menus) {

        List<SysMenuVo> sysMenuVoList = new LinkedList<SysMenuVo>();
        for (SysMenu sysMenu : menus) {
            SysMenuVo sysMenuVo = new SysMenuVo();
            sysMenuVo.setTitle(sysMenu.getTitle());
            sysMenuVo.setName(sysMenu.getComponent());
            List<SysMenu> children = sysMenu.getChildren();
            if (!CollectionUtils.isEmpty(children)) {
                sysMenuVo.setChildren(buildMenus(children));
            }
            sysMenuVoList.add(sysMenuVo);
        }
        return sysMenuVoList;
    }
}
