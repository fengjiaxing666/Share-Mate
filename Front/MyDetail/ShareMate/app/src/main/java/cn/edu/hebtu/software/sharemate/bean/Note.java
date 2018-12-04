package cn.edu.hebtu.software.sharemate.bean;

import java.util.ArrayList;
import java.util.List;

public class Note {
    private int noId;
    private int noPhoto;
    private String title;
    private int userId;

    public Note(int noPhoto, String title) {
        this.noPhoto = noPhoto;
        this.title = title;
    }

    public int getNoPhoto() {
        return noPhoto;
    }

    public void setNoPhoto(int noPhoto) {
        this.noPhoto = noPhoto;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String content) {
        this.title = content;
    }
}
