package com.imooc.mytao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.imooc.mytao.R;
import com.imooc.mytao.adapter.FindListAdapter;
import com.imooc.mytao.objects.FindListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * 发现
 */

public class FindFragment extends Fragment {

    private ProgressBar pb_pk1, pb_pk2;

    private RelativeLayout rl_pk1, rl_pk2;

    private ListView find_list_headlines;

    private List<FindListItem> listData = new ArrayList<>();

    private TextView tv_pk1_support, tv_pk2_support, tv_pk1_like_people, tv_pk2_like_people;

    private int pk1_number = (int) (Math.random() * 100), pk2_number = (int) (Math.random() * 100);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_find, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();

        setListener();

        initListItem();
    }

    private void initListItem() {
        listData.add(new FindListItem("从广州去东莞仅需要半个小时，美食美景统统都在等着你！", R.mipmap.find_hot_city, "源自：羊城攻略", 10526, 23));
        listData.add(new FindListItem("旅行前最最应该做的10件准备事项，千万别给忽略了", R.mipmap.find_hot_home, "源自：冬夏旅游", 10002, 15));
        listData.add(new FindListItem("北京周边尽然藏着20个绝美仙境，够你免费玩一年！", R.mipmap.find_hot_jiangnan, "源自：北京攻略", 895, 0));

    }

    private void initView() {
        pb_pk1 = getActivity().findViewById(R.id.pb_pk1);
        pb_pk2 = getActivity().findViewById(R.id.pb_pk2);

        rl_pk1 = getActivity().findViewById(R.id.rl_pk1);
        rl_pk2 = getActivity().findViewById(R.id.rl_pk2);

        tv_pk1_support = getActivity().findViewById(R.id.tv_pk1_support);
        tv_pk2_support = getActivity().findViewById(R.id.tv_pk2_support);

        tv_pk1_like_people = getActivity().findViewById(R.id.tv_pk1_like_people);
        tv_pk2_like_people = getActivity().findViewById(R.id.tv_pk2_like_people);

        find_list_headlines = getActivity().findViewById(R.id.find_list_headlines);

        tv_pk1_like_people.setText(pk1_number + "人喜欢");
        tv_pk1_support.setText(popularity_pk1() + "%");
        pb_pk1.setProgress(popularity_pk1());

        tv_pk2_like_people.setText(pk2_number + "人喜欢");
        tv_pk2_support.setText(popularity_pk2() + "%");
        pb_pk2.setProgress(popularity_pk2());
    }

    private void setListener() {
        rl_pk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pk1_number < 100) {
                    pk1_number++;
                    pb_pk1.setProgress(answer(pk1_number));
                    tv_pk1_like_people.setText(pk1_number + "人喜欢");
                    tv_pk1_support.setText(popularity_pk1() + "%");
                    tv_pk2_support.setText(popularity_pk2() + "%");
                }
            }
        });

        rl_pk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pk2_number < 100) {
                    pk2_number++;
                    pb_pk2.setProgress(answer(pk2_number));
                    tv_pk2_like_people.setText(pk2_number + "人喜欢");
                    tv_pk1_support.setText(popularity_pk1() + "%");
                    tv_pk2_support.setText(popularity_pk2() + "%");
                }
            }
        });
        FindListAdapter findListAdapter = new FindListAdapter(getActivity(), R.layout.find_headlines_item, listData);
        find_list_headlines.setAdapter(findListAdapter);
    }

    private int popularity_pk1() {
        return answer(pk1_number);
    }

    private int popularity_pk2() {
        return answer(pk2_number);
    }

    private int answer(int num) {
        int sum = pk1_number + pk2_number;
        return (num * 100 / sum);
    }
}
