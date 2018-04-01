package org.pccegoa.mithya2k18;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;
import com.onesignal.OneSignal;

/**
 * Created by Siddharth on 4/1/2018.
 */

public class ApplicationClass extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
    }
}
