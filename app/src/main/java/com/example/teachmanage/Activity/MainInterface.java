package com.example.teachmanage.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.teachmanage.ActivityManage;
import com.example.teachmanage.R;

public class MainInterface extends Activity implements View.OnClickListener {       //主界面
    private Button add;                 //四个按钮
    private Button delate;
    private Button change;
    private Button select;

    @Override
    public void onClick(View view) {        //通过实现接口将按钮点击事件封装成一个函数
        switch (view.getId()){
            case R.id.add:{
                Intent intent = new Intent(MainInterface.this,AddTeacher.class);
                startActivity(intent);
            }break;
            case R.id.delete:{
                Intent intent = new Intent(MainInterface.this,DeleteTeacher.class);
                startActivity(intent);
            }break;
            case R.id.change:{
                Intent intent = new Intent(MainInterface.this,UpdateTeacher.class);
                startActivity(intent);
            }break;
            case R.id.select:{
                Intent intent = new Intent(MainInterface.this,SelectTeacher.class);
                startActivity(intent);
            }break;
            default:break;
        }
    }

    private void initButton(){          //初始化按钮
        add = findViewById(R.id.add);
        delate = findViewById(R.id.delete);
        change = findViewById(R.id.change);
        select = findViewById(R.id.select);
        add.setOnClickListener(this);
        delate.setOnClickListener(this);
        change.setOnClickListener(this);
        select.setOnClickListener(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManage.addActivity(this);       //添加到活动控制类
        setContentView(R.layout.main_interface);
        initButton();                           //初始化按钮
    }
}
