package com.example.roshan.filter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.roshan.filter.Adapter.ColorAdapter;

import java.util.ArrayList;

public class ColorFragment extends Fragment {

    ArrayList<ColorBean> colorList = new ArrayList<>();
    ColorAdapter adapter;
    RecyclerView recyclerView;
    EditText etSearch;

    public ColorFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout= inflater.inflate(R.layout.fragment_color, container, false);

        recyclerView =layout.findViewById(R.id.list_color);
        adapter=new ColorAdapter(colorList);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        etSearch=layout.findViewById(R.id.search_size);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        adapter.notifyDataSetChanged();

        addData();
        return layout;
    }

    private void addData() {

        ColorBean color1 = new ColorBean("Black", false);
        colorList.add(color1);

        ColorBean color2 = new ColorBean("Blue", false);
        colorList.add(color2);

        ColorBean color3 = new ColorBean("Dark Blue", false);
        colorList.add(color3);

        ColorBean color4 = new ColorBean("Silver", false);
        colorList.add(color4);

        ColorBean color5 = new ColorBean("White", false);
        colorList.add(color5);

        ColorBean color6 = new ColorBean("Olive Green", false);
        colorList.add(color6);
    }
    private void filter(String text) {
        ArrayList<ColorBean> filteredList = new ArrayList<>();

        for (ColorBean item : colorList) {
            if (item.getColor().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        adapter.filterList(filteredList);
    }

}
