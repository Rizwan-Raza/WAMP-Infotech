package com.wampinfotech.wampinfotech;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.wampinfotech.wampinfotech.utils.SendMail;

public class QueryActivity extends AppCompatActivity {

    private boolean isDirty = false;
    private final View.OnTouchListener _TouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            isDirty = true;
            return false;
        }
    };
    private EditText _name;
    private EditText _email;
    private EditText _mobile;
    private EditText _company;
    private EditText _msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        _msg = findViewById(R.id.desc);
        _name = findViewById(R.id.name);
        _email = findViewById(R.id.email);
        _mobile = findViewById(R.id.mobile);
        _company = findViewById(R.id.company);

        _msg.setOnTouchListener(_TouchListener);
        _name.setOnTouchListener(_TouchListener);
        _email.setOnTouchListener(_TouchListener);
        _mobile.setOnTouchListener(_TouchListener);
        _company.setOnTouchListener(_TouchListener);

    }

    public void sendMail() {

        if (isNetworkAvailable()) {
            //Getting content for email
            String email = _email.getText().toString().trim();
            String subject = _company.getText().toString().trim();
            if (email.length() == 0 || subject.length() == 0 || _name.getText().toString().trim().length() == 0 || _mobile.getText().toString().trim().length() == 0 || _email.getText().toString().trim().length() == 0) {
                Snackbar.make(findViewById(R.id.quick_query_layout),
                        "Please fill all the fields.", Snackbar.LENGTH_SHORT).show();
                return;
            }
            String message = "Name: " + _name.getText() + "\r\nMobile: " + _mobile.getText() + "\r\nEmail: " + email + "\r\nMessage:\r\n" + _msg.getText().toString().trim();

            //Creating SendMail object and executing it.
            new SendMail(this, getString(R.string.brand_email), subject, message).execute();
//            new SendMail(this, "rizwan.raza12349876@gmail.com", subject, message).execute();
        } else {
            Snackbar.make(findViewById(R.id.quick_query_layout),
                    "No Internet Connection", Snackbar.LENGTH_SHORT).show();
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.query_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.query_send_btn:
                sendMail();
                break;
            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:
                // Otherwise if there are unsaved changes, setup a dialog to warn the user.
                // Create a click listener to handle the user confirming that
                // changes should be discarded.
                if (!isDirty) {
                    NavUtils.navigateUpFromSameTask(QueryActivity.this);
                    break;
                }
                DialogInterface.OnClickListener discardButtonClickListener =
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // User clicked "Discard" button, navigate to parent activity.
                                NavUtils.navigateUpFromSameTask(QueryActivity.this);
                            }
                        };

                // Show a dialog that notifies the user they have unsaved changes
                showUnsavedChangesDialog(discardButtonClickListener);
                break;
            default:
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (!isDirty) {
            super.onBackPressed();
            return;
        }


        // Otherwise if there are unsaved changes, setup a dialog to warn the user.
        // Create a click listener to handle the user confirming that changes should be discarded.
        DialogInterface.OnClickListener discardButtonClickListener =
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // User clicked "Discard" button, close the current activity.
                        finish();
                    }
                };

        // Show dialog that there are unsaved changes
        showUnsavedChangesDialog(discardButtonClickListener);
    }

    /**
     * Show a dialog that warns the user there are unsaved changes that will be lost
     * if they continue leaving the editor.
     *
     * @param discardButtonClickListener is the click listener for what to do when
     *                                   the user confirms they want to discard their changes
     */
    private void showUnsavedChangesDialog(
            DialogInterface.OnClickListener discardButtonClickListener) {

        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the positive and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.unsaved_changes_dialog_msg);
        builder.setPositiveButton(R.string.discard, discardButtonClickListener);
        builder.setNegativeButton(R.string.stay_here, new DialogInterface.OnClickListener() {
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
    }

}
