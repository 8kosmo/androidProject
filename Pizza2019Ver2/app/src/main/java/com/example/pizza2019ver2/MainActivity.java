package com.example.pizza2019ver2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private ShareActionProvider shareActionProvider = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        ViewPager pager = findViewById(R.id.pager);
        //우리가 생성한 FragmentPagerAdapter를 ViewPager로 연결해요.
        pager.setAdapter(pagerAdapter);
        //Attach the ViewPager to the TabLayout
        //뷰페이저를 탭 레이아웃에 연결하기
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider =
                (androidx.appcompat.widget.ShareActionProvider)MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("피자App2019ver2 어서오이소");
        return super.onCreateOptionsMenu(menu);
    }
    //앱바에서 메뉴를 선택 했을 때
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_create_order:
                Intent intent = new Intent(this,OrderActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //공유 아이콘 클릭했을 때 처리되는 이벤트
    private void setShareActionIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }

    //내부 클래스 설계
    private class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new TopFragment();

                case 1:
                    return new PizzaFragment();
                case 2:
                    return new PastaFragment();
                case 3:
                    return new StoresFragment();


            }
            return null;
        }

        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getText(R.string.home);
                case 1:
                    return getResources().getText(R.string.pizza);
                case 2:
                    return getResources().getText(R.string.pasta);
                case 3:
                    return getResources().getText(R.string.store);
            }
            return null;
        }
    }// end of Class SectionsPagerAdapter
}
