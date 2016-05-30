package com.wxj.mvp_design;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Toast;

import com.wxj.mvp_design.presenter.UserLoginPresenter;
import com.wxj.mvp_design.view.IUserLoginView;


public class LoginActivity extends AppCompatActivity implements OnClickListener, IUserLoginView {


    private ProgressBar login_progress;
    private AutoCompleteTextView email;
    private EditText password;
    private Button email_sign_in_button;
    private LinearLayout email_login_form;
    private ScrollView login_form;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

    }


    private void initView() {
        login_progress = (ProgressBar) findViewById(R.id.login_progress);
        email = (AutoCompleteTextView) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        email_sign_in_button = (Button) findViewById(R.id.email_sign_in_button);
        email_login_form = (LinearLayout) findViewById(R.id.email_login_form);
        login_form = (ScrollView) findViewById(R.id.login_form);

        email_sign_in_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.email_sign_in_button:
                UserLoginPresenter userLoginPresenter = new UserLoginPresenter(this);
                userLoginPresenter.login();
                break;
        }
    }

    private void submit() {
        // validate
        String psw = password.getText().toString().trim();
        if (TextUtils.isEmpty(psw)) {
            Toast.makeText(this, "@string/prompt_password", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    @Override
    public String getUserName() {
        return email.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void showLoading() {
        if (progressDialog == null)
            progressDialog = ProgressDialog.show(this, null, "登录中...");
        progressDialog.show();

    }

    @Override
    public void hideLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void showFailedError() {
        Toast.makeText(LoginActivity.this, "登录错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toMainActivity() {
        Toast.makeText(LoginActivity.this, "跳转", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearUserName() {
        email.setText("");
    }

    @Override
    public void clearPassword() {
        password.setText("");
    }
}

