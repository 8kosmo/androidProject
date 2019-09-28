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
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private ShareActionProvider shareActionProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //지원 프래그먼트를 사용하므로 어댑터를 지원 프래그먼트 관리자로 전달해요.
        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        ViewPager pager = findViewById(R.id.pager);
        //우리가 생성한 FragmentPagerAdapter를 ViewPager로 연결해요.
        pager.setAdapter(pagerAdapter);
        //Attach the ViewPager to the TabLayout
        //뷰페이저를 탭 레이아웃에 연결하기
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
    }
    private void setShareActionIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (androidx.appcompat.widget.ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        //공유액션으로 공유하려는 기본 텍스트예요.
        setShareActionIntent("Want to Join me for pizza?");
        return super.onCreateOptionsMenu(menu);
    }
    /*앱바에서 메뉴를 선택했을 때*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //Log.d(TAG,"onOptionsItemSelected:"+item);
        switch (item.getItemId()){
            case R.id.action_create_order:
                Intent intent = new Intent(this,OrderActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
           super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT); // PagerAdapter 초기화를 위한 문법적 조건
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
    }
}
