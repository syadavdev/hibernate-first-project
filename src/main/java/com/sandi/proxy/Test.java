package com.sandi.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

    public static void main(String...args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        //Fetching class & its methods/constructor
        Class<?> studentInfo = Class.forName("com.sandi.proxy.Student");
        Student student = (Student) studentInfo.newInstance();
        Constructor<?>[] constructors = studentInfo.getConstructors();

        for (Constructor con : constructors){
            System.out.println(con);
        }

        Method[] methods = studentInfo.getMethods();
        for(Method method : methods)
            System.out.println(method);


        //Fetching & calling specific method of class
        Class[] methodArgsTypes = new Class[] {Integer.class};
        Method attendLesson = studentInfo.getDeclaredMethod("attendLesson", methodArgsTypes);
        attendLesson.invoke(student, 4);

        Method attendLesson1 = studentInfo.getDeclaredMethod("attendLesson");
        attendLesson1.invoke(student);
    }

}
