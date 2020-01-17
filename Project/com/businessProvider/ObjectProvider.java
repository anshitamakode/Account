package com.businessProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.services.AccountServices;

public class ObjectProvider {
	public AccountServices createObject()
	{
		FileInputStream fis=null;
		AccountServices obj=null;
		try {
			fis = new FileInputStream(".//resources//account.properties");
			Properties p=new Properties();
			p.load(fis);
			String businessClass=p.getProperty("businessComponent");
			obj=(AccountServices)Class.forName(businessClass).newInstance();
			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return obj;
		
	}

}

