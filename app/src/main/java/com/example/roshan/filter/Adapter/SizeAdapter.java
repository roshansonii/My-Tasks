package com.example.roshan.filter.Adapter;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.roshan.filter.R;
import com.example.roshan.filter.SizeBean;

import java.util.ArrayList;

public class SizeAdapter extends RecyclerView.Adapter<SizeAdapter.MyViewHolder> {

    private ArrayList<SizeBean> sizeList;

    public SizeAdapter(ArrayList<SizeBean> sizeList) {
        this.sizeList = sizeList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvBrand;
        public CheckBox cbBrand;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvBrand = itemView.findViewById(R.id.tv_brand);
            cbBrand = itemView.findViewById(R.id.cb_brand);
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.brand_item, viewGroup, false);
        return new SizeAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SizeAdapter.MyViewHolder holder, final int position) {

        View v = holder.itemView;
        final SizeBean size = sizeList.get(position);
        holder.cbBrand.setChecked(size.isColorCheck());
        holder.tvBrand.setText(size.getColor());

        if (size.isColorCheck()) {
            holder.tvBrand.setTypeface(null, Typeface.BOLD);
            holder.cbBrand.setChecked(true);
            String message=holder.tvBrand.getText().toString();


        } else {
            holder.tvBrand.setTypeface(null, Typeface.NORMAL);
            holder.cbBrand.setChecked(false);
        }
        holder.cbBrand.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                size.setColorCheck(cb.isChecked());
                sizeList.get(position).setColorCheck(cb.isChecked());
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return sizeList.size();
    }

    public void filterList(ArrayList<SizeBean> filteredList) {
        sizeList = filteredList;
        notifyDataSetChanged();
    }

}
