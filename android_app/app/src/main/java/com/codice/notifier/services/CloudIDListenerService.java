package com.codice.notifier.services;

import android.content.Intent;
import android.util.Log;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Google Cloud Messaging ID listener service. The {@link #onTokenRefresh()} method will be called
 * when our GCM token/id expires.
 *
 * @author Sergio Luis Para
 */
public class CloudIDListenerService extends InstanceIDListenerService {

    private static final String TAG = CloudIDListenerService.class.toString();

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        Log.d(TAG, "CloudIDListernerService#onTokenRefresh() has been called.");
        Intent i = new Intent(this, RegistrationIntentService.class);
        startService(i);
    }
}
