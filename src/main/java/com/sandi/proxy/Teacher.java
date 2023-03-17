package com.sandi.proxy;

import java.util.Date;

public class Teacher {

    public static void main(String...args){
        DailySession session = new StudentProxy(new Attendence(new Date(), false));
        session.attendLesson();
    }

}
