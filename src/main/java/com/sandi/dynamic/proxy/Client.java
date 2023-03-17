package com.sandi.dynamic.proxy;

import java.lang.reflect.Proxy;

public class Client {

    public static void main(String...args){
        ITEmployee itemp = new ITEmployee();
        itemp.setId(1);
        itemp.setName("Udit");
        itemp.setSalary(200000);

        EmployeeSalaryInvocationHandler handler = new EmployeeSalaryInvocationHandler(itemp);
        IEmployee employee = (IEmployee) Proxy.newProxyInstance(ITEmployee.class.getClassLoader(), new Class[]{IEmployee.class}, handler);
        employee.giveHike(40000);
        employee.payCut(500000);

        //itemp.giveHike(-40000);
        System.out.println(employee.getSalary());
    }

}
