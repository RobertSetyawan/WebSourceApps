package com.example.robert.websource;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Robert on 20/10/2017.
 */

public class CheckInternet {
    Context ctx;

    public CheckInternet(Context ct){
        this.ctx = ct;
    }

    public  boolean isConnected() {
        ConnectivityManager myconnection = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (myconnection != null) {
            NetworkInfo info = myconnection.getActiveNetworkInfo();
            if (info != null) {
                if (info.getState() == NetworkInfo.State.CONNECTED) ;{
                    return true;
                }
            }
        }
        return false;
    }
}
