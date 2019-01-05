package com.example.roshan.filter.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.roshan.filter.R;
import com.example.roshan.filter.TypeBean;

import java.util.ArrayList;

public class TypeAdapter extends RecyclerView.Adapter<TypeAdapter.MyViewHolder> {
    private Context context;
    ArrayList<TypeBean> typeList;

    public TypeAdapter(ArrayList<TypeBean> typeBeans) {
        this.typeList = typeBeans;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvBrand;
        private CheckBox cbBrand;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvBrand=itemView.findViewById(R.id.tv_brand);
            cbBrand=itemView.findViewById(R.id.cb_brand);

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.brand_item, viewGroup, false);
        return new TypeAdapter.MyViewHolder(itemView);    }

    @Override
    public void onBindViewHolder(final TypeAdapter.MyViewHolder holder, final int position) {
        View v=holder.itemView;
        final TypeBean type=typeList.get(position);
        holder.cbBrand.setChecked(type.isTypeCheck());
        holder.tvBrand.setText(type.getType());

        if (type.isTypeCheck()) {
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
                type.setTypeCheck(cb.isChecked());
                typeList.get(position).setTypeCheck(cb.isChecked());
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return typeList.size();
    }

    public void filterList(ArrayList<TypeBean> filteredList) {
        typeList = filteredList;
        notifyDataSetChanged();
    }
}
