package com.wxj.mvp_design.model;

import android.os.Handler;
import android.os.SystemClock;

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
public class UserModel implements IUserModel {
    private Handler handler = new Handler();
    @Override
    public void login(final String name, final String password, final OnLoginListener onLogInListener) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onLogInListener.onPreLogin();
                    }
                });
                SystemClock.sleep(2000);

                if ("admin".equals(name)&&"admin".equals(password)){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            User user = new User(name,password);
                            onLogInListener.onLoginSuccess(user);
                        }
                    });
                }else{
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            onLogInListener.onLoginFailure("登录失败");
                        }
                    });
                }
            }
        }.start();
    }
}
