package com.geekhouze.qwikbuy.item.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geekhouze.qwikbuy.R;

public class FragmentItemInfo extends Fragment {
    View view;
    public FragmentItemInfo() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_item_info, container, false);
        return view;
    }
}
