package com.example.teachmanage.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.teachmanage.R;
import com.example.teachmanage.Resource.Teacher;

import java.util.List;

public class TeacherAdapter extends ArrayAdapter<Teacher> {
    private int resourceId;

    public TeacherAdapter(Context context, int textViewResourceId, List<Teacher> teachers){
        super(context,textViewResourceId,teachers);
        resourceId = textViewResourceId;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Teacher teacher = getItem(position);
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        }else {
            view = convertView;
        }
        TextView name = view.findViewById(R.id.list_name);
        TextView my_id = view.findViewById(R.id.list_id);
        TextView department = view.findViewById(R.id.list_department);
        name.setText("姓名："+teacher.getName());
        my_id.setText("工号："+teacher.getNum());
        department.setText("所属院系："+teacher.getDepartment());
        return view;
    }
}
