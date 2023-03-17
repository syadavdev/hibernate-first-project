package com.sandi.proxy;

public class Student implements DailySession{

    private Attendence attendence;

    public Student(Attendence attendence) {
        this.attendence = attendence;
    }

    public Student(){
        System.out.println("default constructor");
    };

    public void attendLesson() {
        System.out.println("attending the session");
    }

    public void attendLesson(Integer id){
        System.out.println("attending session number : " + id);
    }

    public Attendence getAttendence() {
        return attendence;
    }

    public void setAttendence(Attendence attendence) {
        this.attendence = attendence;
    }
}
