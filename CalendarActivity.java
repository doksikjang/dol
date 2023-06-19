package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class CalendarActivity extends AppCompatActivity {

    private GridView calendarGridView;
    private CalendarAdapter calendarAdapter;
    private int workoutCount = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calendarGridView = findViewById(R.id.calenderGridView);
        calendarAdapter = new CalendarAdapter(CalendarActivity.this, workoutCount);

        calendarGridView.setAdapter(calendarAdapter);
        calendarGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 클릭한 날짜에 대한 운동 정보를 가져옵니다.
                String workoutInfo = calendarAdapter.getWorkoutInfo(position);

                // WorkoutInfoActivity로 이동하여 운동 정보를 표시합니다.
                Intent intent = new Intent(CalendarActivity.this, WorkoutInfoActivity.class);
                intent.putExtra("workoutInfo", workoutInfo);
                startActivity(intent);
            }
        });
    }
}
