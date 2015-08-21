package com.codice.notifier.services;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.gcm.GcmReceiver;

/**
 * Google Cloud Messaging receiver class, necessary in order to wake up the device and receive
 * notifications even with the screen off or in deep sleep state.
 *
 * @author Sergio Luis Para
 */
public class CloudMessagingReceiver extends GcmReceiver {

    private static final String TAG = CloudMessagingReceiver.class.toString();

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        Log.d(TAG, "CloudMessagingReceiver#onReceive() called. " + intent.toString());
    }
}
