package yjm.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yjm.dao.IProductDao;
import yjm.dao.impl.ProductDaoImpl;
import yjm.domain.Product;

@WebServlet("/product/servlet")
public class ProductServlet extends HttpServlet
{

	/**
	 * 
	 */
	IProductDao productdao = new ProductDaoImpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
	{
		//设置请求参数编码格式
		req.setCharacterEncoding("UTF-8");
		//获取指令标志参数
		String flag = req.getParameter("flag");
		
		//负责处理点击“新增”
		if("savejsp".equals(flag))
		{
			//跳转到编辑界面
			req.getRequestDispatcher("/WEB-INF/jsp/update.jsp").forward(req, resp);
		}
		//负责处理点击“编辑”
		else if("updatejsp".equals(flag))
		{
			//获取编辑的信息并封装成数据对象，将数据对象添加到请求共享域中，请求转发到边界界面，编辑界面能够显示当前编辑对象的信息
			Product product = getProduct(Long.parseLong(req.getParameter("id")));
			System.out.println(product);
			req.setAttribute("product", product);
			req.getRequestDispatcher("/WEB-INF/jsp/update.jsp").forward(req, resp);	
		}
		//新增和编辑够用一个jsp页面，负责处理页面提交后的操作
		else if("update".equals(flag))
		{
			//判断请求参数“id”是否为null，null保存操作，不是null更新操作
			if(null == req.getParameter("id"))
			{
				//调用保存操作
				save(req);
				resp.sendRedirect("/product/servlet");
			}
			else
			{
				//调用更新操作
				update(req);
				resp.sendRedirect("/product/servlet");
			}
		}
		//负责处理删除操作
		else if("delete".equals(flag))
		{
			//删除
			productdao.delete(Long.parseLong(req.getParameter("id")));
			resp.sendRedirect("/product/servlet");
		}
		//负责处理默认操作
		else
		{
			//默认查询
			String sql = "SELECT * FROM product";
			List<Product> list = productdao.query(sql);
			req.setAttribute("lists", list);
			req.getRequestDispatcher("/WEB-INF/jsp/productview.jsp").forward(req, resp);
			
		}
	}
	
	//保存方法
	protected void save(HttpServletRequest req)
	{
		Product product = new Product(
				null, 
				req.getParameter("productName"), 
				Long.parseLong(req.getParameter("dir_id")), 
				Double.parseDouble(req.getParameter("salePrice")), 
				req.getParameter("supplier"), 
				req.getParameter("brand"), 
				Double.parseDouble(req.getParameter("cutoff")), 
				Double.parseDouble(req.getParameter("costPrice")));
		productdao.save(product);
	}
	
	//更新方法
	protected void update(HttpServletRequest req)
	{
		Product product = new Product(
				Long.parseLong(req.getParameter("id")), 
				req.getParameter("productName"), 
				Long.parseLong(req.getParameter("dir_id")), 
				Double.parseDouble(req.getParameter("salePrice")), 
				req.getParameter("supplier"), 
				req.getParameter("brand"), 
				Double.parseDouble(req.getParameter("cutoff")), 
				Double.parseDouble(req.getParameter("costPrice")));
		productdao.upDate(product);
	}
	
	//获取需要编辑的那个数据的封装对象
	protected Product getProduct(Long id)
	{
		String sql = "SELECT * FROM product WHERE id="+id;
		return productdao.query(sql).get(0);
		//return null;
	}
	
}
