package com.codice.notifier.app.utils;

/**
 * A fast way to notify the Activity that the GCM registration ID has changed.
 *
 * @author Sergio Luis Para
 */
public class GcmRegistrationEvent {

    public final String GCMID;

    public GcmRegistrationEvent(String gcmId) {
        GCMID = gcmId;
    }
}
