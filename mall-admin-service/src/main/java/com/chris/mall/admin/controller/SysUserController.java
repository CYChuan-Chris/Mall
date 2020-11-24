package com.chris.mall.admin.controller;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.mall.admin.entity.SysUser;
import com.chris.mall.admin.service.SysUserService;
import com.chris.mall.admin.viewobj.Login;
import com.chris.mall.http.BaseResponse;
import com.chris.mall.http.Status;
import com.github.pagehelper.PageInfo;

/**
 * 系统用户(SysUser)表控制层
 *
 * @author makejava
 * @since 2020-11-22 07:56:11
 */
@RestController
@RequestMapping("sys")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 登录鉴权
     *
     * @param login 登录信息
     * @return 单条数据
     */
    @RequestMapping("login")
    public BaseResponse login(@RequestBody @Valid Login login) {
        String token = this.sysUserService.loginVerify(login);
        Status status = StringUtils.isBlank(token) ? Status.AUTH_ERR : Status.SUCCESS;
        return new BaseResponse(status).addProperty("token", token).resetResp();
    }

    /**
     * 登出
     *
     * @param token 登录信息
     * @return 单条数据
     */
    @RequestMapping("logout")
    public BaseResponse logout(@CookieValue @Valid @NotBlank String token) {
        this.sysUserService.logout(token);
        return new BaseResponse();
    }

    /**
     * 查询登录用户信息
     *
     * @param token token
     * @return user
     */
    @RequestMapping("user/info")
    public BaseResponse getUserInfo(@CookieValue("token") @Valid @NotBlank String token) {
        SysUser sysUser = this.sysUserService.getUserByToken(token);
        return new BaseResponse().addProperty("user", sysUser).resetResp();
    }

    /**
     * 查询登录用户信息
     *
     * @param userId userId
     * @return user
     */
    @RequestMapping("user/info/{userId}")
    public BaseResponse getUser(@PathVariable @Valid @NotBlank Long userId) {
        SysUser sysUser = this.sysUserService.queryById(userId);
        return new BaseResponse().addProperty("user", sysUser).resetResp();
    }

    /**
     * 查询所有用户信息
     *
     * @return user
     */
    @RequestMapping("user/list")
    public BaseResponse getUserList(int page, int limit, String username) {
        PageInfo<SysUser> pageInfo = this.sysUserService.queryAll(page, limit, username);
        return new BaseResponse().addProperty("page", pageInfo).resetResp();
    }

    /**
     * 保持数据
     *
     * @param sysUser 角色信息
     * @return resp
     */
    @PostMapping("user/save")
    public BaseResponse saveRole(@RequestBody SysUser sysUser) {
        this.sysUserService.insert(sysUser);
        return new BaseResponse();
    }

    /**
     * 更新数据
     *
     * @param sysUser 主键
     * @return 列表
     */
    @PostMapping("user/update")
    public BaseResponse updateRole(@RequestBody SysUser sysUser) {
        this.sysUserService.update(sysUser);
        return new BaseResponse();
    }

    /**
     * 删除数据
     *
     * @param userId 主键
     * @return resp
     */
    @PostMapping("user/delete")
    public BaseResponse deleteRole(@RequestBody Long userId) {
        this.sysUserService.deleteById(userId);
        return new BaseResponse();
    }
}