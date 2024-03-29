package com.sandi.hibernate;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class MySqlProcedureCall {

    public static void main(String...args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

        Integer input = 81;

        String query = "call testing_out_param(? , ? )";
        final CallableStatement stmt = connection.prepareCall(query);

        stmt.setInt(1, input);
        stmt.registerOutParameter(2, Types.INTEGER);
        stmt.execute();
        stmt.getResultSet().next();

        System.out.println("Output variable value : " + stmt.getInt(2));
        System.out.println("procedure result : " + stmt.getResultSet().getString(1));

        connection.close();
    }

}
