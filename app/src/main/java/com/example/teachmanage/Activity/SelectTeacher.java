package com.example.teachmanage.Activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.teachmanage.ActivityManage;
import com.example.teachmanage.Adapter.TeacherAdapter;
import com.example.teachmanage.R;
import com.example.teachmanage.Resource.DoDataBase;
import com.example.teachmanage.Resource.StaticResource;
import com.example.teachmanage.Resource.Teacher;
import com.example.teachmanage.Resource.TeacherTypes;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class SelectTeacher extends Activity {
    private Spinner select_spinner;
    private EditText select_edit;
    private ListView select_list;
    private List<Teacher> teachers = new ArrayList<>();
    private int myPosition;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case 1: {
                    if (teachers.size() == 0) {
                        Toast.makeText(SelectTeacher.this, "没有查询到任何教师信息", Toast.LENGTH_SHORT).show();
                    } else {
                        TeacherAdapter adapter = new TeacherAdapter(SelectTeacher.this, R.layout.teacher_item, teachers);
                        select_list.setAdapter(adapter);
                        select_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                Teacher teacher = teachers.get(i);
                            }
                        });
                    }
                    }break;
                    default: break;
                }

        }
    };

    private void inits(){
        select_spinner = findViewById(R.id.select_spinner);
        select_edit = findViewById(R.id.select_edit);
        select_list = findViewById(R.id.select_list);
    }

    private void MySpinner(){
        String[] arr = new String[9];
        arr[0] = "查询类别";
        for (int i = 0;i < 8;i++){
            arr[i+1] = StaticResource.teacherTypes[i].getTypeName();
            Log.e("arr",arr[i+1]);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.spinner_text,arr);
        select_spinner.setAdapter(adapter);
        select_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                myPosition = position;
                Log.e("position",myPosition+"");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void listener(){
        select_edit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_UNSPECIFIED){
                    if (select_edit.getText().toString().equals("")){
                        teachers = DoDataBase.getAllTeacher();
                    }else {
                        teachers = DoDataBase.selectTeacher(StaticResource.teacherTypes[myPosition].getType(), select_edit.getText().toString());
                    }
                    Message myMessage = new Message();
                    myMessage.what = 1;
                    handler.sendMessage(myMessage);
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                }
                return false;
            }
        });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ActivityManage.addActivity(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectteacher);

        inits();

        MySpinner();

        listener();
    }
}
