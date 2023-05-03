package com.basicservlet.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.basicservlet.bean.Account;

public interface UserDatabaseOpr {
	
	int insert(Account account);
	int update(Account account);
	Account findById(int id);
	int delete(Account account);

	List<Account> findAll();
	void closeAllResource(ResultSet resultSet ,Statement statement , PreparedStatement preparedStatement ,Connection connection);

}
