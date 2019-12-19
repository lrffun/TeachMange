package com.example.teachmanage.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.teachmanage.ActivityManage;
import com.example.teachmanage.R;
import com.example.teachmanage.Resource.DoDataBase;
import com.example.teachmanage.Resource.Teacher;

import java.util.ArrayList;
import java.util.List;

public class AddTeacher extends Activity {
    private Button submit;
    private EditText id;
    private EditText name;
    private EditText age;
    private EditText title;
    private EditText department;
    private EditText curriculum;
    private EditText telephone;
    private EditText address;
    private List<EditText> editTexts;

    private void inits(){           //初始化所有控件
        submit = findViewById(R.id.submit);
        id = findViewById(R.id.id);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        title = findViewById(R.id.title);
        department = findViewById(R.id.department);
        curriculum = findViewById(R.id.curriculum);
        telephone = findViewById(R.id.telephone);
        address = findViewById(R.id.address);
        editTexts = new ArrayList<>();
        editTexts.add(id);
        editTexts.add(name);
        editTexts.add(age);
        editTexts.add(title);
        editTexts.add(department);
        editTexts.add(curriculum);
        editTexts.add(telephone);
        editTexts.add(address);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {          //主函数
        ActivityManage.addActivity(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addteacher);
        inits();            //初始化；

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                //设置按钮监听
                Boolean NullOrNot = false;
                for (EditText e:editTexts){                 //检测是否有未输入的项
                    if ("".equals(e.getText().toString())){
                        Toast.makeText(AddTeacher.this,"请输入教师的所有信息！",Toast.LENGTH_SHORT).show();
                        NullOrNot = true;
                        break;
                    }
                }
                if (!NullOrNot) {
                    Teacher teacher = new Teacher();
                    teacher.setNum(Integer.valueOf(id.getText().toString()));
                    teacher.setName(name.getText().toString());
                    teacher.setAge(Integer.valueOf(age.getText().toString()));
                    teacher.setTitle(title.getText().toString());
                    teacher.setDepartment(department.getText().toString());
                    teacher.setCurriculum(curriculum.getText().toString());
                    teacher.setTelephone(telephone.getText().toString());
                    teacher.setAddress(address.getText().toString());
                    DoDataBase.addTeacher(teacher);
                    Toast.makeText(AddTeacher.this, "已录入数据库中", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
