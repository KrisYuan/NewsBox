package com.awesomekris.android.newsbox;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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

    public static String getJsonStringFromUrl(URL url) {

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        String responseJsonStr = null;

        try {

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                // Nothing to do.
                return null;
            }

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {

                buffer.append(line + "\n");

            }

            if (buffer.length() == 0) {
                // Stream was empty.  No point in parsing.
                return null;
            }

            responseJsonStr = buffer.toString();

        } catch (IOException e) {

            Log.e(LOG_TAG, "Error ", e);

        } finally {

            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e(LOG_TAG, "Error closing stream", e);
                }
            }
        }

        return responseJsonStr;

    }


}
