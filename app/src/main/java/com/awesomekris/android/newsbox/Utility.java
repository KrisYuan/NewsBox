package com.awesomekris.android.newsbox;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kris on 16/10/3.
 */
public class Utility {

    private static String LOG_TAG = Utility.class.getSimpleName();

    public static String getCurrentDate(long dateInMillis) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date(dateInMillis);
        String currentDate = dateFormat.format(date);

        return currentDate;
    }

    static public boolean isNetworkAvailable(Context c) {
        ConnectivityManager cm = (ConnectivityManager)c.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
            }


}
