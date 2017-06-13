package com.example.cp24.bucketdrops;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.cp24.bucketdrops.adapters.AdapterDrops;


public class ActivityMain extends AppCompatActivity {
    ImageView logo;
    Toolbar mToolbar;
    Button mBtnAdd;
    RecyclerView mRecycler;

    private View.OnClickListener mBtnAddListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            showDialogAdd();
        }
    };

    private void showDialogAdd() {
        DialogAdd dialog = new DialogAdd();
        dialog.show(getSupportFragmentManager(), "Add");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo =  (ImageView) findViewById(R.id.iv_logo);
        mRecycler = (RecyclerView) findViewById(R.id.rv_drops);

        // setting LayoutManager in code
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(manager);

        mRecycler.setAdapter(new AdapterDrops(this));

        mBtnAdd = (Button) findViewById(R.id.btn_add);
        mBtnAdd.setOnClickListener(mBtnAddListener);



        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        initBackgroundImage();


    }

    private void initBackgroundImage() {
        ImageView background = (ImageView) findViewById(R.id.iv_background);
        Glide.with(this)
                .load(R.drawable.background)
                .centerCrop()
                .into(background);
    }
}
