package com.imooc.mytao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.imooc.mytao.R;

public class LoginFragment extends Fragment {

    private ImageButton close_login;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_login,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();

        setListener();
    }

    private void initView() {
        close_login = getActivity().findViewById(R.id.im_btn);

//        tv_registered = findViewById(R.id.tv_registered);
//
//        et_username = findViewById(R.id.et_username);
//        et_pwd = findViewById(R.id.et_pwd);
//
//        bt_login = findViewById(R.id.bt_login);

    }

    private void setListener() {
        close_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

//        tv_registered.setOnClickListener(this);
//
//        bt_login.setOnClickListener(this);
    }

}
