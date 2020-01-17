package com.services;

import com.beans.Account;
import com.beans.Ddate;
import com.exceptions.InvalidAccountException;
import com.exceptions.InvalidBalanceException;

public interface AccountServices  {
	int openAccount(String type,float amt,Ddate dt);
	float deposit(int accNo,float amt,Ddate dt) ;
	float withdraw(int accNo,float amt,Ddate dt) throws InvalidBalanceException;
	float balEnq(int accNo,Ddate dt);
	Account validate(int accNo) throws InvalidAccountException;
	public float fundTransfer(int accNo1,int accNo2,float amt,Ddate dt);
	public void transHist(int accNo);

}

