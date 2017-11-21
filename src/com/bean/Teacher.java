package com.bean;

/**
 * Created by 吴亚斌 on 2017/6/25.
 */
public class Teacher {
    private String name;
    private String  id;
    private String sex;
    private String dept;
    private String tel;
    private String classs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", sex='" + sex + '\'' +
                ", dept='" + dept + '\'' +
                ", tel='" + tel + '\'' +
                ", classs='" + classs + '\'' +
                '}';
    }
}
