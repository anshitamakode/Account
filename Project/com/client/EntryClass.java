package com.client;

import java.util.Scanner;

import com.beans.Ddate;
import com.businessProvider.ObjectProvider;
import com.exceptions.InvalidBalanceException;
import com.services.AccountServices;

public class EntryClass {

	public static void main(String[] args) {
		ObjectProvider o=new ObjectProvider();		
		AccountServices a=o.createObject();
		System.out.println("Welcome to main");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter accType of first account: ");
		String accType=sc.next();
		System.out.println("The account type of first account is: "+accType);
		System.out.println("Enter accBal: ");
		Float accBal=sc.nextFloat();
		System.out.println("The account bal of first account is: "+accBal);
		

		System.out.println("Enter accType of second account: ");
		String accType1=sc.next();
		System.out.println("The account type of second account is: "+accType1);
		System.out.println("Enter accBal of second account: ");
		Float accBal1=sc.nextFloat();
		System.out.println("The account bal of second account is: "+accBal1);
		
		int accNo=a.openAccount(accType,accBal,new Ddate(13,01,2019));
		System.out.println("Account No: "+accNo);
		int accNo1=a.openAccount(accType1,accBal1,new Ddate(27,2,2020));
		System.out.println("Account No: "+accNo1);
		
		float dep=a.deposit(accNo,1000,new Ddate(10,01,2020));
		System.out.println("Account balance post deposit: "+dep);
		
		float dep1=a.deposit(accNo1,7000,new Ddate(05,03,2021));
		System.out.println("Account balance post deposit: "+dep1);
		
		float with;
		
			try {
				with = a.withdraw(accNo,5000,new Ddate(10,05,2021));
				System.out.println("Account balance post withdraw: "+with);
			} catch (InvalidBalanceException e) {
				e.printStackTrace();
			}
			
		float balEn=a.balEnq(accNo,new Ddate(16,06,2022));
		System.out.println("Current Balance of accNo "+accNo+" is: "+balEn);
		
		float balEn1=a.balEnq(accNo1,new Ddate(13,01,2022));
		System.out.println("Current Balance of accNo "+accNo1+" is: "+balEn1);
		
		float fundTrans=a.fundTransfer(accNo, accNo1,100,new Ddate(19,07,2025));
		System.out.println("Fund is transferred from accNo "+accNo+" to accNo "+accNo1);
		System.out.println("Current balance of accNo "+accNo1+" is: "+fundTrans);
			
		System.out.println("Transition History is: ");
		a.transHist(accNo);
	
	}

}

