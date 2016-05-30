package com.wxj.mvp_design.model;

import com.wxj.mvp_design.bean.User;

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
public interface OnLoginListener {
    void onPreLogin();
    void onLoginSuccess(User user);
    void onLoginFailure(String text);
}
