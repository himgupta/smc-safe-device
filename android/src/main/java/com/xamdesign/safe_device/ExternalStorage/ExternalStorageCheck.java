package com.xamdesign.safe_device.ExternalStorage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

public class ExternalStorageCheck {
    /**
     * Checks if the application is installed on the SD card.
     *
     * @return <code>true</code> if the application is installed on the sd card
     */
    public static boolean isOnExternalStorage(Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            ApplicationInfo ai = pi.applicationInfo;
            return (ai.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) == ApplicationInfo.FLAG_EXTERNAL_STORAGE;
        } catch (PackageManager.NameNotFoundException e) {
            // ignore
        }
        return false;
    }

}
