package com.wampinfotech.wampinfotech;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class QueryActivity extends AppCompatActivity {


    EditText _name, _email, _mobile, _company, _msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        _msg = findViewById(R.id.desc);
        _name = findViewById(R.id.name);
        _email = findViewById(R.id.email);
        _mobile = findViewById(R.id.mobile);
        _company = findViewById(R.id.company);


    }

    public void sendMail(View view) {

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


}
