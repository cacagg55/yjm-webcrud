package yjm.dao;

import java.util.List;
import yjm.domain.Product;

public interface IProductDao
{
	/*
	 * 	设计product数据封装类的数据访问接口
	 * 	
	 * 	增、删、改、查
	 */
	//增
	void save(Product product);
	
	//改
	void upDate(Product product);
	
	//删
	void delete(Long id);
	
	//查
	List<Product> query(String sql);
}
