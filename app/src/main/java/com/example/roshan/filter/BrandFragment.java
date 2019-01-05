package com.example.roshan.filter;

import android.app.Activity;
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

import com.example.roshan.filter.Adapter.BrandAdapter;

import java.util.ArrayList;
import java.util.List;

public class BrandFragment extends Fragment {
    private List<BrandBean> brandList = new ArrayList<>();
    public RecyclerView recyclerView;
    BrandAdapter adapter;
    EditText etSearch;
    public BrandFragment() {

    }
    public static OnDataPass onDataPass;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onDataPass = (OnDataPass) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }
    @Override
    public void onDetach(){
        super.onDetach();


    }

    final String LOG_TAG = "myLogs";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_brand, container, false);
        recyclerView = layout.findViewById(R.id.list_brand);
        adapter = new BrandAdapter(brandList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
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

        addCategoriesData();
        return layout;

    }

    private void addCategoriesData() {
        BrandBean brand1 = new BrandBean("Adidas", false);

        brandList.add(brand1);

        BrandBean brand2 = new BrandBean("Puma", false);
        brandList.add(brand2);

        BrandBean brand3 = new BrandBean("Sparx", false);
        brandList.add(brand3);

        BrandBean brand4 = new BrandBean("Super Dry", false);
        brandList.add(brand4);

        BrandBean brand5 = new BrandBean("Tommy Hilfiger", false);
        brandList.add(brand5);

        BrandBean brand6 = new BrandBean("Peter England", false);
        brandList.add(brand6);

    }

    private void filter(String text) {
        ArrayList<BrandBean> filteredList = new ArrayList<>();

        for (BrandBean item : brandList) {
            if (item.getBrand().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList);
    }

}
