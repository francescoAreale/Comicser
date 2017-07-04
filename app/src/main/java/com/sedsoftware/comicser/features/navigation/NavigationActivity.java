package com.sedsoftware.comicser.features.navigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.sedsoftware.comicser.R;

public class NavigationActivity extends
    MvpActivity<NavigationActivityView, NavigationActivityPresenter>
    implements NavigationActivityView, OnNavigationItemSelectedListener {

  @BindView(R.id.toolbar)
  Toolbar toolbar;
  @BindView(R.id.nav_view)
  NavigationView navigationView;
  @BindView(R.id.drawer_layout)
  DrawerLayout drawer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_navigation_view);
    ButterKnife.bind(this);

    setSupportActionBar(toolbar);
    setUpNavigationDrawerParams();
  }

  @Override
  public void onBackPressed() {
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  private void setUpNavigationDrawerParams() {
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    navigationView.setNavigationItemSelectedListener(this);
  }

  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    int id = item.getItemId();
    handleChosenNavigationMenuItem(id);

    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  @NonNull
  @Override
  public NavigationActivityPresenter createPresenter() {
    return new NavigationActivityPresenter();
  }

  @SuppressWarnings("StatementWithEmptyBody")
  @Override
  public void handleChosenNavigationMenuItem(int chosenMenuItem) {

    if (chosenMenuItem == R.id.nav_issues) {
      showTodayIssuesFragment();
    } else if (chosenMenuItem == R.id.nav_volumes) {
      showVolumesFragment();
    } else if (chosenMenuItem == R.id.nav_characters) {
      showCharactersFragment();
    } else if (chosenMenuItem == R.id.nav_collection) {
      showCollectionManagerFragment();
    } else if (chosenMenuItem == R.id.nav_tracker) {
      showReleaseTrackerFragment();
    } else if (chosenMenuItem == R.id.nav_settings) {
      showSettingsScreen();
    }
  }

  @Override
  public void showTodayIssuesFragment() {
    Toast.makeText(this, "Issues", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void showVolumesFragment() {
    Toast.makeText(this, "Volumes", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void showCharactersFragment() {
    Toast.makeText(this, "Characters", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void showCollectionManagerFragment() {
    Toast.makeText(this, "Collection", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void showReleaseTrackerFragment() {
    Toast.makeText(this, "Tracker", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void showSettingsScreen() {
    Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
  }
}