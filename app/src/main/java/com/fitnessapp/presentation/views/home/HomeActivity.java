package com.fitnessapp.presentation.views.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.fitnessapp.R;
import com.fitnessapp.app.App;
import com.fitnessapp.presentation.views.discounts.DiscountsActivity;
import com.fitnessapp.utils.ResourcesUtil;
import com.fitnessapp.utils.SpannableUtils;
import com.fitnessapp.utils.StringUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import flepsik.github.com.progress_ring.ProgressRingView;

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

    @BindView(R.id.count_progress)
    ProgressRingView count_progress;

    @BindView(R.id.km_progress)
    ProgressRingView km_progress;

    @BindView(R.id.tv_km_count)
    TextView tv_km_count;

    @BindView(R.id.tv_cal_count)
    TextView tv_cal_count;

    @BindView(R.id.tv_steps_remaining)
    TextView tv_steps_remaining;

    @BindView(R.id.tv_km_remaining)
    TextView tv_km_remaining;

    @BindView(R.id.tv_cal_remaining)
    TextView tv_cal_remaining;

    @BindView(R.id.cal_progress)
    ProgressRingView cal_progress;

    private static final int REQUEST_OAUTH = 1;

    @Inject
    HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((App) getApplicationContext()).getApplicationComponent().inject(this);
        setSupportActionBar(toolbar);
        initDrawer();
        homePresenter.attachView(this);
        homePresenter.setupGoogleClient();
        homePresenter.connectToGoogle();

        showDiscounts();
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
        tvStepsCount.setText(SpannableUtils.formatValueWithLabel(stepsCount, " Steps"));
    }


    @Override
    public void showKMCount(float kms) {
        tv_km_count.setText(String.format(ResourcesUtil.getString(R.string.km_count), StringUtils.df.format(kms)));
    }

    @Override
    public void applyProgress(float percentage) {
        count_progress.setProgress(percentage);
    }


    @Override
    public void showStepsRemaining(int stepsRemaining) {
        tv_steps_remaining.setText(String.format(ResourcesUtil.getString(R.string.steps_to_go), stepsRemaining));
    }

    @Override
    public void applyKMProgress(float percentage) {
        km_progress.setProgress(percentage);
    }

    @Override
    public void showKMRemaining(float kmRemaining) {
        tv_km_remaining.setText(String.format(ResourcesUtil.getString(R.string.km_to_go), StringUtils.df.format(kmRemaining)));
    }


    @Override
    public void showCaloriesRemaining(int calories) {
        tv_cal_remaining.setText(String.format(ResourcesUtil.getString(R.string.cal_to_go),
                StringUtils.df.format(calories)));
    }

    @Override
    public void applyCalories(float progress) {
        cal_progress.setProgress(progress);
    }

    @Override
    public void showCaloriesCount(int calories) {
        tv_cal_count.setText(SpannableUtils.formatValueWithLabel(calories + "", " Calories"));
    }

    @Override
    public void showDiscounts() {
        Intent intent = new Intent(HomeActivity.this, DiscountsActivity.class);
        startActivity(intent);
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
