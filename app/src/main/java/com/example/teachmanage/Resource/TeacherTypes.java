package com.example.teachmanage.Resource;

public enum TeacherTypes {
    ID(1,"num","工号"),
    NAME(2,"name","姓名"),
    AGE(3,"age","年龄"),
    TITLE(4,"title","职称"),
    DEPARTMENT(5,"department","所属院系"),
    CURRICULUM(6,"curriculum","课程"),
    TELEPHONE(7,"telephone","联系电话"),
    ADDRESS(8,"address","地址");

    private int code;
    private String type;
    private String typeName;

    private TeacherTypes(int code,String type,String typeName){
        this.code = code;
        this.type = type;
        this.typeName = typeName;
    }

    public int getCode(){
        return code;
    }

    public String getType(){
        return type;
    }

    public String getTypeName(){return typeName;}
}
