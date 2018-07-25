package com.example.bodhi64.tvshowsandmovies.searching;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bodhi64.tvshowsandmovies.R;

public class SearchTvContentActivity extends AppCompatActivity{

   public static String search="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        SearchingFragment fragment = SearchingFragment.getInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment, "fragmentTag").commit();

        if(getIntent()!=null)
            search=getIntent().getStringExtra("key");

    }
}
