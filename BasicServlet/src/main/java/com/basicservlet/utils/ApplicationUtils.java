package com.basicservlet.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ApplicationUtils {

	public static Connection getConnection() {
		Connection connection = null;
		try {
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
			//connection.setAutoCommit(false);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return connection;

	}

}
