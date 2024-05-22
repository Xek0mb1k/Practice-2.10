package com.mirea.kt.ribo.practice_210;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mirea.kt.ribo.practice_210.databinding.ActivityRecyclerBinding;

import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    private DBManager dbManager;
    private CarViewModel carViewModel;
    private RecyclerAdapter recyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        this.dbManager = new DBManager(new MyAppSQLiteHelper(this, "my_database.db", null, 1));

        setupRecyclerView();

//        carViewModel = new ViewModelProvider(this);


        recyclerAdapter.submitList(dbManager.LoadAllCarsFromDatabase());

        Log.d("DEBUG", "AKOPYAN OGANES RIBO-03-22");

    }

    private void setupRecyclerView() {
        RecyclerView rvShopList = findViewById(R.id.rv_car_list);

        recyclerAdapter = new RecyclerAdapter(new DiffUtil.ItemCallback<Car>() {
            @Override
            public boolean areItemsTheSame(@NonNull Car oldItem, @NonNull Car newItem) {
                return false;
            }

            @Override
            public boolean areContentsTheSame(@NonNull Car oldItem, @NonNull Car newItem) {
                return false;
            }
        });
        rvShopList.setAdapter(recyclerAdapter);
        rvShopList.setLayoutManager(new LinearLayoutManager(this));
    }
}