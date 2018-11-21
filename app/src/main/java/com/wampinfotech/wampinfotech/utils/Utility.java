package com.wampinfotech.wampinfotech.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utility {

    /**
     * Tag for the log messages
     */
    private static final String LOG_TAG = Utility.class.getSimpleName();

    public static boolean isNetworkAvailable(AppCompatActivity app) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) app.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static String daysUntilToday(Date date) {
        long diff = new Date().getTime() - date.getTime();
        if (diff < 2.628e+9) {
            if (diff < 8.64e+7) {
                if (diff < 3.6e+6) {
                    if (diff < 60000) {
                        return TimeUnit.SECONDS.convert(diff, TimeUnit.MILLISECONDS) + " seconds ago";
                    } else {
                        return TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS) + " minute"
                                + ((diff > 120000) ? "s" : "") + " ago";
                    }
                } else {
                    return TimeUnit.HOURS.convert(diff, TimeUnit.MILLISECONDS) + " hour" + ((diff > 7.2e+6) ? "s" : "")
                            + " ago";
                }
            } else {
                return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + " day" + ((diff > 1.728e+8) ? "s" : "")
                        + " ago";
            }
        } else {
            return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) / 30 + " month" + ((diff > 5.256e+9) ? "s" : "")
                    + " ago";
        }
    }

    /**
     * Make an HTTP request to the given URL and return a String as the response.
     */
    public static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    /**
     * Convert the {@link InputStream} into a String which contains the
     * whole JSON response from the server.
     */
    public static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    public static String md5(String salt) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(salt.getBytes(), 0, salt.length());
            return new BigInteger(1, m.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
