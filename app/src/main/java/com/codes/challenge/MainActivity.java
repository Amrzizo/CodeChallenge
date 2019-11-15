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
        Intent myService = new Intent(this, LogCatPrintService.class);
        startService(myService);
        finish();



    }

    @SuppressLint("PrivateApi")
    @Override
    protected void onResume() {
        super.onResume();


    }

}
