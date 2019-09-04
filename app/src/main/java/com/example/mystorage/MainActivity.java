package com.example.mystorage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.mystorage.adapter.RecyclerViewAdapter;
import com.example.mystorage.model.Item;
import com.example.mystorage.viewmodel.ItemViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements AddItemDialog.OnInputListener {

    private static final String TAG = "MainActivity";

    private FloatingActionButton mFab;
    private RecyclerViewAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private ProgressBar mProgress;
    private ItemViewModel mItemViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFab = findViewById(R.id.fab);
        mProgress = findViewById(R.id.progress_bar);
        mRecyclerView = findViewById(R.id.recycleview);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: opening dialog.");

                AddItemDialog dialog = new AddItemDialog();
                dialog.show(getSupportFragmentManager(), "AddItemDialog");
            }
        });

        mItemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);

        mItemViewModel.init();

        mItemViewModel.getItemsInStorage().observe(this, new Observer<List<Item>>() {
            @Override
            public void onChanged(List<Item> items) {
                mAdapter.notifyDataSetChanged();
            }
        });

        initRecyclerView();

    }

    private void initRecyclerView () {
        mAdapter = new RecyclerViewAdapter(this, mItemViewModel.getItemsInStorage().getValue());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void showProgressBar() {
        mProgress.setVisibility(View.VISIBLE);
    }

    private  void  hideProgressBar() {
        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void sendInput(String input) {
        String uuid = uuid = UUID.randomUUID().toString().replace("-", "");
        mItemViewModel.addItem(new Item(uuid, input, "", ""));
    }

}
