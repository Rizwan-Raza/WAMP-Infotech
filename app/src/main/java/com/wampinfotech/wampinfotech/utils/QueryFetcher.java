package com.wampinfotech.wampinfotech.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.wampinfotech.wampinfotech.modals.Query;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class QueryFetcher {

    /**
     * Tag for the log messages
     */
    private static final String LOG_TAG = QueryFetcher.class.getSimpleName();


    public QueryFetcher() {
    }

    public static List <Query> extractQueries(Context context, URL url) {
//        Log.e(LOG_TAG, "Extracting Characters - extractCharacters()");

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = Utility.makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error closing input stream", e);
        }

        // Extract relevant fields from the JSON response and create an {@link Event} object
        return extractQueriesFromJson(jsonResponse);
    }

    /**
     * Return an {@link List} object by parsing out information
     * about the first earthquake from the input earthquakeJSON string.
     */
    private static List <Query> extractQueriesFromJson(String charsJSON) {

        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(charsJSON)) {
            return null;
        }

        // Create an empty ArrayList that we can start adding earthquakes to
        List <Query> queries = new ArrayList <>();

        // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {

            // Parse the response given by the charsJSON string and
            // build up a list of Earthquake objects with the corresponding data.

            JSONArray charactersArray = new JSONArray(charsJSON);

            for (int i = 0; i < charactersArray.length(); i++) {
                JSONObject query = charactersArray.getJSONObject(i);
                String name = query.getString("name");
                String number = query.getString("number");
                String email = query.getString("email");
                String msg = query.getString("msg");

                Date time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse(query.getString("time"));
                int qid = query.getInt("_qid");
                Query newOne = new Query(qid, name, number, email, msg, time);
                queries.add(newOne);
            }
//            for (int i = 0; i < charactersArray.length(); i++) {
//                JSONObject character = charactersArray.getJSONObject(i);
//                String name = character.getString("name");
//                int id = character.getInt("id");
//                String desc = character.getString("desc");
//                SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH);
//                Date update = spf.parse(character.getString("update"));
//                URL image = new URL(character.getString("image"));
//                Characters newOne = new Characters(name, id, desc, update, image);
//                characters.add(newOne);
//            }

        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e(LOG_TAG, "Problem parsing the characters JSON results", e);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//            Log.e("CharacterUtils", "Problem parsing Image URL", e);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            Log.e("CharacterUtils", "Problem parsing Date", e);
        } catch (ParseException e) {
            Log.e(LOG_TAG, "Problem parsing the date string", e);
        }

        // Return the list of earthquakes
        return queries;
    }
}
