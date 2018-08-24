package com.example.objectboxdemo;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.example.objectboxdemo.model.MyObjectBox;

import io.objectbox.BoxStore;
import io.objectbox.android.AndroidObjectBrowser;


/**
 * Created by AsifMoinul on 12/25/2017.
 */

public class ObjectBoxDemoApp extends Application {

    private BoxStore boxStore;

    @Override
    public void onCreate() {
        super.onCreate();
        boxStore = MyObjectBox.builder().androidContext(this).build();

        if (BuildConfig.DEBUG){

            boolean started = new AndroidObjectBrowser(boxStore).start(this);
            Log.i("ObjectBrowser", "Started: " + started);
            Toast.makeText(getBaseContext(),"Object Browser Started",Toast.LENGTH_LONG).show();
        }
    }

    public BoxStore getBoxStore() {
        return boxStore;
    }
}
