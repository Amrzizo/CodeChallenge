package com.codes.challenge.services;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

public class LogCatPrintService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        logAllServices();
        stopSelf();
        return super.onStartCommand(intent, flags, startId);


    }


    private void logAllServices() {

        Class localClass = null;
        try {
            localClass = Class.forName("android.os.ServiceManager");

            Method getService = localClass.getMethod("listServices", null);
            if (getService != null) {
                Object result = getService.invoke(localClass, null);
                if (result != null) {
                    String[] servicesList = (String[]) result;

                    Log.i("All Service Manager Services : ", "");
                    Stream<String> servicesStream = Arrays.stream(servicesList);
                    servicesStream.forEach(x -> Log.i("Service Name : ", x));

                }
            }
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("PrivateApi")
    private void logBatteryStatus() {

        try {

             Class localClass = Class.forName("android.os.ServiceManager");
            Method getService = localClass.getMethod("getService", new Class[]{String.class});
            if (getService != null) {
                Object result = getService.invoke(localClass, "battery");
                if (result != null) {
                    IBinder binder = (IBinder) result;
                    // DO WHAT EVER YOU WANT AT THIS POINT, YOU WILL
                    // NEED TO CAST THE BINDER TO THE PROPER TYPE OF THE SERVICE YOU USE.
                }
            }
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
