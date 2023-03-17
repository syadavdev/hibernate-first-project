package com.sandi.proxy;

public class StudentProxy extends Student{

    public StudentProxy(Attendence attendence) {
        super(attendence);
    }

    @Override
    public void attendLesson(){
        if(super.getAttendence().isPresent()){
            super.attendLesson();
        }else{
            throw new RuntimeException("Not attending session");
        }
    }

}
