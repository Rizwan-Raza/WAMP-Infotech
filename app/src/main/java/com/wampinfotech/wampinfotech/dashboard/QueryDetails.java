package com.wampinfotech.wampinfotech.dashboard;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.wampinfotech.wampinfotech.R;
import com.wampinfotech.wampinfotech.modals.Query;
import com.wampinfotech.wampinfotech.utils.Utility;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.net.ssl.HttpsURLConnection;

public class QueryDetails extends AppCompatActivity {

    private static final String LOG_TAG = VisitorsFragment.class.getSimpleName();
    Query query = null;
    //    private int currentPos = -1;
    private String REQUEST_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_details);

        query = (Query) getIntent().getSerializableExtra("query");
        REQUEST_URL = getIntent().getStringExtra("queryURL");

        //Show an X in place of <-
        final Drawable cross = getResources().getDrawable(R.drawable.ic_close_white_24dp);
//        if (cross != null) {
//            cross.setColorFilter(getResources().getColor(R.color.icons), PorterDuff.Mode.SRC_ATOP);
//        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setElevation(0f);
            actionBar.setTitle(R.string.title_activity_query_detail);
//            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(cross);
        }


        if (query != null) {
            TextView etName = findViewById(R.id.et_q_name);
            etName.setText(query.getName());

            TextView etEmail = findViewById(R.id.et_q_email);
            etEmail.setText(query.getEmail());

            TextView etNumber = findViewById(R.id.et_q_number);
            etNumber.setText(query.getNumber());

            TextView etMsg = findViewById(R.id.et_q_msg);
            etMsg.setText(query.getMsg());

            TextView etTime = findViewById(R.id.et_q_time);
            SimpleDateFormat df = new SimpleDateFormat("EEEE, MMM dd, yyyy 'at' hh:mm aaa", Locale.ENGLISH);
            String time = df.format(query.getTime());
            etTime.setText(time);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.query_detail_delete, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (NavUtils.getParentActivityName(QueryDetails.this) != null) {
                    NavUtils.navigateUpFromSameTask(QueryDetails.this);
                }
                finish();
                return true;

            case R.id.query_delete:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you surely want to delete this query?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        int qId = query.getQid();
                        QueryDetails.QueryDelete visitorDelete = new QueryDetails.QueryDelete();
                        visitorDelete.execute(qId);

                        if (NavUtils.getParentActivityName(QueryDetails.this) != null) {
                            NavUtils.navigateUpFromSameTask(QueryDetails.this);
                        }
                        if (dialog != null) {
                            dialog.dismiss();
                        }
                        finish();
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked the "Keep editing" button, so dismiss the dialog
                        // and continue editing the pet.
                        if (dialog != null) {
                            dialog.dismiss();
                        }
                    }
                });
                // Create and show the AlertDialog
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private String makeHttpRequest(int qid) throws IOException {
        String jsonResponse = null;

        // If the URL is null, then return early.
        String salt = "*WAMP*";
        String anotherOne = (new SimpleDateFormat("yy", Locale.ENGLISH)).format(Calendar.getInstance().getTime());
        String token = Utility.md5(salt + anotherOne + salt);

        String query = "qid=" + qid + "&token=" + token;

        URL url = new URL(REQUEST_URL + "?" + query);
//        if (url == null) {
//            return jsonResponse;
//        }
        HttpsURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpsURLConnection) url.openConnection();
//            urlConnection.setReadTimeout(10000 /* milliseconds */);
//            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("DELETE");
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);

            OutputStream os = urlConnection.getOutputStream();

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(query);
            writer.flush();
            writer.close();
            os.close();

            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = Utility.readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Got a Problem, " + e.getMessage(), e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        Log.e(LOG_TAG, "returning result " + jsonResponse);
        return jsonResponse;
    }

    class QueryDelete extends AsyncTask <Integer, Void, String> {

        @Override
        protected void onPostExecute(String s) {
            JSONObject json = null;
            try {
                if (s == null) {
                    Log.e(LOG_TAG, "onPostExecute null");
                    return;
//                    Snackbar.make(QueriesFragment., "Something went wrong", Snackbar.LENGTH_LONG).show();
                }
                json = new JSONObject(s);
                if (json.getBoolean("status")) {
                    Log.e(LOG_TAG, "onPostExecute status true");
//                    mAdapter.remove(mAdapter.getItem(currentPos));
//                    Snackbar.make(mView, "Visitor deleted successfully", Snackbar.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(Integer... integers) {
            try {
                return makeHttpRequest(integers[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
