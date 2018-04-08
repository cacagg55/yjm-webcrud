package yjm.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import yjm.domain.Product;
import yjm.handler.impl.HandlerImpl;
import yjm.utils.DruidUtil;
import yjm.utils.JdbcUtil;

/*
 * 说明：创建jdbc的SQL语句执行模板
 * 作用：提取重复代码抽取成模板，减少代码量，降低耦合性
 */
public class JdbcTemplate
{
	//查询模板
	public static<T> List<T> query(String sql, HandlerImpl<T> handler)
	{
		try
		{
			Connection connection = DruidUtil.getConn();
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet resultSet = pStatement.executeQuery();
			return handler.query(resultSet);
		} catch (SQLException e)
		{
			
		}
		return null;
	}
	
	//填加模板
	public static void save(String sql, Product product)
	{
		Connection connection = null;
		PreparedStatement pStatement = null;
		try
		{
			connection = DruidUtil.getConn();
			pStatement = connection.prepareStatement(sql);
			pStatement.setObject(1, product.getProductName());
			pStatement.setObject(2, product.getDir_id());
			pStatement.setObject(3, product.getSalePrice());
			pStatement.setObject(4, product.getSupplier());
			pStatement.setObject(5, product.getBrand());
			pStatement.setObject(6, product.getCutoff());
			pStatement.setObject(7, product.getCostPrice());
			pStatement.executeUpdate();
			
		} catch (SQLException e)
		{
			JdbcUtil.close(connection, pStatement, null);
		}
	}
	
	//更新模板
	public static void upDate(String sql, Product product)
	{
		Connection connection = null;
		PreparedStatement pStatement = null;
		try
		{
			connection = DruidUtil.getConn();
			pStatement = connection.prepareStatement(sql);
			pStatement.setObject(1, product.getProductName());
			pStatement.setObject(2, product.getDir_id());
			pStatement.setObject(3, product.getSalePrice());
			pStatement.setObject(4, product.getSupplier());
			pStatement.setObject(5, product.getBrand());
			pStatement.setObject(6, product.getCutoff());
			pStatement.setObject(7, product.getCostPrice());
			pStatement.setObject(8, product.getId());
			pStatement.executeUpdate();
			
		} catch (SQLException e)
		{
			JdbcUtil.close(connection, pStatement, null);
		}
	}
	
	//删除模板
	public static void delete(String sql, Long id)
	{
		Connection connection = null;
		PreparedStatement pStatement = null;
		try
		{
			connection = DruidUtil.getConn();
			pStatement = connection.prepareStatement(sql);
			pStatement.setObject(1, id);
			pStatement.executeUpdate();
			
		} catch (SQLException e)
		{
			JdbcUtil.close(connection, pStatement, null);
		}
	}

}
