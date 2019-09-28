package com.example.book72_1.ui.login;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.book72_1.R;

public class LoginActivity extends AppCompatActivity {
    EditText et_mail = null;
    EditText et_pw = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void loginAction(View v) {
        Log.d(this.getClass().getName(),"loginAction 호출");
        et_mail = findViewById(R.id.et_email);
        et_pw = findViewById(R.id.et_pw);
        LoginLogic logic = new LoginLogic();
        logic.execute("파라미터값1'1ㅁㅁ");
    }
}
