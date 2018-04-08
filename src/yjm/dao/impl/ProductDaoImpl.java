package yjm.dao.impl;

import java.util.List;

import lombok.Getter;
import yjm.dao.IProductDao;
import yjm.domain.Product;
import yjm.handler.impl.HandlerImpl;
import yjm.template.JdbcTemplate;

@Getter
public class ProductDaoImpl implements IProductDao
{

	String savesql = "INSERT INTO product(productName,"
			+ "dir_id,salePrice,supplier,brand,cutoff,costPrice) VALUES(?,?,?,?,?,?,?)";
	String updatesql = "UPDATE product SET productName=?,dir_id=?,salePrice=?,"
			+ "supplier=?,brand=?,cutoff=?,costPrice=? WHERE id=?";
	String deletesql = "DELETE FROM product WHERE id=?";
	@Override
	public void save(Product product)
	{
		JdbcTemplate.save(getSavesql(), product);
	}
	
	@Override
	public void upDate(Product product)
	{
		//System.out.println("成功调用ProductDao的方法");
		JdbcTemplate.upDate(getUpdatesql(), product);
	}

	@Override
	public void delete(Long id)
	{
		//System.out.println("成功调用ProductDao的方法");
		JdbcTemplate.delete(deletesql, id);
	}

	@Override
	public List<Product> query(String sql)
	{
		//System.out.println("成功调用ProductDao的方法");
		//return null;
		return JdbcTemplate.query(sql, new HandlerImpl<Product>(Product.class));
	}

	


}
