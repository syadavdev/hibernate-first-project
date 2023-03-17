package com.sandi.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EmployeeSalaryInvocationHandler implements InvocationHandler {

    private IEmployee employeeTarget;

    public EmployeeSalaryInvocationHandler(IEmployee employee) {
        this.employeeTarget = employee;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("giveHike")  && ((Double)args[0]) > 0) {
            method.invoke(employeeTarget, args);
        } else
            throw new RuntimeException("salary can't be -ve");
        return null;
    }

}
