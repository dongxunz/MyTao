package com.imooc.mytao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    protected ImageButton close_login;
    private TextView tv_registered;
    private EditText et_username, et_pwd;
    private Button bt_login;

    private String UserName,PassWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

        editTextData();

        setListener();
    }

    private boolean editTextData() {
        if (getIntent() != null) {
            Intent intent = getIntent();
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                UserName = bundle.getString("username");
                PassWord = bundle.getString("password");

                et_username.setText(UserName);
                et_pwd.setText(PassWord);

                return true;
            }
        }
        return false;
    }

    private void initView() {
        close_login = findViewById(R.id.im_btn);

        tv_registered = findViewById(R.id.tv_registered);

        et_username = findViewById(R.id.et_username);
        et_pwd = findViewById(R.id.et_pwd);

        bt_login = findViewById(R.id.bt_login);

    }

    private void setListener() {
        close_login.setOnClickListener(this);

        tv_registered.setOnClickListener(this);

        bt_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.im_btn:
                //使用Intent传值给MainActivity，使MainActivity显示指定Fragment
                //Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                //intent.putExtra("Flag","MeFragment");
                //startActivity(intent);
                //finish();

                onBackPressed();//调用返回键返回
                break;
            case R.id.tv_registered:
                startActivity(new Intent(LoginActivity.this, RegisteredActivity.class));
                break;
            case R.id.bt_login:
                if (et_username.getText().toString().equals("") | et_pwd.getText().toString().equals("")) {
                    Toast.makeText(LoginActivity.this, "请输入用户名和密码", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (editTextData()){

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("Flag","MeFragment");

                    Bundle bundle = new Bundle();
                    bundle.putString("username",UserName);
                    bundle.putString("password",PassWord);

                    intent.putExtra("data",bundle);

                    startActivity(intent);
                    finish();

                }else {
                    Toast.makeText(LoginActivity.this, "没有该用户，请注册", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
