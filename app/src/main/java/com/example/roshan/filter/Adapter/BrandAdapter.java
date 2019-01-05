package com.example.roshan.filter.Adapter;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.roshan.filter.BrandBean;
import com.example.roshan.filter.BrandFragment;
import com.example.roshan.filter.R;

import java.util.ArrayList;
import java.util.List;

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.MyViewHolder> {

    private List<BrandBean> brandList;
    String brand;


    public BrandAdapter(List<BrandBean> brandList) {
        this.brandList = brandList;
    }

    interface Listener {
        void onClick(int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvBrand;
        private CheckBox cbBrand;

        public MyViewHolder(View itemView) {
            super(itemView);
            cbBrand = itemView.findViewById(R.id.cb_brand);
            tvBrand = itemView.findViewById(R.id.tv_brand);
        }

        @Override
        public void onClick(View v) {

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.brand_item, parent, false);
        return new BrandAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final BrandAdapter.MyViewHolder holder, final int position) {
        View v = holder.itemView;
        final BrandBean brands = brandList.get(position);
        holder.tvBrand.setText(brands.getBrand());
        holder.cbBrand.setChecked(brands.isCheck());
        if (brands.isCheck()) {
            holder.tvBrand.setTypeface(null, Typeface.BOLD);
            holder.cbBrand.setChecked(true);
            brand=holder.tvBrand.getText().toString();

        } else {
            holder.tvBrand.setTypeface(null, Typeface.NORMAL);
            holder.cbBrand.setChecked(false);
        }
        holder.cbBrand.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                brands.setCheck(cb.isChecked());
                brandList.get(position).setCheck(cb.isChecked());
                notifyDataSetChanged();
                if(cb.isChecked()){
                    BrandFragment.onDataPass.onDataPass(position,brand);
                }else {
                    BrandFragment.onDataPass.onDataPass(position,brand);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return brandList.size();
    }
    public void filterList(ArrayList<BrandBean> filteredList) {
        brandList = filteredList;
        notifyDataSetChanged();
    }
}
