package com.example.roshan.filter.Adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.roshan.filter.FilterCategories;
import com.example.roshan.filter.R;

import java.util.List;

public class FilterCategoriesAdapter extends RecyclerView.Adapter<FilterCategoriesAdapter.MyViewHolder> {

    private List<FilterCategories> list;
    private Listener listener;
    private int selected_position = -1;

    public FilterCategoriesAdapter(List<FilterCategories> list) {
        this.list = list;
    }

    public interface Listener {
        void onClick(int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvCategories;
        public ImageView imSelected;
        public LinearLayout rowLinearLayout;

        public MyViewHolder(final View itemView) {
            super(itemView);
            rowLinearLayout = itemView.findViewById(R.id.linearlayout);
            imSelected = itemView.findViewById(R.id.imselected);
            tvCategories = itemView.findViewById(R.id.tvCategories);

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.filter_category_item, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        View v = holder.itemView;
        FilterCategories categories = list.get(position);
        holder.tvCategories.setText(categories.getTitle());
        holder.imSelected.setVisibility(View.GONE);

        if (selected_position == position) {
            holder.rowLinearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
            holder.tvCategories.setBackgroundColor(Color.parseColor("#FFFFFF"));
            holder.tvCategories.setTextColor(Color.parseColor("#D81B60"));
            holder.imSelected.setVisibility(View.VISIBLE);
        } else {
            holder.rowLinearLayout.setBackgroundColor(Color.parseColor("#f9f6f6"));
            holder.tvCategories.setBackgroundColor(Color.parseColor("#f9f6f6"));
            holder.tvCategories.setTextColor(Color.parseColor("#000000"));
            holder.imSelected.setVisibility(View.GONE);
        }

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    int position = holder.getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onClick(position);
                        selected_position = position;
                        notifyDataSetChanged();
                    }
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

}
