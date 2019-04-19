package com.example.feedback;

public class FeedbackMember {
    private String name;
    private String date;
    private  String time;
    private Long phone;

    public FeedbackMember() {

    }

    public FeedbackMember(String name, String date, String time, Long phone) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }
}
