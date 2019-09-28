package com.example.starbuzz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
public class DrinkActivity extends Activity {
    public static final String EXTRA_DRINKID = "drinkid";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        //인텐트에 담긴 정보 꺼내기
        int drinkid =
                (Integer) getIntent().getExtras().get(EXTRA_DRINKID);
        Drink drink = Drink.drinks[drinkid];
        //음료 이름 가져오기
        TextView name = findViewById(R.id.name);
        name.setText(drink.getName());
        //음료 설명 가져오기
        TextView description = findViewById(R.id.description);
        description.setText(drink.getDescription());
        //음료 이미지 가져오기
        ImageView photo = findViewById(R.id.photo);
        photo.setImageResource(drink.getImageResourceId());
        photo.setContentDescription(drink.getName());
    }
}

