package com.example.pizza2019;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);// 툴바에 app_name이 나오게 해준다.

        //액티비티의 액바 래퍼런스를 얻음.
        ActionBar actionBar = getSupportActionBar();
        //앱바 유형의 객체를 반환하고 setDisplayHomeAsUpEnable
        //메소드에 true값을 인자로 전달해 호출
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
