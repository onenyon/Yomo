package com.zxter.anilist.auth;

import android.accounts.AccountAuthenticatorActivity;
import android.os.Bundle;

import com.zxter.anilist.R;

public class AuthActivity extends AccountAuthenticatorActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
    }
}
