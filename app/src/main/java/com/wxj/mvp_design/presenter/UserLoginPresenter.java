package com.wxj.mvp_design.presenter;

import com.wxj.mvp_design.LoginActivity;
import com.wxj.mvp_design.bean.User;
import com.wxj.mvp_design.model.OnLoginListener;
import com.wxj.mvp_design.model.UserModel;
import com.wxj.mvp_design.view.IUserLoginView;

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
public class UserLoginPresenter {

    private IUserLoginView loginView;
    private UserModel userModel;

    public UserLoginPresenter(IUserLoginView loginView) {
        this.loginView = loginView;
        userModel = new UserModel();
    }

    public void login() {

        userModel.login(loginView.getUserName(), loginView.getPassword(), new OnLoginListener() {
            @Override
            public void onPreLogin() {
                loginView.showLoading();
            }

            @Override
            public void onLoginSuccess(User user) {
                loginView.hideLoading();
                loginView.toMainActivity();
            }

            @Override
            public void onLoginFailure(String text) {
                loginView.hideLoading();
                loginView.showFailedError();
            }
        });

    }
}
