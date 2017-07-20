package com.zxter.yomo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zxter.anilist.AnilistApi;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        AnilistApi.addAccount(this);
        AnilistApi.launchUrl(this);

    }
}
