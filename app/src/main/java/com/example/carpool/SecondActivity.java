package com.example.carpool;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Switch;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

public class SecondActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
   private Toolbar toolbar;
   private DrawerLayout drawerLayout;
Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.navigation);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        toolbar =  findViewById(R.id.toolBar);

        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.menu1icon);
        actionBar.setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        final NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        if (navigationView != null){
            setupDrawerContent(navigationView);
        }

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View.OnClickListener myOnClickListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent second = new Intent(SecondActivity.this, Coordinator_Layout.class);
                        startActivity(second);
                    }
                };
                Snackbar.make(view, "Show Details", Snackbar.LENGTH_LONG)
                        .setAction("next", myOnClickListener)
                        .setActionTextColor(getResources().getColor(R.color.white))
                        .show();
            }
        });


        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.white));
        tabLayout.setupWithViewPager(viewPager);
        int[] imgResId = {
                R.drawable.menuicon,
                R.drawable.caricon
        };

        for (int i = 0; i < imgResId.length; i++) {

            tabLayout.getTabAt(i).setIcon(imgResId[i]);
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
                switch (tab.getPosition()){
                    case 0:
                        toolbar.setTitle("Feed");
                        break;
                    case 1:
                        toolbar.setTitle("My Trip");
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    public boolean onPrepareOptionsMenu(Menu menu){
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Intent intent = new Intent(SecondActivity.this, Coordinator_Layout.class);
                int id = menuItem.getItemId();
                switch (id){
                    case R.id.nav_home:
                    startActivity(intent);
                    break;

                    case R.id.nav_message:
                        startActivity(intent);
                        break;
                    case R.id.nav_friends:
                        startActivity(intent);
                        break;
                    case R.id.nav_discussion:
                        startActivity(intent);
                        break;
                    case R.id.nav_sub_item1:
                        startActivity(intent);
                        break;
                    case R.id.nav_sub_item2:
                        startActivity(intent);
                        break;
                }
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                return false;
            }
        });
    }

    public class ViewPagerAdapter extends FragmentPagerAdapter {
        private Fragment[] childFragments;

        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
            childFragments = new Fragment[]{
                    new ChildFragment1(),
                    new ChildFragment2(),
            };
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return childFragments[position];
        }

        @Override
        public int getCount() {
            return childFragments.length;
        }
    }
}





































