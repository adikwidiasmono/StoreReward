package com.widiasmononttdata.adik.storereward;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import adapter.tabpager.SlidingFragmentPagerAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DrawerLayout drawerLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.r_activity_main);
        setContentView(R.layout.r_activity_main_2);

        setupNavigationView();
        setupToolbar();
        setupCollapsingToolbarLayout();
        setupTablayout();
        setupFab();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                if (drawerLayout != null)
                    drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_my_reward :
                Snackbar
                        .make(findViewById(R.id.coordinatorLayout), "My Reward pressed", Snackbar.LENGTH_SHORT)
                        .setAction("Action", this)
                        .show(); // Don’t forget to show!
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupNavigationView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        // Drawer items action here
        NavigationView view = (NavigationView) findViewById(R.id.navigation);
        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_menu_1 :
                        Log.e("Navigation view", "MENU 1");
                    case R.id.nav_menu_2 :
                        Log.e("Navigation view", "MENU 2");
                    case R.id.nav_menu_3 :
                        Log.e("Navigation view", "MENU 3");
                    case R.id.nav_menu_4 :
                        Log.e("Navigation view", "MENU 4");
                }
//                Snackbar
//                        .make(findViewById(R.id.coordinatorLayout), menuItem.getTitle() + " pressed", Snackbar.LENGTH_SHORT)
//                        .show();
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private void setupCollapsingToolbarLayout() {
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.setTitle(toolbar.getTitle());
            //collapsingToolbarLayout.setCollapsedTitleTextColor(0xED1C24);
            //collapsingToolbarLayout.setExpandedTitleColor(0xED1C24);
        }
    }

    private void setupTablayout() {
        // Get the ViewPager and set it's PagerAdapter so that it can display items
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager == null)
            return;
        viewPager.setAdapter(new SlidingFragmentPagerAdapter(getSupportFragmentManager(), getApplicationContext()));

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        if (tabLayout == null)
            return;

        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupFab() {
        fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null)
            fab.setOnClickListener(this);
    }

    private void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null)
            setSupportActionBar(toolbar);

        // Show menu icon
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.fab) {
            Snackbar
                    .make(findViewById(R.id.coordinatorLayout), "This is Snackbar", Snackbar.LENGTH_LONG)
                    .setAction("Action", this)
                    .show(); // Don’t forget to show!
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
