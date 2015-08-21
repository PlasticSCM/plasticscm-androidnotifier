package com.codice.notifier.services;

import android.os.Bundle;
import android.util.Log;

import com.codice.notifier.app.utils.Utils;
import com.google.android.gms.gcm.GcmListenerService;

/**
 * Google Cloud Messaging listener service. All incoming notifications will be received here.
 *
 * @author Sergio Luis Para
 */
public class CloudListenerService extends GcmListenerService {

    private static final String TAG = CloudListenerService.class.toString();

    @Override
    public void onMessageReceived(String from, Bundle data) {
        super.onMessageReceived(from, data);
        Log.d(TAG, "CloudListenerService#onMessageReceived() called. " + data.toString());

        // Here, we can retrieve everything we put in the PlasticSCM trigger. Please keep in mind
        // that the maximum size of the notification's payload is 4kb.
        String title = data.getString("title");
        String message = data.getString("message");

        Utils.triggerNotification(this, title, message);
    }
}
