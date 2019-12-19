package com.example.teachmanage.Activity;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.teachmanage.ActivityManage;
import com.example.teachmanage.R;

public class UpdateTeacher extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ActivityManage.addActivity(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updateteacher);
    }
}
