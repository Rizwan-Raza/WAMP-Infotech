package com.wampinfotech.wampinfotech;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.text.InputType;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.wampinfotech.wampinfotech.modals.Client;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, RewardedVideoAdListener {

    private RewardedVideoAd mRewardedVideoAd;

    private int currentFragmentId = R.id.nav_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = this.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        displaySelectedScreen(R.id.nav_home);

        // Initialize the Google Mobile Ads SDK
        MobileAds.initialize(getApplicationContext(),
                getString(R.string.admob_app_id));

        // Get reference to singleton RewardedVideoAd object
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);

        // Use an activity context to get the rewarded video instance.
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    } */

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (currentFragmentId == id && id != R.id.nav_login) {
            return false;
        }

        displaySelectedScreen(id);

        if (mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.show();
        }

        currentFragmentId = id;

        return true;
    }

    public void brandClickRedirection(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(getString(R.string.nav_header_subtitle))));
    }


    public void quickQueryRedirection(View view) {
        startActivity(new Intent(MainActivity.this, QueryActivity.class));
    }

    private void displaySelectedScreen(int id) {
        Fragment fragment = null;

        switch (id) {
            case R.id.nav_home:
                fragment = new HomeFragment();
                break;
            case R.id.nav_about:
                fragment = new AboutFragment();
                break;
            case R.id.nav_services:
                fragment = new ServiceFragment();
                break;
            case R.id.nav_our_work:
                fragment = new OurWorkFragment();
                break;
            case R.id.nav_login:
                tokenDialog();
//                startActivity(new Intent(this, LoginActivity.class));
//                fragment = new ServiceFragment();
                break;
            case R.id.nav_contact:
//                fragment = new ServiceFragment();
                quickQueryRedirection(getCurrentFocus());
                break;
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, fragment);
            ft.commit();
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }


//    public void viewRedirection(View view) {
//        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(view.getTag().toString())));
//    }

//    public void serviceActivity(View view) {
//        Class toBeLaunch = getClass();
//        switch (view.getTag().toString()) {
//            case "Web Design":
//                toBeLaunch = WebDesign.class;
//                break;
//            case "Web Development":
//                toBeLaunch = WebDevelopment.class;
//
//        }
//        startActivity(new Intent(this, toBeLaunch));
//    }

    private void loadRewardedVideoAd() {
        // Load a reward based video ad
        mRewardedVideoAd.loadAd(getString(R.string.ad_unit_id), new AdRequest.Builder().build());
    }

    @Override
    public void onRewarded(RewardItem reward) {
//        Toast.makeText(this, "onRewarded! currency: " + reward.getType() + "  amount: " +
//                reward.getAmount(), Toast.LENGTH_SHORT).show();
        // Reward the user.
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
//        Toast.makeText(this, "onRewardedVideoAdLeftApplication",
//                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdClosed() {
//        Toast.makeText(this, "onRewardedVideoAdClosed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int errorCode) {
//        Toast.makeText(this, "onRewardedVideoAdFailedToLoad", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdLoaded() {
//        Toast.makeText(this, "onRewardedVideoAdLoaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdOpened() {
//        Toast.makeText(this, "onRewardedVideoAdOpened", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoStarted() {
//        Toast.makeText(this, "onRewardedVideoStarted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoCompleted() {
//        Toast.makeText(this, "onRewardedVideoCompleted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        mRewardedVideoAd.resume(this);
        super.onResume();
    }

    @Override
    public void onPause() {
        mRewardedVideoAd.pause(this);
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mRewardedVideoAd.destroy(this);
        super.onDestroy();
    }

    void tokenDialog() {
        // Creating alert Dialog with one Button
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this, R.style.Theme_MaterialComponents_Dialog_MinWidth);

        //AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();

        // Setting Dialog Title
        alertDialog.setTitle("Token");

        // Setting Dialog Message
//        alertDialog.setMessage("Enter Client Token");
        final EditText input = new EditText(MainActivity.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        input.setHint("Enter Client Token");
        input.setHintTextColor(Color.GRAY);
        input.setLayoutParams(lp);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        input.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        input.setGravity(Gravity.CENTER);
        input.setFilters(new InputFilter[]{new InputFilter.LengthFilter(8)});
        final RelativeLayout view = new RelativeLayout(MainActivity.this);
        view.setLayoutParams(lp);
        view.setPadding(32, 16, 32, 0);
        view.addView(input);
        alertDialog.setView(view); // uncomment this line
        //alertDialog.setView(input);

        // Setting Icon to Dialog
        alertDialog.setIcon(R.drawable.ic_lock_black_24dp);

        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        final RelativeLayout rl = findViewById(R.id.progress_view);
                        rl.setVisibility(View.VISIBLE);
                        // Write a message to the database
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference myRef = database.getReference("clients");

                        Query query = myRef.orderByChild("clientToken").equalTo(input.getText().toString().trim());

                        query.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                long resultCount = dataSnapshot.getChildrenCount();
                                if (resultCount == 1) {
                                    Client currentClient = null;
                                    for (DataSnapshot clientData :
                                            dataSnapshot.getChildren()) {
                                        currentClient = clientData.getValue(Client.class);
                                        Toast.makeText(MainActivity.this, "Welcome " + currentClient.getClientName() + "!", Toast.LENGTH_SHORT).show();
                                    }

                                    Intent myIntent = new Intent(MainActivity.this, LoginActivity.class);
                                    myIntent.putExtra("client", currentClient);
                                    startActivity(myIntent);
                                } else if (resultCount == 0) {
                                    Snackbar.make(findViewById(R.id.content_main), "Invalid Token", Snackbar.LENGTH_INDEFINITE).setAction("Try Again", new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Toast.makeText(MainActivity.this, "Sorry! Are you sure you entered proper Client Token", Toast.LENGTH_SHORT).show();
                                        }
                                    }).show();
//                                    Toast.makeText(MainActivity.this, "Sorry! Are you sure you entered proper Client Token", Toast.LENGTH_SHORT).show();
                                } else {
//                                    Toast.makeText(MainActivity.this, "Something went wrong! Contact App Administrator.", Toast.LENGTH_SHORT).show();
                                }
                                rl.setVisibility(View.GONE);
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });

//                        String key = myRef.push().getKey();
//                        Client client = new Client("20180001", "Hoga koi", "Redolance", "https://redolanceindia.in", "https://redolanceindia.in/bna_denge_api");
//                        myRef.child("redolance").setValue(client);
                        // Write your code here to execute after dialog
//                        Toast.makeText(getApplicationContext(), "Password Matched", Toast.LENGTH_SHORT).show();
                    }
                });
        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("NO",
                new DialogInterface.OnClickListener()

                {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
                        dialog.cancel();
                    }
                });

        // closed

        // Showing Alert Message
        alertDialog.show();
    }
}
