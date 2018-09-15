package com.wampinfotech.wampinfotech;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class QuickQuery extends Activity {

    Button _btn;
    EditText _name, _email, _mobile, _company, _msg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.quick_query);

        _btn = (Button) findViewById(R.id.send_btn);
        _name = (EditText) findViewById(R.id.name);
        _email = (EditText) findViewById(R.id.email);
        _mobile = (EditText) findViewById(R.id.mobile);
        _company = (EditText) findViewById(R.id.company);
        _msg = (EditText) findViewById(R.id.desc);

    }

    public void sendMail(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        String[] TO = {getString(R.string.brand_email)};
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, _company.getText());
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Name: " + _name.getText() + "\r\nMobile: " + _mobile.getText() + "\r\nEmail: " + _email.getText() + "\r\nMessage:\r\n" + _msg.getText());

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Toast.makeText(this, "Please Select email Client", Toast.LENGTH_SHORT).show();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

}
