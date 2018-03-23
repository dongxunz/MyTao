package com.imooc.mytao.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.imooc.mytao.R;
import com.imooc.mytao.adapter.MainHeaderAdAdapter;
import com.imooc.mytao.adapter.MainMenuAdapter;
import com.imooc.mytao.util.DataUtil;

/**
 * 主界面
 */

public class MainFragment extends Fragment{

    protected ViewPager viewPager;

    private ImageView vp_image;

    private LinearLayout ll_title_scan,ll_title_news;
    private RecyclerView recyclerView;

    private EditText ed_search;

    private TextView tv_edit_text;

    protected int[] adIcons = {R.mipmap.header_pic_ad1,R.mipmap.header_pic_ad2};

    private int[] adIndexImage = {R.mipmap.nav_header_index_one,R.mipmap.nav_header_index_two};

    private int[] mainMenuIcons = {
            R.mipmap.menu_airport,
            R.mipmap.menu_hatol,
            R.mipmap.menu_trav,
            R.mipmap.menu_nearby,

            R.mipmap.menu_ticket,
            R.mipmap.menu_train,
            R.mipmap.menu_course,
            R.mipmap.menu_car
    };

    private String[] mainMenuName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
        
        setListener();

        MainHeaderAdAdapter mainHeaderAdAdapter = new MainHeaderAdAdapter(getActivity(), DataUtil.getHeaderAdInfo(getActivity(),adIcons));
        viewPager.setAdapter(mainHeaderAdAdapter);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),4));
        MainMenuAdapter mainMenuAdapter = new MainMenuAdapter(getActivity(),DataUtil.getMainMenu(mainMenuIcons,mainMenuName));
        mainMenuAdapter.setOnItemClickListener(new MainMenuAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(int item) {
                Toast.makeText(getActivity(),"您点击了"+item+"个",Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(mainMenuAdapter);
    }

    private void initView() {
        viewPager = getActivity().findViewById(R.id.viewPager);

        vp_image = getActivity().findViewById(R.id.vp_image);

        ll_title_scan = getActivity().findViewById(R.id.title_scan);
        ll_title_news = getActivity().findViewById(R.id.title_news);

        recyclerView = getActivity().findViewById(R.id.recycler_view_main_menu);

        mainMenuName = getActivity().getResources().getStringArray(R.array.main_menu);

        ed_search = getActivity().findViewById(R.id.ed_search);

        tv_edit_text = getActivity().findViewById(R.id.tv_edit_text);
    }

    private void setListener() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                vp_image.setImageResource(adIndexImage[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        ll_title_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "扫一扫", Toast.LENGTH_SHORT).show();
            }
        });
        
        ll_title_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "消息", Toast.LENGTH_SHORT).show();
            }
        });

        final Drawable drawable = getResources().getDrawable(R.mipmap.search);
        drawable.setBounds(0,0,40,40);
        ed_search.setCompoundDrawables(drawable,null,null,null);
        tv_edit_text.setCompoundDrawables(drawable,null,null,null);

        ed_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count != 0){
                    ed_search.setCompoundDrawables(null,null,null,null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s)) {
                    tv_edit_text.setVisibility(View.VISIBLE);
                    ed_search.setVisibility(View.GONE);
                    ed_search.setCompoundDrawables(drawable, null, null, null);
                }
            }
        });

        tv_edit_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_edit_text.setVisibility(View.GONE);

                ed_search.setVisibility(View.VISIBLE);
            }
        });
    }
}
