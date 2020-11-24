package com.chris.mall.admin.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.mall.admin.entity.SysMenu;
import com.chris.mall.admin.service.SysMenuService;
import com.chris.mall.http.BaseResponse;
import com.github.pagehelper.PageInfo;

/**
 * 菜单管理(SysMenu)表控制层
 *
 * @author makejava
 * @since 2020-11-22 07:56:49
 */
@RestController
@RequestMapping("sys")
public class SysMenuController {
    /**
     * 服务对象
     */
    @Resource
    private SysMenuService sysMenuService;

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @GetMapping("menu/nav")
    public BaseResponse getAllMenuNav() {
        Map<String, Object> menuNav = this.sysMenuService.getAllMenuNav();
        return new BaseResponse().addProperties(menuNav).resetResp();
    }

    @GetMapping("menu/list")
    public List<SysMenu> getMenuList() {
        return this.sysMenuService.getAllMenu();
    }

    /**
     * 查询数据
     *
     * @return 列表
     */
    @GetMapping("menu/select")
    public BaseResponse getMenu() {
        List<SysMenu> menuList = this.sysMenuService.getAllMenu();
        return new BaseResponse().addProperty("menuList", menuList).resetResp();
    }

    /**
     * 查询数据
     *
     * @param menuId 主键
     * @return 列表
     */
    @GetMapping("menu/info/{menuId}")
    public BaseResponse getMenuInfo(@PathVariable Long menuId) {
        SysMenu menu = this.sysMenuService.queryById(menuId);
        return new BaseResponse().addProperty("menu", menu).resetResp();
    }

    /**
     * 保持数据
     *
     * @param sysMenu 角色信息
     * @return resp
     */
    @PostMapping("menu/save")
    public BaseResponse saveMenu(@RequestBody SysMenu sysMenu) {
        this.sysMenuService.insert(sysMenu);
        return new BaseResponse();
    }

    /**
     * 更新数据
     *
     * @param sysMenu 主键
     * @return 列表
     */
    @PostMapping("menu/update")
    public BaseResponse updateMenu(@RequestBody SysMenu sysMenu) {
        this.sysMenuService.update(sysMenu);
        return new BaseResponse();
    }

    /**
     * 删除数据
     *
     * @param menuId 主键
     * @return resp
     */
    @PostMapping("menu/delete/{menuId}")
    public BaseResponse deleteMenu(@PathVariable Long menuId) {
        this.sysMenuService.deleteById(menuId);
        return new BaseResponse();
    }

}