package com.bean;

/**
 * Created by 吴亚斌 on 2017/6/25.
 */
public class Information {
    private String id;
    private String name;
    private String date;
    private String address;
    private String tab;
    private String teacher_id;
    private int num;
    private String course_id;
    private String teachet_name;

    public String getTeachet_name() {
        return teachet_name;
    }

    public void setTeachet_name(String teachet_name) {
        this.teachet_name = teachet_name;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    @Override
    public String toString() {
        return "Information{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", address='" + address + '\'' +
                ", tab='" + tab + '\'' +
                ", teacher_id='" + teacher_id + '\'' +
                ", num=" + num +
                ", course_id='" + course_id + '\'' +
                ", teachet_name='" + teachet_name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    public String accountDate(String tab) {
        switch (tab) {
            case "1":
                return "8:00-10:00";
            case "2":
                return "10:00-12:00";
            case "3":
                return "14:00-16:00";
            case "4":
                return "16:00-18:00";
            case "5":
                return "19:00-21:00";
            default:
                return null;
        }
    }
}
