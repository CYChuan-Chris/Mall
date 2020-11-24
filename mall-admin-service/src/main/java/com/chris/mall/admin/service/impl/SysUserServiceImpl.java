package com.chris.mall.admin.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.chris.mall.admin.dao.SysUserDao;
import com.chris.mall.admin.dao.SysUserTokenDao;
import com.chris.mall.admin.entity.SysUser;
import com.chris.mall.admin.entity.SysUserToken;
import com.chris.mall.admin.service.SysCaptchaService;
import com.chris.mall.admin.service.SysUserService;
import com.chris.mall.admin.viewobj.Login;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 系统用户(SysUser)表服务实现类
 *
 * @author makejava
 * @since 2020-11-22 07:56:11
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    @Resource
    private SysUserTokenDao sysUserTokenDao;

    @Resource
    private SysCaptchaService sysCaptchaService;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public SysUser queryById(Long userId) {
        return this.sysUserDao.queryById(userId);
    }

    /**
     * 查询登录用户信息
     * 先查询 token 验证有效期，再根据关联的 userId 查询用户信息
     *
     * @param token token
     * @return user
     */
    @Override
    public SysUser getUserByToken(String token) {
        SysUserToken userToken = this.sysUserTokenDao.queryByToken(token);
        if (userToken == null || userToken.getExpireTime() == null || new Date().after(
            userToken.getExpireTime())) {
            this.logout(token);
            return null;
        }
        return this.sysUserDao.queryById(userToken.getUserId());
    }

    /**
     * 登出, 删除对应的 token 记录
     *
     * @param token 登录信息
     * @return 单条数据
     */
    @Override
    public int logout(String token) {
        return this.sysUserTokenDao.deleteByToken(token);
    }

    /**
     * 查询多条数据
     *
     * @param offset   查询起始位置
     * @param limit    查询条数
     * @param username username
     * @return 对象列表
     */
    @Override
    public PageInfo<SysUser> queryAll(int offset, int limit, String username) {
        PageHelper.startPage(offset, limit);
        return PageInfo.of(this.sysUserDao.queryAll(null));
    }

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser insert(SysUser sysUser) {
        this.sysUserDao.insert(sysUser);
        return sysUser;
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser update(SysUser sysUser) {
        this.sysUserDao.update(sysUser);
        return this.queryById(sysUser.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long userId) {
        return this.sysUserDao.deleteById(userId) > 0;
    }

    /**
     * 用户登录鉴权
     *
     * @param login 登录信息
     * @return 鉴权信息
     */
    @Override
    public String loginVerify(Login login) {
        SysUser sysUser = this.sysUserDao.selectByUnique(login.getUsername());
        if (!verifyUser(sysUser, login) || !sysCaptchaService.checkCaptcha(login.getUuid(),
            login.getCaptcha())) {
            return StringUtils.EMPTY;
        }
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        recordToken(sysUser.getUserId(), token);
        return token;
    }

    private void recordToken(Long userId, String token) {
        SysUserToken userToken = new SysUserToken();
        userToken.setUserId(userId);
        userToken.setToken(token);
        LocalDateTime now = LocalDateTime.now();
        userToken.setExpireTime(Date.from(now.plusMinutes(20).toInstant(ZoneOffset.UTC)));
        userToken.setUpdateTime(Date.from(now.toInstant(ZoneOffset.UTC)));
        this.sysUserTokenDao.insert(userToken);
    }

    private boolean verifyUser(SysUser sysUser, Login login) {
        return sysUser != null && StringUtils.equals(sysUser.getUsername(), login.getUsername())
            && StringUtils.equals(sysUser.getPassword(), login.getPassword());
    }
}