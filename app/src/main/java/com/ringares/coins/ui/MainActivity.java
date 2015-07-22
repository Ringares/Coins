package com.ringares.coins.ui;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.ringares.coins.Application.MyApplication;
import com.ringares.coins.R;
import com.ringares.coins.event.AddPieceEvent;
import com.ringares.coins.utils.CircleImageDrawable;
import com.ringares.coins.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    /**
     * 接收AddPieceEvent的事件消息
     * @param event
     */
    public void onEventMainThread(AddPieceEvent event) {
        String msg = "onEventMainThread收到了消息：" + event.getMsg();
        Utils.log(this,msg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //statusBarCloor
        //setStatusBarColor();

        EventBus.getDefault().register(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        if(ab!=null){
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headView = navigationView.inflateHeaderView(R.layout.nav_header);
        ImageView headImage = (ImageView) headView.findViewById(R.id.iv);
        headImage.setImageDrawable(new CircleImageDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.ic_user)));

        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(MenuItem menuItem) {
                            menuItem.setChecked(true);
                            mDrawerLayout.closeDrawers();
                            return true;
                        }
                    });
        }

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager != null) {
            Adapter adapter = new Adapter(getSupportFragmentManager());
            adapter.addFragment(new TimeLineFragment(), "Time-Line");
            adapter.addFragment(new TimeLineFragment(), "Charts");
            viewPager.setAdapter(adapter);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                startActivity(new Intent(MyApplication.context, AddPieceActivity.class));
            }
        });

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        if (viewPager != null){
            tabLayout.setupWithViewPager(viewPager);
        }
    }

    private void setStatusBarColor() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            /**透明导航栏*/
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){/**5.0及以上*/
                Window window = getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                        | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
            }else{/**5.0以下*/
                Window win = getWindow();
                WindowManager.LayoutParams winParams = win.getAttributes();
                int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
                winParams.flags |= bits;
                win.setAttributes(winParams);
            }
        }
    }


    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_settings:
                Utils.showToast("setting");
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
