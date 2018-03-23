package com.imooc.mytao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.imooc.mytao.R;
import com.imooc.mytao.objects.MeListItem;

import java.util.List;

public class MeListAdapter extends ArrayAdapter {
    private int resource;

    public MeListAdapter(@NonNull Context context, int resourceId, List<MeListItem> meListItems) {
        super(context, resourceId, meListItems);
        resource = resourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MeListItem item = (MeListItem) getItem(position);

        View view = LayoutInflater.from(getContext()).inflate(resource,null);
        ImageView adImage = view.findViewById(R.id.image_id);
        TextView adText = view.findViewById(R.id.text_id);

        adImage.setImageResource(item.getImageId());
        adText.setText(item.getName());
        return view;
    }
}
