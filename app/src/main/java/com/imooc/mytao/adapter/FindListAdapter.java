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
import com.imooc.mytao.objects.FindListItem;

import java.util.List;

public class FindListAdapter extends ArrayAdapter{

    private int resourceId;

    public FindListAdapter(@NonNull Context context, int resource, @NonNull List<FindListItem> data) {
        super(context, resource, data);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        FindListItem findListItem = (FindListItem) getItem(position);

        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);

        TextView tv_title = view.findViewById(R.id.tv_title);
        ImageView iv_image = view.findViewById(R.id.iv_image);
        TextView tv_context = view.findViewById(R.id.tv_context);
        TextView tv_look_people = view.findViewById(R.id.tv_look_people);
        TextView tv_good_people = view.findViewById(R.id.tv_good_people);

        tv_title.setText(findListItem.getTitle_name());
        iv_image.setImageResource(findListItem.getImage());
        tv_context.setText(findListItem.getContext());
        tv_look_people.setText(String.valueOf(findListItem.getLook_people()));
        tv_good_people.setText(String.valueOf(findListItem.getGood_people()));

        return view;
    }
}
