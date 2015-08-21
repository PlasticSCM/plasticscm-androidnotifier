package com.codice.notifier.app.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.codice.notifier.R;
import com.codice.notifier.app.activities.MainActivity;

/**
 * Utils class.
 *
 * @author Sergio Luis Para
 */
public class Utils {

    private static final long[] VIBRATE_PATTERN = {900};

    public static boolean isNullOrEmpty(String str) {
        return (str == null || str.length() == 0);
    }

    public static void triggerNotification(Context context, String title, String message) {
        Uri notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Intent onNotificationClick = new Intent(context, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(context, 0, onNotificationClick, 0);

        Intent detailAction = new Intent();
        detailAction.setAction("DETAIL");

        Notification notification = new NotificationCompat.Builder(context)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_stat_plastic)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVibrate(VIBRATE_PATTERN)
                .setSound(notificationSound)
                .setContentIntent(pIntent)
                .build();

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        manager.notify(5, notification);
    }
}
