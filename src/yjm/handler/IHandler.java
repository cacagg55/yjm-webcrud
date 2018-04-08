package yjm.handler;

import java.sql.ResultSet;

/*
 * 说明：创建一个结果集处理接口
 * 作用：规范结果集处理类的设计规范，使用泛型 能够达到通用的地步
 */
public interface IHandler<T>
{
	
	//返回值的类型由实现接口时接口指定
	public T query(ResultSet resultSet);
}
