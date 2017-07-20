package com.zxter.anilist;

import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.util.Log;

public class AnilistApi {
    public static final String API_BASE_URL = "https://anilist.co/api/";
    public static final CustomTabsIntent tabsIntent = new CustomTabsIntent.Builder().setToolbarColor(Color.BLACK).build();

    public static Uri getAuthCodeUri(final String clientId,
                                     final String clientSecret,
                                     final String redirectUri) {
        Uri.Builder builder = Uri.parse(API_BASE_URL + "auth/authorize").buildUpon();
        builder
                .appendQueryParameter("grant_type", "authorization_code")
                .appendQueryParameter("client_id", clientId)
                .appendQueryParameter("client_secret", clientSecret)
                .appendQueryParameter("redirect_uri", redirectUri)
                .appendQueryParameter("response_type", "code");
        return builder.build();
    }

    private static final String CLIENT_ID = BuildConfig.CLIENT_ID;
    private static final String CLIENT_SECRET = BuildConfig.CLIENT_SECRET;
    private static final String REDIRECT_URI = BuildConfig.REDIRECT_URI;

    public static Uri AUTH_URI = getAuthCodeUri(CLIENT_ID, CLIENT_SECRET, REDIRECT_URI);

    public static void launchUrl(Activity activity) {
        Log.d("Auth Url", AUTH_URI.toString());

        tabsIntent.intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        tabsIntent.intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        tabsIntent.launchUrl(activity, AUTH_URI);
    }

    public static void addAccount(Activity activity) {
        final AccountManager manager = AccountManager.get(activity);
        final String accountType = activity.getString(R.string.account_type);

        Log.i(AnilistApi.class.getSimpleName(), "Add account " + accountType);

        manager.addAccount(accountType, "AuthtokenType", null, null, activity, new
                AccountManagerCallback<Bundle>() {
                    @Override
                    public void run(AccountManagerFuture<Bundle> future) {

                    }
                }, null);
    }
}
