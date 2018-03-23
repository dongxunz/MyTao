package com.imooc.mytao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.imooc.mytao.LoginActivity;
import com.imooc.mytao.R;
import com.imooc.mytao.adapter.MeListAdapter;
import com.imooc.mytao.objects.MeListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的
 */

public class MeFragment extends Fragment {

    protected Button bt_login;

    private ImageView im_head_portrait;
    private TextView tv_username;
    private ListView me_list;

    private LinearLayout ll_me_go,ll_me_yh,ll_me_scj;

    private List<MeListItem> listData = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_me, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();

        initListItem();

        MeListAdapter adapter = new MeListAdapter(getActivity(), R.layout.ad_item, listData);

        bt_login = getActivity().findViewById(R.id.login_btn);

        im_head_portrait = getActivity().findViewById(R.id.im_head_portrait);
        tv_username = getActivity().findViewById(R.id.tv_username);
        me_list = getActivity().findViewById(R.id.me_list);

        me_list.setAdapter(adapter);

        setListener();

    }

    private void initView() {
        ll_me_go = getActivity().findViewById(R.id.me_menu_go);
        ll_me_yh = getActivity().findViewById(R.id.me_menu_sail);
        ll_me_scj = getActivity().findViewById(R.id.me_menu_yh);
    }

    private void setListener() {
        me_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), listData.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });

        ll_me_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "购物车", Toast.LENGTH_SHORT).show();
            }
        });

        ll_me_yh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "优惠券", Toast.LENGTH_SHORT).show();
            }
        });

        ll_me_scj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"收藏夹",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initListItem() {
        MeListItem item_1 = new MeListItem(R.mipmap.list_my_menu, "我的订单");
        listData.add(item_1);
        MeListItem item_2 = new MeListItem(R.mipmap.list_save, "我的收藏");
        listData.add(item_2);
        MeListItem item_3 = new MeListItem(R.mipmap.list_pwd, "我的口令");
        listData.add(item_3);
        MeListItem item_4 = new MeListItem(R.mipmap.list_my, "我的锦囊");
        listData.add(item_4);
        MeListItem item_5 = new MeListItem(R.mipmap.list_safe_center, "安全中心");
        listData.add(item_5);
        MeListItem item_6 = new MeListItem(R.mipmap.list_address, "常用地址");
        listData.add(item_6);
        MeListItem item_7 = new MeListItem(R.mipmap.list_service, "客服中心");
        listData.add(item_7);
        MeListItem item_8 = new MeListItem(R.mipmap.list_sug, "意见反馈");
        listData.add(item_8);
        MeListItem item_9 = new MeListItem(R.mipmap.list_setting, "设置");
        listData.add(item_9);
    }

    public void setData(int icon, String name) {
        im_head_portrait.setVisibility(View.VISIBLE);
        tv_username.setVisibility(View.VISIBLE);

        bt_login.setVisibility(View.INVISIBLE);

        tv_username.setText(name);
    }
}
