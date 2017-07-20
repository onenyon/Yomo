package com.zxter.anilist.auth.authenticate;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class YomoAuthenticatorService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        YomoAuthenticator authenticator = new YomoAuthenticator(this);
        return authenticator.getIBinder();
    }
}
