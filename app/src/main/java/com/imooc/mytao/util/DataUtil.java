package com.imooc.mytao.util;

import android.content.Context;
import android.widget.ImageView;

import com.imooc.mytao.entity.Menu;

import java.util.ArrayList;
import java.util.List;

public class DataUtil {

    /**
     * @param context
     * @param icons
     * @return AdImageData
     */
    public static List<ImageView> getHeaderAdInfo(Context context, int[] icons) {
        List<ImageView> data = new ArrayList<>();
        for (int i = 0; i < icons.length; i++) {
            ImageView icon = new ImageView(context);
            icon.setScaleType(ImageView.ScaleType.CENTER_CROP);
            icon.setImageResource(icons[i]);
            data.add(icon);
        }
        return data;
    }

    public static List<Menu> getMainMenu(int icons[], String name[]) {
        List<Menu> menus = new ArrayList<>();

        for (int i = 0; i < icons.length; i++) {
            Menu menu = new Menu(icons[i], name[i]);
            menus.add(menu);
        }
        return menus;
    }
}
