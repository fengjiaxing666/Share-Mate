package com.example.lenovo.sharemate;

public class note {
    private int photo;
    private String text,alltext,title;
    private int usericon;
    private String username,time;
    private String zancount,sharecount,collectcount,pingluncount;
    public note(int photo, String alltext, String title, int usericon, String username, String time, String zancount, String sharecount, String collectcount, String pingluncount) {
        this.photo = photo;
        this.alltext = alltext;
        this.title = title;
        this.usericon = usericon;
        this.username = username;
        this.time = time;
        this.zancount = zancount;
        this.sharecount = sharecount;
        this.collectcount = collectcount;
        this.pingluncount = pingluncount;
    }



    public String getPingluncount() {
        return pingluncount;
    }

    public void setPingluncount(String pingluncount) {
        this.pingluncount = pingluncount;
    }

    public String getTitle() {
        return title;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getZancount() {
        return zancount;
    }

    public void setZancount(String zancount) {
        this.zancount = zancount;
    }

    public String getSharecount() {
        return sharecount;
    }

    public void setSharecount(String sharecount) {
        this.sharecount = sharecount;
    }

    public String getCollectcount() {
        return collectcount;
    }

    public void setCollectcount(String collectcount) {
        this.collectcount = collectcount;
    }


    public note(int photo, String text, int icon, String name, String count) {
        this.photo = photo;
        this.text = text;
        this.usericon = icon;
        this.username=name;
        this.zancount=count;
    }

    public String getAlltext() {
        return alltext;
    }

    public void setAlltext(String alltext) {
        this.alltext = alltext;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getUsericon() {
        return usericon;
    }

    public void setUsericon(int usericon) {
        this.usericon = usericon;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getZanCount() {
        return zancount;
    }

    public void setZanCount(String count) {
        this.zancount = count;
    }
}
