package com.imooc.mytao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisteredActivity extends Activity {

    private Button bt_back_login,bt_registered;
    private EditText et_registered_username,et_registered_pwd;
    private CheckBox cb_agree_protocol;
    private TextView tv_protocol;

    private boolean isCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registered);

        initView();

        setListener();
    }

    private void initView() {

        bt_back_login = findViewById(R.id.bt_back_login);

        bt_registered = findViewById(R.id.bt_registered);

        et_registered_username = findViewById(R.id.et_registered_username);
        et_registered_pwd = findViewById(R.id.et_registered_pwd);

        cb_agree_protocol = findViewById(R.id.cb_agree_protocol);
        
        tv_protocol = findViewById(R.id.tv_protocol);
    }

    private void setListener() {
        bt_back_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                RegisteredActivity.this.finish();
            }
        });

        cb_agree_protocol.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheck = isChecked;
            }
        });

        bt_registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isCheck){
                    Toast.makeText(RegisteredActivity.this, "~~你已同意xxx协议~~", Toast.LENGTH_SHORT).show();

                    if (et_registered_username.getText().toString().equals("") | et_registered_pwd.getText().toString().equals("")){
                        Toast.makeText(RegisteredActivity.this, "请输入手机号和验证码", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    Intent intent = new Intent(RegisteredActivity.this,LoginActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("username",et_registered_username.getText().toString());
                    bundle.putString("password",et_registered_pwd.getText().toString());
                    intent.putExtras(bundle);

                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(RegisteredActivity.this, "请先阅读xxx协议", Toast.LENGTH_SHORT).show();
                }

            }
        });

        tv_protocol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisteredActivity.this, "xxx协议", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
