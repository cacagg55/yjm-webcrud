package yjm.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcUtil
{
	/*
	 * 因为使用连接池了就只需要JdbcUtil的关流方法
	 */
	//每次进行增删改查操作后都要释放资源，费事但是还必须得写，提取出一个关闭资源的方法
	public static void close(Connection connection, Statement statement, ResultSet resultSet)
	{
		try
		{
			if(resultSet != null)
			{
				resultSet.close();
			}
		} catch (Exception e1)
		{
			
		}finally {
			try
			{
				if(connection != null)
				{
					connection .close();
				}
			} catch (Exception e2)
			{
				
			}finally {
				try
				{
					if(statement != null)
					{
						statement.close();
					}
				} catch (Exception e3)
				{
					
				}
			}
		}
	}

}
