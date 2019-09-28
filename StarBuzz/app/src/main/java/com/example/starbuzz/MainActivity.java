package com.example.starbuzz;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //OnItemClickListener생성
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View itemView, int position, long id) {
                //0:drinks, 1:food, 2:stores
                if(position == 0){
                    Intent intent = new Intent(MainActivity.this,DrinkCategoryActivity.class);
                    startActivity(intent);
                }
            }
        };//end of OnItemClickListener
        //리스너를 리스트뷰에 매핑
        ListView listView = findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);
    }
}

