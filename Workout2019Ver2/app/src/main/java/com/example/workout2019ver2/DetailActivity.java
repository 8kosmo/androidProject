package com.example.workout2019ver2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_WORKOUT_ID = "id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        WorkoutDetailFragment frag = (WorkoutDetailFragment)getSupportFragmentManager().findFragmentById(R.id.detail_frag);
        //인탠트한 id값을 꺼내서 초기화하는 코드
        int workoutId = (int)getIntent().getExtras().get(EXTRA_WORKOUT_ID);
        frag.setWorkoutId(workoutId);//0 or 1 or 2 or 3
    }
}

