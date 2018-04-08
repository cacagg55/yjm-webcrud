package yjm.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import yjm.domain.Product;
import yjm.utils.DruidUtil;
import yjm.dao.IProductDao;
import yjm.dao.impl.ProductDaoImpl;



public class ProductTest
{
	
	//测试Product类定义是否规范
	@Test
	public void Product()
	{
		Product product = new Product();
		product.setId(1L);
		product.setProductName("测试");
		System.out.println(product);
	}
	
	IProductDao productDao = new ProductDaoImpl();
	//测试ProductDao的save方法
	@Test
	public void testsave()
	{
		Product product = new Product();
		product.setProductName("我是测试");
		productDao.save(product);
	}
	//测试ProductDao的upDate方法
	@Test
	public void testupDate()
	{
		Product product = new Product();
		product.setId(21L);
		product.setProductName("我是测试4");
		product.setCostPrice(7879.09);
		productDao.upDate(product);
	}
	
	//测试ProductDao的delete方法
	@Test
	public void testdelete()
	{
		productDao.delete(21L);
	}
	
	//测试ProductDao的query方法
	@Test
	public void testquery()
	{
		//productDao.query();
		String sql = "SELECT * FROM product";
		List<Product> list = productDao.query(sql);
		for (Product product : list)
		{
			System.out.println(product);
		}
	}
	
	//测试连接池工具创建是否成功
	@Test
	public void testgetConn()
	{
		try
		{
			Connection connection = DruidUtil.getConn();
			connection.close();
		} catch (SQLException e)
		{
		}
	}
}
