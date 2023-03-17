package com.sandi.proxy;

import java.util.Date;

public class Attendence {

    private Date date;
    private boolean isPresent;

    public Attendence(Date date, boolean isPresent) {
        super();
        this.date = date;
        this.isPresent = isPresent;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }
}
