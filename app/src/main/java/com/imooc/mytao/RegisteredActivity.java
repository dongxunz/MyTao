package com.imooc.mytao;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class RegisteredActivity extends Activity {

    private Button bt_back_login,bt_registered,bt_obtain_verfy;
    private EditText et_registered_username,et_registered_pwd;
    private CheckBox cb_agree_protocol;
    private TextView tv_protocol;

    private boolean isCheck;

    private static int code = 0;
    private int clock = 60;

    private Handler handler = new Handler();

    private Runnable runnable;

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

        bt_obtain_verfy = findViewById(R.id.bt_obtain_verfy);

        Drawable drawable_phone_code = getResources().getDrawable(R.mipmap.phone_code);
        drawable_phone_code.setBounds(0,0,48,48);
        et_registered_username.setCompoundDrawables(drawable_phone_code,null,null,null);

        Drawable drawable_phone_verfy = getResources().getDrawable(R.mipmap.phone_verfy);
        drawable_phone_verfy.setBounds(0,0,48,48);
        et_registered_pwd.setCompoundDrawables(drawable_phone_verfy,null,null,null);

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
                    bundle.putInt("password",code);
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
                AlertDialog dialog = new AlertDialog.Builder(RegisteredActivity.this).create();
                dialog.setCanceledOnTouchOutside(false);
                dialog.setTitle("xxx协议");
                dialog.setMessage("BalaBala~~");

                dialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cb_agree_protocol.setChecked(true);
                        dialog.dismiss();
                    }
                });
                dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cb_agree_protocol.setChecked(false);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        bt_obtain_verfy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * max 999999 //包含
                 * min 100000 //包含
                 *
                 *  new Random().nextInt(max - min + 1)
                 *  [0,900000)
                 *
                 *  new Random().nextInt(max - min + 1) + min
                 *  [100000,1000000)
                 */
                code = (new Random().nextInt(900000) + 100000);

                Toast.makeText(RegisteredActivity.this, String.valueOf(code), Toast.LENGTH_LONG).show();

                runnable = new Runnable() {
                    @Override
                    public void run() {
                        if (clock > 0) {
                            bt_obtain_verfy.setText(clock + "S");
                            clock--;
                            handler.postDelayed(this, 1000);
                        } else {
                            bt_obtain_verfy.setText("获取验证码");
                            et_registered_pwd.setText("");
                            clock = 60;
                            code = -1;
                        }
                    }
                };

                //将线程Runnable对象放入runOnUiThread()中，使得该对象可以更新UI，否则报错
                RegisteredActivity.this.runOnUiThread(runnable);
                et_registered_pwd.setText(String.valueOf(code));
            }
        });
    }

    public static int getCode(){
        return code;
    }
}
