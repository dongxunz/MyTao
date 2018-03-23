package com.imooc.mytao;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.imooc.mytao.fragment.FindFragment;
import com.imooc.mytao.fragment.MainFragment;
import com.imooc.mytao.fragment.MeFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mMenuMain, mMenuFind, mMenuMe;

    private MainFragment mainFragment = new MainFragment();
    private FindFragment findFragment = new FindFragment();
    private MeFragment meFragment = new MeFragment();

    private int i = 0, j = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMenuMain = findViewById(R.id.menu_main);
        mMenuFind = findViewById(R.id.menu_find);
        mMenuMe = findViewById(R.id.menu_me);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.content, mainFragment)
                .add(R.id.content, findFragment).hide(findFragment)
                .add(R.id.content, meFragment).hide(meFragment)
                .commit();

        mMenuMain.setOnClickListener(this);
        mMenuFind.setOnClickListener(this);
        mMenuMe.setOnClickListener(this);

        getExtraIntent();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_main:
                getSupportFragmentManager().beginTransaction()
                        .show(mainFragment)
                        .hide(findFragment)
                        .hide(meFragment)
                        .commit();
                break;
            case R.id.menu_find:
                getSupportFragmentManager().beginTransaction()
                        .hide(mainFragment)
                        .show(findFragment)
                        .hide(meFragment)
                        .commit();
                break;
            case R.id.menu_me:
                getSupportFragmentManager().beginTransaction()
                        .hide(mainFragment)
                        .hide(findFragment)
                        .show(meFragment)
                        .commit();
                break;
        }
    }

    /**
     * 按两次返回键退出
     */
    @Override
    public void onBackPressed() {
        if (j == 0) {
            Toast.makeText(MainActivity.this, "再按一次返回键退出", Toast.LENGTH_SHORT).show();
            j++;
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                i = 0;
                j = 0;
            }
        }, 2000);

        if (++i > 1) {
            getSupportFragmentManager().beginTransaction()
                    .remove(mainFragment)
                    .remove(findFragment)
                    .remove(meFragment)
                    .commit();
            MainActivity.this.finish();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        setIntent(intent);

        getExtraIntent();
    }

    private void getExtraIntent() {
        Intent intent = getIntent();

        //Activity跳转到指定Fragment
        if (intent.getStringExtra("Flag") != null) {
            if (intent.getStringExtra("Flag").equals("MeFragment")) {

                getSupportFragmentManager().beginTransaction()
                        .hide(mainFragment)
                        .hide(findFragment)
                        .show(meFragment)
                        .commit();

                Bundle bundle = intent.getBundleExtra("data");
                if (bundle != null) {
                    meFragment.setData(0, bundle.getString("username"));
                }
            }
        }
    }
}
