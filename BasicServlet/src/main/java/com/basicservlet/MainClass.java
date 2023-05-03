package com.basicservlet;

import java.sql.SQLException;
import java.util.List;

import com.basicservlet.bean.Account;
import com.basicservlet.utils.UserDatabseOpration;

public class MainClass {

	public static void main(String[] args) throws SQLException {
		
		
	   // new UserDatabseOpration().insert(account);
		List<Account> accounts = new UserDatabseOpration().findAll();
		for (Account account : accounts) {
			System.out.println(account.toString());
		}
		
		
			
		
	}

}
