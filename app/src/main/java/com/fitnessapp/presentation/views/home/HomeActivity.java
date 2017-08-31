package com.fitnessapp.presentation.views.home;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import com.fitnessapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, HomeContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.nav_view)
    NavigationView navView;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.tv_steps_count)
    TextView tvStepsCount;

    private static final int REQUEST_OAUTH = 1;

    HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        initDrawer();
        homePresenter = new HomePresenter();
        homePresenter.attachView(this);
        homePresenter.setupGoogleClient();
        homePresenter.connectToGoogle();
    }

    @Override
    public void initDrawer() {

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void showStepsCount(String stepsCount) {
        tvStepsCount.setText(stepsCount);
    }

    @Override
    protected void onStart() {
        super.onStart();
        homePresenter.connectToGoogle();
    }

    @Override
    protected void onResume() {
        super.onResume();
        homePresenter.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        homePresenter.destroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        homePresenter.destroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_OAUTH) {
            if (resultCode == RESULT_OK) {
                if (!homePresenter.getmApiClient().isConnecting() && !homePresenter.getmApiClient().isConnected()) {
                    homePresenter.connectToGoogle();
                }
            } else if (resultCode == RESULT_CANCELED) {
                Log.e("GoogleFit", "RESULT_CANCELED");
            }
        } else {
            Log.e("GoogleFit", "requestCode NOT request_oauth");
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}