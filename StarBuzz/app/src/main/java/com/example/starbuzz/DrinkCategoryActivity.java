package com.example.starbuzz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
public class DrinkCategoryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);
        //자바배열이나 데이터베이스처럼 strings.xml에 정의되어 있지 않은 데이터를
        //리스트뷰로 표시하려면 어댑터를 사용함.
        //어댑터는 데이터소스와 리스트뷰 사이의 다리역할
        //listAdapter는 배열 어댑터이다.
        //DrinkCategoryActivity->ListView->setAdapter-ArrayAdapter<Drink>-Drink.toString()-Drink.drinks
        ArrayAdapter<Drink> listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,Drink.drinks);
        ListView listDrinks = findViewById(R.id.list_drinks);
        listDrinks.setAdapter(listAdapter);

        //리슨너 생성
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listDinks, View itemView, int position, long id) {
                //사용자가 클릭한 음료를 DrinkActivity로 전달.
                Intent intent = new Intent(DrinkCategoryActivity.this, DrinkActivity.class);
                intent.putExtra(DrinkActivity.EXTRA_DRINKID, (int)id);
                startActivity(intent);
            }
        };
        //리슨너를 리스트 뷰에 할당
        listDrinks.setOnItemClickListener(itemClickListener);
    }
}

