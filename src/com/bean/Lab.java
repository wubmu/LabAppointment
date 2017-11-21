package com.bean;

/**
 * Created by 吴亚斌 on 2017/6/25.
 */
public class Lab {
    private String address;
    private String id;
    private String date;
    private String teacherid;
    private String tab;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String accountDate(String tab) {
        switch (tab){
            case "1":return "8:00-10:00";
            case "2":return "10:00-12:00";
            case "3":return "14:00-16:00";
            case "4":return "16:00-18:00";
            case "5":return "19:00-21:00";
            default:return null;
        }
    }
}
