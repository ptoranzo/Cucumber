package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;
public class MetaData {
    String dbUsername = "syntax_hrm";
    String dbPassword = "syntaxhrm123";
    String dbUrl = "jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";
    
    @Test
    public void getMetaData() throws SQLException {
        
        Connection c=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        
        DatabaseMetaData dbData=c.getMetaData();
        String dbname=dbData.getDatabaseProductName();
        String dbversion=dbData.getDatabaseProductVersion();
        
        System.out.println(dbname);
        System.out.println(dbversion);
        
        Statement s=c.createStatement();
        ResultSet rset=s.executeQuery("select * from hs_hr_employees where emp_number=4353");
        
        ResultSetMetaData resultData = rset.getMetaData();
        int cols=resultData.getColumnCount();
        
        System.out.println(cols);
        
        String colname=resultData.getColumnName(1);
        System.out.println(colname);
        
        for(int i=1; i<=cols; i++) {
            String colName=resultData.getColumnName(i);
            System.out.println(colName);
        }
        
    }
}
