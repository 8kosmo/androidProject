package com.example.workout2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //버튼을 클릭하면 이메소드가 호출되면서 DetailActivity가 실행됨.
    public void onShowDetails(View view) {
        Intent intent = new Intent(this,DetailActivity.class);
        startActivity(intent);
    }
}
