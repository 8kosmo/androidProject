package com.example.startmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //전송버튼을 클릭하면 호출됨.
    public void onSendMessage(View view){
        //Toast.makeText(this,"버튼클릭성공", Toast.LENGTH_LONG).show();
        EditText et_msg = findViewById(R.id.sendmessage);
        String msg = et_msg.getText().toString();
        Intent intent = new Intent(this,ReceiveActivity.class);
        //
        //
        intent.putExtra(ReceiveActivity.EXTRA_MESSAGE,msg);
        startActivity(intent);
    }
}
