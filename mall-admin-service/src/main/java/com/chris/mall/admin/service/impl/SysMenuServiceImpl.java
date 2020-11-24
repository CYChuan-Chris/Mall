package com.chris.mall.admin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chris.mall.admin.dao.SysMenuDao;
import com.chris.mall.admin.entity.SysMenu;
import com.chris.mall.admin.service.SysMenuService;

/**
 * 菜单管理(SysMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-11-22 07:56:49
 */
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
    @Resource
    private SysMenuDao sysMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param menuId 主键
     * @return 实例对象
     */
    @Override
    public SysMenu queryById(Long menuId) {
        return this.sysMenuDao.queryById(menuId);
    }

    /**
     * 查询所有菜单分页
     *
     * @return pageInfo
     */
    @Override
    public List<SysMenu> getAllMenu() {
        return this.sysMenuDao.queryAll(null);
    }

    /**
     * 新增数据
     *
     * @param sysMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SysMenu insert(SysMenu sysMenu) {
        this.sysMenuDao.insert(sysMenu);
        return sysMenu;
    }

    /**
     * 修改数据
     *
     * @param sysMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SysMenu update(SysMenu sysMenu) {
        this.sysMenuDao.update(sysMenu);
        return this.queryById(sysMenu.getMenuId());
    }

    /**
     * 获取所有的菜单
     *
     * @return 响应
     */
    @Override
    public Map<String, Object> getAllMenuNav() {
        List<SysMenu> sysMenus = this.sysMenuDao.queryAll(null);
        Map<String, Object> map = new HashMap<>(2);
        map.put("menuList", filterHierarchy(sysMenus));
        map.put("permissions", new ArrayList<>());
        return map;
    }

    /**
     * 层级过滤
     *
     * @param sysMenus 菜单
     */
    private List<SysMenu> filterHierarchy(List<SysMenu> sysMenus) {
        List<SysMenu> newList = new ArrayList<>();
        sysMenus.forEach(menu -> {
            Long parentId = menu.getParentId();
            if (parentId != 0) {
                sysMenus.forEach(ele -> {
                    if (ele.getMenuId().equals(parentId)) {
                        if (ele.getList() == null) {
                            ele.setList(new ArrayList<>());
                        }
                        ele.getList().add(menu);
                    }
                });
            } else {
                newList.add(menu);
            }
        });
        return newList;
    }

    /**
     * 通过主键删除数据
     *
     * @param menuId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long menuId) {
        return this.sysMenuDao.deleteById(menuId) > 0;
    }
}