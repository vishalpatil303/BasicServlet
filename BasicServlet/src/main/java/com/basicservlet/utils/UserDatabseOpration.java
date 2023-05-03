package com.basicservlet.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.basicservlet.bean.Account;

public class UserDatabseOpration implements UserDatabaseOpr {

	@Override
	public int insert(Account account) {
		int result = 0;
		PreparedStatement statement = null;
		Connection connection = ApplicationUtils.getConnection();
		try {
			String sql = "INSERT INTO ACCOUNT (FIRST_NAME,LAST_NAME,BALANCE) VALUES (?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, account.getFirstName());
			statement.setString(2, account.getLastName());
			statement.setDouble(3, account.getBalance());
			result = statement.executeUpdate();
			System.out.println(result + " No of row inserted");

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			closeAllResource(null, null, statement, connection);
		}

		return result;
	}

	@Override
	public int update(Account account) {
		int result = 0;
		Account foundAccount = findById(account.getId());
		PreparedStatement statement = null;
		Connection connection = ApplicationUtils.getConnection();
		String sql = "update ACCOUNT SET FIRST_NAME = ?," + "LAST_NAME = ?," + "BALANCE = ? "
				+ "Where ACCOUNT_NUMBER = ?";
		try {
			statement = connection.prepareStatement(sql);

			if (account.getFirstName() != null && account.getFirstName() != "") {
				statement.setString(1, account.getFirstName());
			} else {
				statement.setString(1, foundAccount.getFirstName());
			}

			if (account.getLastName() != null && account.getLastName() != "") {
				statement.setString(2, account.getLastName());
			} else {
				statement.setString(2, foundAccount.getLastName());
			}

			if (account.getBalance() != 0) {
				statement.setDouble(3, account.getBalance());
			} else {
				statement.setDouble(3, foundAccount.getBalance());
			}

			statement.setInt(4, account.getId());

			result = statement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAllResource(null, null, statement, connection);
		}
		return result;
	}

	public Account findById(int id) {
		Account account = new Account();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = ApplicationUtils.getConnection();
		String sql = "SELECT * FROM ACCOUNT WHERE ACCOUNT_NUMBER = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					account.setId(resultSet.getInt("ACCOUNT_NUMBER"));
					account.setFirstName(resultSet.getString("FIRST_NAME"));
					account.setLastName(resultSet.getString("LAST_NAME"));
					account.setBalance(resultSet.getDouble("BALANCE"));
				}
			} else {
				System.out.println("No Account found by given ID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAllResource(resultSet, null, statement, connection);
		}

		return account;
	}

	@Override
	public void delete(Account account) {
		PreparedStatement statement = null;
		if (findById(account.getId()) != null) {
			Connection connection = ApplicationUtils.getConnection();
			String sql = "DELETE FROM ACCOUNT WHERE ACCOUNT_NUMBER = ?";
			try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, account.getId());
				int result = statement.executeUpdate();
				System.out.println(result + " of row deleted.");
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				closeAllResource(null, null, statement, connection);
			}
		}

	}

	@Override
	public List<Account> findAll() {
		List<Account> accounts = new ArrayList<Account>();
		Connection connection = ApplicationUtils.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.createStatement();
			String sql = "SELECT * FROM ACCOUNT";
			resultSet = statement.executeQuery(sql);
			if(resultSet != null) {
				while(resultSet.next()) {
					Account account = new Account();
					account.setId(resultSet.getInt("ACCOUNT_NUMBER"));
					account.setFirstName(resultSet.getString("FIRST_NAME"));
					account.setLastName(resultSet.getString("LAST_NAME"));
					account.setBalance(resultSet.getDouble("BALANCE"));
					accounts.add(account);
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			closeAllResource(resultSet, statement, null, connection);
		}
		return accounts;
	}
	
	@Override
	public void closeAllResource(ResultSet resultSet, Statement statement, PreparedStatement preparedStatement,
			Connection connection) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	

}
