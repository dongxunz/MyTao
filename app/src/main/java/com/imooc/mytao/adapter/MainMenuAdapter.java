package com.imooc.mytao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.imooc.mytao.R;
import com.imooc.mytao.entity.Menu;

import java.util.List;

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuViewholder> {

    private Context context;
    private List<Menu> menu_data;

    private MainMenuViewholder mainMenuViewholder;

    private OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;

    public MainMenuAdapter(Context context, List<Menu> menu_data) {
        this.context = context;
        this.menu_data = menu_data;
    }

    @Override
    public MainMenuViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        mainMenuViewholder =  new MainMenuViewholder(LayoutInflater.from(context).inflate(R.layout.main_menu_item,null));

        return mainMenuViewholder;
    }

    @Override
    public void onBindViewHolder(MainMenuViewholder holder, final int position) {
        Menu menu = menu_data.get(position);

        if (mOnRecyclerViewItemClickListener != null){
            mainMenuViewholder.ll_main_menu_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnRecyclerViewItemClickListener.onItemClick(position);
                }
            });
        }

        holder.main_menu_icon.setImageResource(menu.getIcon());
        holder.main_menu_name.setText(menu.getName());
        holder.ll_main_menu_item.setTag(menu_data.get(position).getIcon());
    }

    @Override
    public int getItemCount() {
        return menu_data != null ? menu_data.size() : 0;
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener onItemClickListener ){
        this. mOnRecyclerViewItemClickListener=onItemClickListener;
    }

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(int item);
    }
}

class MainMenuViewholder extends RecyclerView.ViewHolder {

    ImageView main_menu_icon;
    TextView main_menu_name;
    LinearLayout ll_main_menu_item;

    public MainMenuViewholder(View itemView) {
        super(itemView);
        main_menu_icon = itemView.findViewById(R.id.main_menu_image);
        main_menu_name = itemView.findViewById(R.id.main_menu_text);
        ll_main_menu_item = itemView.findViewById(R.id.main_menu_item);
    }
}


