package com.daoServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.beans.Account;
import com.daoProvider.DBConnectionProvider;
import com.daoServices.DAOServices;

public class DAOServiceImp implements DAOServices{
	Connection con=DBConnectionProvider.getDBConnection();
	PreparedStatement ps;
	Account a=null;
	int count;

	@Override
	public int insertAccountData(Account acc) {
		try {
			ps=con.prepareStatement("insert into AccountTable values(?,?,?)");
			ps.setInt(1,acc.getAccNo());
			ps.setString(2,acc.getAcctype());
			ps.setFloat(3,acc.getAccBal());
			count=ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	

	@Override
	public Account getAccountDetails(int accNo) {
		
		try {
			ps=con.prepareStatement("select * from AccountTable where accNo=?");
			ps.setInt(1,accNo);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				int accNo1=rs.getInt(1);
				String accType=rs.getString(2);
				float accBal=rs.getFloat(3);
				a=new Account(accType,accBal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}



	public int updateAccountData(Account acc) {
		try {
		ps=con.prepareStatement("update AccountTable set accBal=? where accNo=?");
		
		ps.setFloat(1,acc.getAccBal());
		ps.setInt(2,acc.getAccNo());
		
		count=ps.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return count;
	
	}

}
