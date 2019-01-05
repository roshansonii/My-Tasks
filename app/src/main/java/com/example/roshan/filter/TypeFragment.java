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

import com.example.roshan.filter.Adapter.TypeAdapter;

import java.util.ArrayList;


public class TypeFragment extends Fragment {
    ArrayList<TypeBean> typeItems = new ArrayList<TypeBean>();
    RecyclerView recyclerView;
    TypeAdapter adapter;
    EditText etSearch;

    public TypeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_type, container, false);

        recyclerView = layout.findViewById(R.id.list_type);
        adapter = new TypeAdapter(typeItems);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);


        adapter.notifyDataSetChanged();
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

        addData();
        return layout;
    }

    private void addData() {
        TypeBean type1 = new TypeBean("Sports", false);
        typeItems.add(type1);

        TypeBean type2 = new TypeBean("Sneakers", false);
        typeItems.add(type2);

        TypeBean type3 = new TypeBean("Boots", false);
        typeItems.add(type3);

        TypeBean type4 = new TypeBean("Slip On", false);
        typeItems.add(type4);

        TypeBean type5 = new TypeBean("Canvas", false);
        typeItems.add(type5);

        TypeBean type6 = new TypeBean("Loafers", false);
        typeItems.add(type6);

    }
    private void filter(String text) {
        ArrayList<TypeBean> filteredList = new ArrayList<>();

        for (TypeBean item : typeItems) {
            if (item.getType().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        adapter.filterList(filteredList);
    }

}
