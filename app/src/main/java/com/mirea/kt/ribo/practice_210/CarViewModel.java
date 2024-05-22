package com.mirea.kt.ribo.practice_210;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CarViewModel extends RecyclerView.ViewHolder {
    TextView tvCarModel, tvCarNumber, tvCarYear;
    public CarViewModel(View view) {
        super(view);
        tvCarModel = view.findViewById(R.id.tv_car_model);
        tvCarNumber = view.findViewById(R.id.tv_car_number);
        tvCarYear = view.findViewById(R.id.tv_car_year);
    }

    public TextView getTvCarModel() {
        return tvCarModel;
    }

    public TextView getTvCarNumber() {
        return tvCarNumber;
    }

    public TextView getTvCarYear() {
        return tvCarYear;
    }
}
