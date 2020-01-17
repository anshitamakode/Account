package com.daoProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.daoServices.DAOServices;

public class DAOProvider {
	public static DAOServices getDAOObject () {
		FileInputStream fis=null;
		DAOServices obj=null;
		try {
			fis = new FileInputStream(".//resources//Databaseconfig.properties");
			Properties p=new Properties();
			p.load(fis);
			String DAO=p.getProperty("DAO");
			obj=(DAOServices)Class.forName(DAO).newInstance();
			
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
