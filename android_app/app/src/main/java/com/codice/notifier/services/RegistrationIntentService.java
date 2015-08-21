package com.codice.notifier.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.codice.notifier.R;
import com.codice.notifier.app.utils.GcmRegistrationEvent;
import com.codice.notifier.app.utils.PreferencesUtils;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import java.io.IOException;

import de.greenrobot.event.EventBus;

/**
 * This service handles Google Cloud Messaging Token obtanining and refreshing.
 *
 * @author Sergio Luis Para
 */
public class RegistrationIntentService extends IntentService {

    private static final String TAG = RegistrationIntentService.class.toString();

    public RegistrationIntentService() {
        super("RegistrationIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);

        try {
            String id = gcm.register(getString(R.string.gcm_default_sender_id));
            PreferencesUtils.saveGcmId(this, id);
            PreferencesUtils.setHasGcmId(this, true);
            EventBus.getDefault().post(new GcmRegistrationEvent(id));
        } catch (IOException e) {
            Log.e(TAG, "Something went wrong retrieving the token: " + e.getLocalizedMessage());
            PreferencesUtils.setHasGcmId(this, false);
            e.printStackTrace();
        }
    }
}
