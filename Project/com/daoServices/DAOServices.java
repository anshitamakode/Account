package com.daoServices;

import com.beans.Account;

public interface DAOServices {
	int insertAccountData(Account acc);
	Account getAccountDetails(int accNo);
	int updateAccountData(Account acc);

}
