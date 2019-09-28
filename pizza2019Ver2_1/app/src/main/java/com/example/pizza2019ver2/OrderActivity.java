package com.example.pizza2019ver2;

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
        setSupportActionBar(toolbar);

        //getSupportActionBar()메소드로 액티비티의 앱바 레퍼런스를 얻음.
        ActionBar actionBar = getSupportActionBar();
        //액션바 유형의 객체를 반환하고 setDisplayHomeAsUpEnabled메소드에
        //true값을 인자로 전달해 호출함.
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}

