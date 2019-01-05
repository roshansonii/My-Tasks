package com.example.roshan.filter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;


public class RangeBarFragment extends Fragment {


    public RangeBarFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_range_bar, container, false);
        final CrystalRangeSeekbar rangeSeekbar = layout.findViewById(R.id.rangeSeekBar1);
        final TextView tvMin = layout.findViewById(R.id.min);
        final TextView tvMax = layout.findViewById(R.id.max);


        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText(String.valueOf(minValue));
                tvMax.setText(String.valueOf(maxValue));
                rangeSeekbar.setMinValue(500);
                rangeSeekbar.setMaxValue(4000);

            }
        });

        rangeSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS = >", String.valueOf(minValue) + " : " + String.valueOf(maxValue));

            }
        });

        return layout;
    }

}
