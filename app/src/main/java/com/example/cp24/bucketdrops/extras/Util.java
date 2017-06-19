package com.example.cp24.bucketdrops.extras;

import android.view.View;

import java.util.List;

/**
 * Created by cp24 on 2017-06-19.
 */

public class Util {
    public static void showViews(List<View> views) {
        for(View view : views) {
            view.setVisibility(View.VISIBLE);
        }
    }

    public static void hideViews(List<View> views) {
        for(View view : views) {
            view.setVisibility(View.GONE);
        }
    }
}

