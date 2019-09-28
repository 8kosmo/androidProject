package com.example.pizza2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

public class MainActivity extends AppCompatActivity {
    private ShareActionProvider shareActionProvider = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.memu_main,menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider)MenuItemCompat.getActionProvider(menuItem);
        //공유 액션으로 공유하려는 기본 텍스트
        setShareActionIntent("피자 먹으러 어서오이소");
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_create_order:
                //insert here - Orderactivity 호출하기
                Intent intent = new Intent(this,OrderActivity.class);
                startActivity(intent);
                default:
                    return super.onOptionsItemSelected(item);
        }
    }
    private void setShareActionIntent(String text){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,text);
        //공유액션 프로바이더에 기본 텍스트를 설정하기
        shareActionProvider.setShareIntent(intent);
    }
}
