package com.sandi.spring_transactional.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

public class ConnectionInvocationHandler implements InvocationHandler {

    private Connection connection;

    public ConnectionInvocationHandler(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("connection trace : "+ method.toGenericString());
        final Object invoke = method.invoke(connection, args);
        return invoke;
    }
}
