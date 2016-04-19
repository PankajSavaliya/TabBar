package com.socialinfotech.tabbar;

import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.socialinfotech.tabbar.smart.SmartTabLayout;
import com.socialinfotech.tabbar.smart.utils.v4.FragmentPagerItem;
import com.socialinfotech.tabbar.smart.utils.v4.FragmentPagerItemAdapter;
import com.socialinfotech.tabbar.smart.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        final Resources res = MainActivity.this.getResources();
        SmartTabLayout viewpagertab=(SmartTabLayout)findViewById(R.id.viewpagertab);
        ViewPager viewpager=(ViewPager)findViewById(R.id.viewpager);
        viewpagertab.setCustomTabView(new SmartTabLayout.TabProvider() {
            @Override
            public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
                View view =  inflater.inflate(R.layout.custom_tab_icon1, container, false);
                ImageView icon=(ImageView)view.findViewById(R.id.img);
                TextView tab_txt=(TextView)view.findViewById(R.id.tab_txt);
                switch (position) {
                    case 0:
                        tab_txt.setText("one");
                        icon.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_android_black));
                        break;
                    case 1:
                        tab_txt.setText("two");
                        icon.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_android_black));
                        break;
                    case 2:
                        tab_txt.setText("three");
                        icon.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_android_black));
                        break;
                    case 3:
                        tab_txt.setText("four");
                        icon.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_android_black));
                        break;
                    default:
                        throw new IllegalStateException("Invalid position: " + position);
                }
                return view;
            }
        });

        FragmentPagerItems pages = new FragmentPagerItems(this);

        pages.add(FragmentPagerItem.of(getString(R.string.app_name), BlankFragment.class));
        pages.add(FragmentPagerItem.of(getString(R.string.app_name), BlankFragment.class));
        pages.add(FragmentPagerItem.of(getString(R.string.app_name), BlankFragment.class));
        pages.add(FragmentPagerItem.of(getString(R.string.app_name), BlankFragment.class));

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), pages);

        viewpager.setAdapter(adapter);
        viewpagertab.setViewPager(viewpager);
    }
}
