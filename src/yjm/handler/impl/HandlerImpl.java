package yjm.handler.impl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import yjm.handler.IHandler;

/*
 * 说明：创建结果集处理类，这个实现类也能达到通用的地步
 * 作用：将结果集的数据封装成对象，返回对象的集合
 */
public class HandlerImpl<T> implements IHandler<List<T>>
{

	private Class<T> type;
	public HandlerImpl(Class<T> type)
	{
		this.type = type;
	}
	
	@Override
	public List<T> query(ResultSet resultSet)
	{
		List<T> list = new ArrayList<>();
		try
		{
			//获取属性描述数组
			BeanInfo beanInfo = Introspector.getBeanInfo(type, Object.class);
			PropertyDescriptor[] pDescriptors = beanInfo.getPropertyDescriptors();
			
			//取出结果集数据
			while(resultSet.next())
			{
				T obj = type.newInstance();
				//迭代属性描述器，利用属性描述器将结果集中的一条数据封装到一个对象中
				for (PropertyDescriptor propertyDescriptor : pDescriptors)
				{
					Object value = resultSet.getObject(propertyDescriptor.getName());
					Method method = propertyDescriptor.getWriteMethod();
					method.invoke(obj, value);
				}
				//将封装好的一个对象添加到集合中
				list.add(obj);
			}
		} catch (Exception e)
		{
		}
		return list;
	}
}
