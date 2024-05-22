package com.mirea.kt.ribo.practice_210;

import android.annotation.SuppressLint;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class RecyclerAdapter extends ListAdapter<Car, CarViewModel> {


    protected RecyclerAdapter(DiffUtil.ItemCallback<Car> diffCallback) {
        super(diffCallback);
    }

    protected RecyclerAdapter(AsyncDifferConfig<Car> config) {
        super(config);
    }


    @NonNull
    @Override
    public CarViewModel onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout = R.layout.car_item;
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new CarViewModel(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CarViewModel holder, int position) {
        Car carItem = getItem(position);

        holder.getTvCarModel().setText("Model: " + carItem.getModel());
        holder.getTvCarNumber().setText("Number: " + String.valueOf(carItem.getNumber()));
        holder.getTvCarYear().setText("Year: " + String.valueOf(carItem.getYearOfIssue()));

    }
}
