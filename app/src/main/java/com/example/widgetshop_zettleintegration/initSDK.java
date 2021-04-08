package com.example.widgetshop_zettleintegration;

import android.app.Application;
import androidx.lifecycle.ProcessLifecycleOwner;

import com.izettle.payments.android.sdk.IZettleSDK;
import com.izettle.payments.android.ui.SdkLifecycle;

public class initSDK extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initIZettleSDK();
    }

    private void initIZettleSDK() {
        String clientId = getString(R.string.client_id);
        String scheme = getString(R.string.redirect_url_scheme);
        String host = getString(R.string.redirect_url_host);
        String redirectUrl = scheme + "://" + host;
        IZettleSDK.Instance.init(this, clientId, redirectUrl);
        ProcessLifecycleOwner.get().getLifecycle().addObserver(new SdkLifecycle(IZettleSDK.Instance));
    }
}
