package com.doordash.doordashlite.mvp;

import android.os.Handler;
import android.os.HandlerThread;

public class BackgroundThreadQueue extends ThreadQueue {

    public BackgroundThreadQueue() {
        super(new AndroidHandlerRunner(createHandler()));
    }

    private static Handler createHandler() {
        HandlerThread handlerThread = new HandlerThread("");
        handlerThread.start();
        return new Handler(handlerThread.getLooper());
    }

}
