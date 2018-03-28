package com.imooc.mytao.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class MainHeaderAdAdapter extends PagerAdapter {

    private Context context;
    private List<ImageView> images;

    public MainHeaderAdAdapter(Context context, List<ImageView> images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images != null ? images.size() : 0;
    }

    //初始化
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        ImageView imageView = images.get(position);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "你点击了:" + position, Toast.LENGTH_SHORT).show();
            }
        });

        container.addView(imageView);

        return imageView;
    }

    //判断是否来自Object对象
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    //销毁
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(images.get(position));
    }
}
