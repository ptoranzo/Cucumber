package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;

public class JdbcTask {

	String dbUsername="syntax_hrm";
	String dbPassword="syntaxhrm123";
	String dbURL="jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";
	
	@Test
	public void dbData() throws SQLException{
		Connection connection=DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		Statement statement=connection.createStatement();
		ResultSet result=statement.executeQuery("select * from ohrm_job_title");
		
		ArrayList<String>arrData=new ArrayList<>();
		
		String data;
		while(result.next()) {
			//data=result.getObject("job_title").toString();
			arrData.add(result.getString("job_title"));
		}
		
		for (String data1 : arrData) {
			System.out.println(data1);
		}
		
		result.close();
		statement.close();
		connection.close();
		
	}
	
}
