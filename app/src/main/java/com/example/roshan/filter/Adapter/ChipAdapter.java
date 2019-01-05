package com.example.roshan.filter.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.roshan.filter.R;

import java.util.ArrayList;

public class ChipAdapter extends RecyclerView.Adapter<ChipAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<String> chipList;
    private BrandAdapter.Listener listener;

    public ChipAdapter(ArrayList<String> chipList) {
        this.chipList = chipList;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvChip;
        private Button chipClose;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvChip=itemView.findViewById(R.id.chip_text);
            chipClose =itemView.findViewById(R.id.chip_close);

        }
    }
    @Override
    public ChipAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chip_item, parent, false);
        return new ChipAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ChipAdapter.MyViewHolder holder, final int position) {
        View v = holder.itemView;
        final String chip_item = chipList.get(position);
        holder.tvChip.setText(chip_item);

        holder.chipClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chipList.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return chipList.size();
    }

}
