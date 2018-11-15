package com.wampinfotech.wampinfotech.dashboard;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.wampinfotech.wampinfotech.R;
import com.wampinfotech.wampinfotech.modals.Query;
import com.wampinfotech.wampinfotech.utils.Utility;

public class QueryDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_details);

        Query query = (Query) getIntent().getSerializableExtra("query");

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
            etTime.setText(Utility.daysUntilToday(query.getTime()));
        }
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

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
