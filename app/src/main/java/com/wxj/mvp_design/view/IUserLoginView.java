package com.wxj.mvp_design.view;

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
public interface IUserLoginView {
    public String getUserName();
    public String getPassword();

    public void showLoading();
    public void hideLoading();
    public void showFailedError();


    public void toMainActivity();

    public void clearUserName();

    public void clearPassword();

}
