package com.example.beeradviser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.beeradviser.R;

import java.util.List;

public class FindBeerActivity extends AppCompatActivity {
    private BeerExpet expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickFindBeer(View view){
        //?
        TextView brands = findViewById(R.id.brands);
        //?
        Spinner color = findViewById(R.id.color);
        //?
        String beerType = String.valueOf(color.getSelectedItemId());

        List<String> brandsList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for(String brand:brandsList){
            brandsFormatted.append(?).append("\n");
        }
        brands.setText(brandsFormatted);
    }
}
