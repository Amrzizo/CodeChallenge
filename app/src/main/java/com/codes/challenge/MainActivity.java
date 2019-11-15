package com.codes.challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import com.codes.challenge.services.LogCatPrintService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent myService = new Intent(this, LogCatPrintService.class);
        startService(myService);



    }

    @SuppressLint("PrivateApi")
    @Override
    protected void onResume() {
        super.onResume();


        try {

            Class localClass = Class.forName("android.os.ServiceManager");
            Method getService = localClass.getMethod("getService", new Class[]{String.class});
            if (getService != null) {
                Object result = getService.invoke(localClass, "batterystats");
                if (result != null) {
                    IBinder binder = (IBinder) result;
                }
            }
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
