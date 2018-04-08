package yjm.utils;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidUtil
{
	/*
	 * 创建连接池工具
	 */
	
	private static Properties properties = new Properties();
	private static DataSource dSource = null;
	
	//私有化无参构造器，防止创建对象
	private DruidUtil(){}
	
	//将必要的代码放入静态代码块
	static
	{
		try
		{
			InputStream iStream = Thread.currentThread().
					getContextClassLoader().getResourceAsStream("druid.properties");
			properties.load(iStream);
			iStream.close();
			dSource = DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e)
		{
			System.out.println("Drui连接池创建失败！");
		}
	}
	
	//对外提供获取连接对象的方法
	public static Connection getConn()
	{
		try
		{
			//System.out.println("成功获取连接池");
			return dSource.getConnection();
			
		} catch (SQLException e)
		{
			System.out.println("获取连接对象失败！");
		}
		return null;
	}
}
