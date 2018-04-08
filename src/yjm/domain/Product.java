package yjm.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Product
{
	/*
	 * 说明：设计product数据封装类
	 * 作用：用于将数据库中的数据封装成product类型，符合面向对象的设计思想，方便数据的操作
	 */
	
	private Long id;
	private String productName;
	private Long dir_id;
	private Double salePrice;
	private String supplier;
	private String brand;
	private Double cutoff;
	private Double costPrice;
	
	public Product()
	{
		super();
	}

	public Product(Long id, String productName, Long dir_id, 
			Double salePrice, String supplier, String brand,
			Double cutoff, Double costPrice)
	{
		super();
		this.id = id;
		this.productName = productName;
		this.dir_id = dir_id;
		this.salePrice = salePrice;
		this.supplier = supplier;
		this.brand = brand;
		this.cutoff = cutoff;
		this.costPrice = costPrice;
	}
	
	
	
}
