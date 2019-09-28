package com.example.pizza2019ver2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

public class OrderActivity extends AppCompatActivity {
    private static final String TAG = "OrderActivity";
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

    /**
     * Toast 사용해서 메시지를 짧게 혹은 길게 처리하듯이
     * Snackbar를 이용해서 메시지 처리가 가능함.
     * 차이점:사용자와 상호작용이 가능함.
     * @param view Component, Activity
     */
    public void orderAdd(View view){
        //FloatingActionButton을 클릭하면 실행되는 코드 추가하기
        //Log.v(TAG,"주문 하기 호출");
        CharSequence msg = "스,낵,빠";
        int duration = Snackbar.LENGTH_SHORT;
        /*  Snackbar.make(파라미터 의미)
        첫째 - 스낵바를 표시할 뷰, 두번째 - 메시지, 세번째 - 시간   */
        Snackbar snackbar =
                Snackbar.make(findViewById(R.id.coordinator)
                        ,msg
                        ,duration);
        snackbar.setAction("Undo",new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast toast =
                        Toast.makeText(OrderActivity.this
                        ,"Undone"
                        ,Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        //스낵바 표시 메소드 호출
        snackbar.show();
    }
}
