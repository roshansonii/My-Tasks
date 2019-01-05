package com.example.roshan.filter.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.roshan.filter.ColorBean;
import com.example.roshan.filter.R;

import java.util.ArrayList;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<ColorBean> colorList;

    public ColorAdapter(ArrayList<ColorBean> colorList) {
        this.colorList = colorList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvBrand;
        private CheckBox cbBrand;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvBrand = itemView.findViewById(R.id.tv_brand);
            cbBrand = itemView.findViewById(R.id.cb_brand);

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.brand_item, viewGroup, false);
        return new ColorAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ColorAdapter.MyViewHolder holder, final int position) {

        View v = holder.itemView;
        final ColorBean color = colorList.get(position);
        holder.cbBrand.setChecked(color.isColorCheck());
        holder.tvBrand.setText(color.getColor());

        if (color.isColorCheck()) {
            holder.tvBrand.setTypeface(null, Typeface.BOLD);
            holder.cbBrand.setChecked(true);
            //  String message=holder.tvBrand.getText().toString();

        } else {
            holder.tvBrand.setTypeface(null, Typeface.NORMAL);
            holder.cbBrand.setChecked(false);
        }
        holder.cbBrand.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                color.setColorCheck(cb.isChecked());
                colorList.get(position).setColorCheck(cb.isChecked());
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return colorList.size();
    }

    public void filterList(ArrayList<ColorBean> filteredList) {
        colorList = filteredList;
        notifyDataSetChanged();
    }


}
