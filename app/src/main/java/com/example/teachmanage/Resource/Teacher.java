package com.example.teachmanage.Resource;

import org.litepal.crud.DataSupport;

public class Teacher extends DataSupport {          //老师类（保存数据表的字段格式）
    private int id;         //Id
    private int num;        //工号
    private String name;    //姓名
    private int age;        //年龄
    private String title;   //职称
    private String department;  //所在院系
    private String curriculum;  //课程
    private String telephone;   //联系电话
    private String address;     //联系地址

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum(){
        return num;
    }

    public void setNum(int num){
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
