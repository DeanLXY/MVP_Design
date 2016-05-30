package com.wxj.mvp_design.model;

/**
 * ====================
 * 版权所有 违法必究
 *
 * @author wangx
 * @project MVP_Design
 * @file BaseListAdapter
 * @create_time 2016/5/31
 * @github https://github.com/wangxujie
 * @blog http://wangxujie.github.io
 */
public interface IUserModel {
    public void login(String name,String password,OnLoginListener onLogInListener);
}
