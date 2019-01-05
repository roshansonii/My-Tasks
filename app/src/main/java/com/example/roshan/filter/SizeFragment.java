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

import com.example.roshan.filter.Adapter.SizeAdapter;

import java.util.ArrayList;
import java.util.List;


public class SizeFragment extends Fragment {

    ArrayList<SizeBean> sizeList = new ArrayList<>();
    private List<SizeBean> list;
    RecyclerView recyclerView;
    private SizeAdapter adapter;
    private View layout;
    EditText etSearch;

    public SizeFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_size, container, false);


        recyclerView=layout.findViewById(R.id.list_size);

        adapter=new SizeAdapter(sizeList);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        assert recyclerView != null;

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
        List<SizeBean> list = new ArrayList<SizeBean>();
        SizeBean size1=new SizeBean("6",false);
        list.add(size1);

        SizeBean size2=new SizeBean("7",false);
        list.add(size2);

        SizeBean size3=new SizeBean("8",false);
        list.add(size3);

        SizeBean size4=new SizeBean("9",false);
        list.add(size4);

        SizeBean size5=new SizeBean("10",false);
        list.add(size5);

        SizeBean size6=new SizeBean("11",false);
        list.add(size6);

        sizeList.addAll(list);

    }
    private void filter(String text) {
        ArrayList<SizeBean> filteredList = new ArrayList<>();

        for (SizeBean item : sizeList) {
            if (item.getColor().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        adapter.filterList(filteredList);
    }

}
