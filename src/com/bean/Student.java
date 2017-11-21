package com.bean;

/**
 * Created by chenna on 2017/6/25.
 */
public class Student {
    private String student_id;
    private String student_name;
    private String student_sex;
    private String student_dept;
    private String student_tel;

    @Override
    public String toString() {
        return "Student{" +
                "student_id='" + student_id + '\'' +
                ", student_name='" + student_name + '\'' +
                ", student_sex='" + student_sex + '\'' +
                ", student_dept='" + student_dept + '\'' +
                ", student_tel='" + student_tel + '\'' +
                '}';
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_dept() {
        return student_dept;
    }

    public void setStudent_dept(String student_dept) {
        this.student_dept = student_dept;
    }

    public String getStudent_sex() {
        return student_sex;
    }

    public void setStudent_sex(String student_sex) {
        this.student_sex = student_sex;
    }

    public String getStudent_tel() {
        return student_tel;
    }

    public void setStudent_tel(String student_tel) {
        this.student_tel = student_tel;
    }
}
