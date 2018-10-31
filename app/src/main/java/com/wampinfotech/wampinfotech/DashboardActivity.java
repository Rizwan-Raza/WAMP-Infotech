package com.wampinfotech.wampinfotech;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
//
//        Bundle bundle = getIntent().getExtras();
//        String url = bundle.getString("url");
//        String username = bundle.getString("username");
//        String password = bundle.getString("password");
//
//        WebView webview = new WebView(this);
//        setContentView(webview);
//        setTitle("Admin Dashboard");
//        try {
//            String postData = "username=" + URLEncoder.encode(username, "UTF-8") + "&password=" + URLEncoder.encode(password, "UTF-8");
//            webview.postUrl(url, postData.getBytes());
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//            webview.loadUrl(url);
//        }
////        webview.loadUrl(url);
    }
}
