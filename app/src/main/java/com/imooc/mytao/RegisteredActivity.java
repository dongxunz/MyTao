package com.imooc.mytao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class RegisteredActivity extends Activity {

    private ImageButton im_registered_btn;
    private Button bt_registered;
    private EditText et_registered_username,et_registered_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);

        initView();

        im_registered_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        bt_registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_registered_username.getText().toString().equals("") | et_registered_pwd.getText().toString().equals("")){
                    Toast.makeText(RegisteredActivity.this, "请输入用户名和密码", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(RegisteredActivity.this,LoginActivity.class);
//                intent.putExtra("username",et_registered_username.getText().toString());
//                intent.putExtra("password",et_registered_pwd.getText().toString());
                Bundle bundle = new Bundle();
                bundle.putString("username",et_registered_username.getText().toString());
                bundle.putString("password",et_registered_pwd.getText().toString());
                intent.putExtras(bundle);

                startActivity(intent);
                finish();
            }
        });
    }

    private void initView() {

        im_registered_btn = findViewById(R.id.im_registered_btn);

        bt_registered = findViewById(R.id.bt_registered);

        et_registered_username = findViewById(R.id.et_registered_username);
        et_registered_pwd = findViewById(R.id.et_registered_pwd);

    }
}
