package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class WorkoutInfoActivity extends AppCompatActivity {

    private TextView workoutInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_info);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        workoutInfoTextView = findViewById(R.id.workoutInfoTextView);

        // WorkoutInfoActivity로부터 운동 정보를 전달받습니다.
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("workoutInfo")) {
            String workoutInfo = intent.getStringExtra("workoutInfo");
            workoutInfoTextView.setText(workoutInfo);
        }

        // 뒤로 가기 버튼을 처리합니다.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    // 뒤로 가기 버튼을 눌렀을 때의 동작을 정의합니다.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // 현재 액티비티를 종료합니다.
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}