package com.example.hellowworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.net.Uri.parse;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv_msg = findViewById(R.id.tv_msg);
    }
    public void telCall(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("tel:010-1234-5678"));
        startActivity(intent);
    }
}
