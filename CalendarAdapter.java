package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CalendarAdapter extends BaseAdapter {

    private Context context;
    private int workoutCount;
    private List<String> workoutInfoList;

    public CalendarAdapter(Context context, int workoutCount) {
        this.context = context;
        this.workoutCount = workoutCount;
        this.workoutInfoList = generateWorkoutInfoList();
    }

    @Override
    public int getCount() {
        return workoutCount;
    }

    @Override
    public Object getItem(int position) {
        return workoutInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.calendar_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.dateTextView = convertView.findViewById(R.id.dateTextView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // 날짜를 표시합니다.
        viewHolder.dateTextView.setText(String.valueOf(position + 1));

        return convertView;
    }

    // 운동 정보 리스트를 생성합니다.
    private List<String> generateWorkoutInfoList() {
        List<String> workoutInfoList = new ArrayList<>();
        for (int i = 0; i < workoutCount; i++) {
            StringBuilder workoutInfoBuilder = new StringBuilder();
            workoutInfoBuilder.append("Day ").append(i + 1).append(": ");

            if ((i + 1) % 5 == 0) {
                workoutInfoBuilder.append("Push-ups");
            }

            if ((i + 1) % 2 == 0) {
                if (workoutInfoBuilder.length() > 0) {
                    workoutInfoBuilder.append(", ");
                }
                workoutInfoBuilder.append("Sit-ups");
            }

            if ((i + 1) % 2 == 0) {
                if (workoutInfoBuilder.length() > 0) {
                    workoutInfoBuilder.append(", ");
                }
                workoutInfoBuilder.append("Squats");
            }

            if ((i + 1) % 10 == 0) {
                if (workoutInfoBuilder.length() > 0) {
                    workoutInfoBuilder.append(", ");
                }
                workoutInfoBuilder.append("Pull-ups");
            }

            workoutInfoList.add(workoutInfoBuilder.toString());
        }

        return workoutInfoList;
    }

    // 클릭한 날짜에 해당하는 운동 정보를 가져옵니다.
    public String getWorkoutInfo(int position) {
        return workoutInfoList.get(position);
    }

    private static class ViewHolder {
        TextView dateTextView;
    }
}