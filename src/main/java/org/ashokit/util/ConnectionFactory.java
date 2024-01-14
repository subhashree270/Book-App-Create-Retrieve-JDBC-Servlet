package org.ashokit.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	private static DataSource ds=null;
	private ConnectionFactory() {}
	public static Connection getConnection() throws Exception{
		
	   if (ds==null) {
		   FileInputStream fis=new FileInputStream(new File("E:\\Workspace2\\MiniProject-01\\dbconfig.properties"));
		   Properties p=new Properties();
		   p.load(fis);
		   
		   String url=p.getProperty("db.url");
		   String uname=p.getProperty("db.uname");
		   String pwd=p.getProperty("db.pwd");
		   String driver=p.getProperty("db.driver");
		   
		   HikariConfig config=new HikariConfig();
		   config.setUsername(uname);
		   config.setJdbcUrl(url);
		   config.setPassword(pwd);
		   config.setDriverClassName(driver);
		   ds=new HikariDataSource(config);
		   
	   }
		return ds.getConnection();
	}

}
