package com.imooc.mytao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.imooc.mytao.R;

/**
 * 发现
 */

public class FindFragment extends Fragment {

    private ProgressBar pb_pk1, pb_pk2;

    private RelativeLayout rl_pk1, rl_pk2;

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

        tv_pk1_like_people.setText(pk1_number + "人喜欢");
        tv_pk1_support.setText(answer(pk1_number) + "%");
        pb_pk1.setProgress(answer(pk1_number));

        tv_pk2_like_people.setText(pk2_number + "人喜欢");
        tv_pk2_support.setText(answer(pk2_number) + "%");
        pb_pk2.setProgress(answer(pk2_number));
    }

    private void setListener() {
            rl_pk1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (pk1_number < 100) {
                        pb_pk1.setProgress(pk1_number++);
                        tv_pk1_like_people.setText(pk1_number + "人喜欢");
                        tv_pk1_support.setText(answer(pk1_number) + "%");
                        tv_pk2_support.setText(answer(pk2_number) + "%");
                    }
                }
            });

            rl_pk2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (pk2_number < 100) {
                        pb_pk2.setProgress(pk2_number++);
                        tv_pk2_like_people.setText(pk2_number + "人喜欢");
                        tv_pk1_support.setText(answer(pk1_number) + "%");
                        tv_pk2_support.setText(answer(pk2_number) + "%");
                    }
                }
            });
    }

    private int answer(int num){
        int sum = pk1_number + pk2_number;
        return (num*100/sum);
    }
}
