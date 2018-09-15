package com.wampinfotech.wampinfotech;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void brandClickRedirection(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.nav_header_subtitle)));
        startActivity(intent);
    }

    public void quickQueryRedirection(View view) {
        Intent intent = new Intent(this, QuickQuery.class);
        startActivity(intent);
    }
}
