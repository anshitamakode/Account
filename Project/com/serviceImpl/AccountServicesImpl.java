package com.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;

import com.beans.Account;
import com.beans.Ddate;
import com.daoProvider.DAOProvider;
import com.daoServices.DAOServices;
import com.exceptions.InvalidAccountException;
import com.exceptions.InvalidBalanceException;
import com.services.AccountServices;

public class AccountServicesImpl implements AccountServices {
	//private Accounts a[]=new Accounts[5];
	//private int i=0,val=0,val1=0;
	Ddate d1=null,d2=null,d3=null,d4=null,d5=null;
	ArrayList<Ddate> ar=new ArrayList<Ddate>();
	ArrayList<Account> arr=new ArrayList<Account>();
	Account a1=null;
	Account a2=null;
	DAOServices dao=null;
	int count=0,flag=0;
	
	public AccountServicesImpl()
	{
		
	}
	
	public AccountServicesImpl(Account a1)
	{
		this.a1=a1;
	}
	public int openAccount(String type,float amt,Ddate dt)
	{
		/*a[i]=new Accounts(type,amt);
		dao=DAOProvider.getDAOObject();
		count=dao.insertAccountData(a[i]);
		if(count>0)
			System.out.println("Record Inserted");
		i++;
		d1=dt;
		ar.add(d1);
		return a[i-1].getAccNo();		*/
		a1=new Account(type, amt);
		arr.add(a1);
		dao=DAOProvider.getDAOObject();
		count=dao.insertAccountData(a1);
		if(count>0)
			System.out.println("Record Inserted");
		d1=dt;
		ar.add(d1);
		return a1.getAccNo();
	}
	public float deposit(int accNo,float amt,Ddate dt)
	{
		 try {
			a1=validate(accNo);
		} catch (InvalidAccountException e) {
			e.printStackTrace();
		}
		/* if(val!=-1) {
		 a[val].setAccBal(a[val].getAccBal()+amt);
		 dao=DAOProvider.getDAOObject();
		 count=dao.updateAccountData(accNo, amt);
			if(count>0)
				System.out.println("Record Inserted");
		 d2=dt;
		 ar.add(d2);
		 return a[val].getAccBal();
		 }
		 else
			 return 0;*/
		 if(a1!=null) {
		 a1.setAccBal(a1.getAccBal()+amt);
		 arr.add(a1);
		 dao=DAOProvider.getDAOObject();
		 count=dao.updateAccountData(a1);
			if(count>0)
				System.out.println("Record Inserted");
		 d2=dt;
		 ar.add(d2);
		 return a1.getAccBal();
		 }
		 else
			 return 0;
	
		 
	}
	public float withdraw(int accNo,float amt,Ddate dt) throws InvalidBalanceException
	{	
		try {
			a1=validate(accNo);
		} catch (InvalidAccountException e) {
			e.printStackTrace();
		}
		/*if(val!=-1) {
		if(a[val].getAccBal()>amt)
		{
		a[val].setAccBal(a[val].getAccBal()-amt);
		dao=DAOProvider.getDAOObject();
		 count=dao.updateAccountData1(accNo, amt);
			if(count>0)
				System.out.println("Record Inserted");
		d3=dt;
		ar.add(d3);
		return a[val].getAccBal();
		}
		else
			throw new InvalidBalanceException("Insufficient balance");
		}
		else
			return 0;*/
		if(a1!=null) {
		if(a1.getAccBal()>amt)
		{
		a1.setAccBal(a1.getAccBal()-amt);
		arr.add(a1);
		dao=DAOProvider.getDAOObject();
		 count=dao.updateAccountData(a1);
			if(count>0)
				System.out.println("Record Inserted");
		d3=dt;
		ar.add(d3);
		return a1.getAccBal();
		}
	else
		throw new InvalidBalanceException("Insufficient balance");
		}
		else
			return 0;
}
	public float balEnq(int accNo,Ddate dt)
	{
		try {
			a1=validate(accNo);
		} catch (InvalidAccountException e) {
			e.printStackTrace();
		}
		if(a1!=null) {
		
		arr.add(a1);
			d4=dt;
			ar.add(d4);
			return a1.getAccBal();
		}
		else
			return 0;
	}
	public Account validate(int accNo) throws InvalidAccountException
	{
		/*for(i=0;i<a.length;i++)
		{
		if(a[i]==null)
			throw new InvalidAccountException("Incorrect Account no.,Enter correct account no.");
		if(a[i].getAccNo()==accNo)
		return i;
		}
		return -1;*/
		Iterator<Account>itr=arr.iterator();
		while(itr.hasNext()) {
			a1=itr.next();
		if(a1.getAccNo()==accNo) {
			flag=1;
			return a1;
		}
		}
		if(flag==0)
			throw new InvalidAccountException("Incorrect Account no.,Enter correct account no.");
		return null;
			
			
	}

	@Override
	public float fundTransfer(int accNo1, int accNo2, float amt,Ddate dt) {
		try {
			a1=validate(accNo1);
			a2=validate(accNo2);
		} catch (InvalidAccountException e) {
			e.printStackTrace();
		}
		if(a1!=null || a2!=null) {
				a1.setAccBal(a1.getAccBal()-amt);
				arr.add(a1);
				dao=DAOProvider.getDAOObject();
				 count=dao.updateAccountData(a1);
				a2.setAccBal(a2.getAccBal()+amt);
				arr.add(a2);
				dao=DAOProvider.getDAOObject();
				 count=dao.updateAccountData(a2);
				d5=dt;
				ar.add(d5);
			return a2.getAccBal();
		}
		else
		return 0;
	}

	@Override
	public void transHist(int accNo) {
		try {
			a1=validate(accNo);
		} catch (InvalidAccountException e) {
			e.printStackTrace();
		}
		if(a1!=null) {
			System.out.println("Account was created on "+ar.get(ar.indexOf(d1)));
			System.out.println("Deposition "+ar.get(ar.indexOf(d2)));
			System.out.println("Withdrawal "+ar.get(ar.indexOf(d3)));
			System.out.println("Balance Enquiry "+ar.get(ar.indexOf(d4)));
			System.out.println("Fund Transfer "+ar.get(ar.indexOf(d5)));
			
		}
			
		
	}
	

}

