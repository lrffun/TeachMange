package com.example.teachmanage.Resource;

import android.provider.ContactsContract;

import org.litepal.crud.DataSupport;

import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;
import java.util.List;

public class DoDataBase {               //操纵数据库类
    public static Boolean addTeacher(Teacher teacher){      //增
        Boolean equalsOrNot = false;
        for (Teacher teacher1:getAllTeacher()){
            if (teacher1.equals(teacher)){
                equalsOrNot = true;
            }
        }
        if (!equalsOrNot){
            teacher.save();
        }
        return equalsOrNot;
    }

    public static void delateTeacher(Teacher teacher){      //删
        DataSupport.delete(Teacher.class,teacher.getId());
    }

    public static void updateTeacher(Teacher teacher,TeacherTypes teacherTypes,String value){          //改
        switch (teacherTypes.getCode()){
            case 1:{
                teacher.setNum(Integer.valueOf(value));
                teacher.save();
            }break;
            case 2:{
                teacher.setName(value);
                teacher.save();
            }break;
            case 3:{
                teacher.setAge(Integer.valueOf(value));
                teacher.save();
            }break;
            case 4:{
                teacher.setTitle(value);
                teacher.save();
            }break;
            case 5:{
                teacher.setDepartment(value);
                teacher.save();
            }break;
            case 6:{
                teacher.setCurriculum(value);
                teacher.save();
            }break;
            case 7:{
                teacher.setTelephone(value);
                teacher.save();
            }break;
            case 8:{
                teacher.setAddress(value);
                teacher.save();
            }break;
            default:break;
        }
    }

    public static List<Teacher> selectTeacher(String selectAttribute,String content){       //查
        List<Teacher> teachers = DataSupport.select(selectAttribute,content).find(Teacher.class);
        return teachers;
    }


    public static List<Teacher> getAllTeacher(){        //查所有
        List<Teacher> teachers = DataSupport.findAll(Teacher.class);
        return teachers;
    }
}
