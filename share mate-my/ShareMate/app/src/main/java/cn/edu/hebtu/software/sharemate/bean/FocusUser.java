package cn.edu.hebtu.software.sharemate.bean;

import java.io.Serializable;

public class FocusUser implements Serializable {
    private int focusId;
    private int userId;
    private int focusUserId;

    public FocusUser(int focusId, int userId, int focusUserId) {
        this.focusId = focusId;
        this.userId = userId;
        this.focusUserId = focusUserId;
    }

    public int getFocusId() {
        return focusId;
    }

    public void setFocusId(int focusId) {
        this.focusId = focusId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFocusUserId() {
        return focusUserId;
    }

    public void setFocusUserId(int focusUserId) {
        this.focusUserId = focusUserId;
    }
}
