package com.codice.notifier.app.activities;

import android.app.Activity;
import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.codice.notifier.R;
import com.codice.notifier.app.utils.GcmRegistrationEvent;
import com.codice.notifier.app.utils.PreferencesUtils;
import com.codice.notifier.services.RegistrationIntentService;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;


/**
 * Application's main Activity. In a more complex app the registration against GCM should be
 * handled in a class that extends {@link android.app.Application}, overriding {@link Application#onCreate()}.
 *
 * @author Sergio Luis Para
 */
public class MainActivity extends Activity {

    @Bind(R.id.gcm_id_textview) TextView mGcmIdTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        EventBus.getDefault().register(this);

        boolean hasGCMId = PreferencesUtils.hasGcmId(this);

        if (!hasGCMId) {
            setGcmIdText(getString(R.string.retrieving_gcm_id));
            Intent intent = new Intent(this, RegistrationIntentService.class);
            startService(intent);
        } else {
           setGcmIdText(PreferencesUtils.getGcmId(this));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @OnClick({ R.id.copy_gcm_id, R.id.gcm_id_cardview, R.id.gcm_id_textview })
    public void copyGcmId() {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("GoogleCloudMessaging ID", mGcmIdTextView.getText());
        clipboard.setPrimaryClip(clip);
        Toast.makeText(this, getString(R.string.copied_to_clipboard), Toast.LENGTH_LONG).show();
    }

    public void onEvent(final GcmRegistrationEvent event) {
        // This method will be called from the IntentService, and in Android only the thread that
        // created a View can modify it.
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setGcmIdText(event.GCMID);
            }
        });
    }

    private void setGcmIdText(String text) {
        mGcmIdTextView.setText(text);
    }
}
