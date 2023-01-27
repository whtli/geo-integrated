package com.geo.integrated.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.geo.integrated.model.dto.LoginDTO;
import com.geo.integrated.model.SysUser;

/**
 * @author: whtli
 * @date: 2023/01/16
 * @description: 用户管理业务层
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * 用户登录匹配
     * 查询是否有与当前表单中的用户名、密码匹配的用户信息
     *
     * @param loginDTO 登录DTO，包含用户名和密码信息
     * @return 匹配成功返回用户实体类，失败返回null
     */
    SysUser login(LoginDTO loginDTO);
}