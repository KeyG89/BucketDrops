package com.example.cp24.bucketdrops;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.cp24.bucketdrops.adapters.AdapterDrops;
import com.example.cp24.bucketdrops.beans.Drop;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;


public class ActivityMain extends AppCompatActivity {
    private static final String TAG = "ACTIVITY_MAIN";
    ImageView logo;
    Toolbar mToolbar;
    Button mBtnAdd;
    RecyclerView mRecycler;
    Realm mRealm;
    RealmResults<Drop> mResults;
    AdapterDrops mAdapter;

    private View.OnClickListener mBtnAddListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            showDialogAdd();
        }
    };

    private RealmChangeListener mChangeListener = new RealmChangeListener() {
        @Override
        public void onChange() {
            Log.d(TAG, "onChange: was called");
            mAdapter.update(mResults);
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

        mRealm = Realm.getDefaultInstance();
        mResults = mRealm.where(Drop.class).findAllAsync();

        logo =  (ImageView) findViewById(R.id.iv_logo);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mBtnAdd = (Button) findViewById(R.id.btn_add);
        mRecycler = (RecyclerView) findViewById(R.id.rv_drops);
        mAdapter = new AdapterDrops(this, mResults);


        // setting LayoutManager in code
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(manager);

        mRecycler.setAdapter(mAdapter);

        mBtnAdd.setOnClickListener(mBtnAddListener);




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

    @Override
    protected void onStart(){
        super.onStart();
        mResults.addChangeListener(mChangeListener);
    }

    @Override
    protected void onStop(){
        super.onStop();
        mResults.removeChangeListener(mChangeListener);
    }

}
