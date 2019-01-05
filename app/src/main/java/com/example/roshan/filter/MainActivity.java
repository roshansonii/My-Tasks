package com.example.roshan.filter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.roshan.filter.Adapter.ChipAdapter;
import com.example.roshan.filter.Adapter.FilterCategoriesAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements OnDataPass {

    private List<FilterCategories> categoriesList = new ArrayList<>();
    public RecyclerView recyclerView, recyclerView1;
    Fragment rangeBarFragment, brandFragment, typeFragment, colorFragment, sizeFragment;
    ArrayList<String> chip = new ArrayList<>();
    ChipAdapter chipAdapter;

    @Override
    public void onDataPass(int position,String data) {
        if(!chip.contains(data)){
            chip.add(data);
            chipAdapter.notifyDataSetChanged();
            chipAdapter.notifyItemChanged(position,data);
        }else {
            chip.remove(data);
            chipAdapter.notifyDataSetChanged();
            chipAdapter.notifyItemRemoved(position);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView1 = findViewById(R.id.list_chip);
        chipAdapter = new ChipAdapter(chip);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());
        recyclerView1.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayoutManager.VERTICAL));
        recyclerView1.setAdapter(chipAdapter);

        recyclerView = findViewById(R.id.filter_dialog_categories);
        FilterCategoriesAdapter adapter = new FilterCategoriesAdapter(categoriesList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        adapter.setListener(new FilterCategoriesAdapter.Listener() {

            @Override
            public void onClick(int position) {


                if (position == 0) {
                    rangeBarFragment = new RangeBarFragment();

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmen_container, rangeBarFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();


                } else if (position == 1) {
                    brandFragment = new BrandFragment();

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmen_container, brandFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                } else if (position == 2) {
                    typeFragment = new TypeFragment();

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmen_container, typeFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                } else if (position == 3) {
                    colorFragment = new ColorFragment();

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmen_container, colorFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                } else if (position == 4) {
                    sizeFragment = new SizeFragment();

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmen_container, sizeFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                }

            }
        });
        addCategoriesData();
    }

    private void addCategoriesData() {

        FilterCategories price = new FilterCategories("Price");
        categoriesList.add(price);

        FilterCategories brand = new FilterCategories("Brand");
        categoriesList.add(brand);

        FilterCategories type = new FilterCategories("Type");
        categoriesList.add(type);

        FilterCategories color = new FilterCategories("Color");
        categoriesList.add(color);

        FilterCategories size = new FilterCategories("Size");
        categoriesList.add(size);
    }


}

