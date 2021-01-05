package web.com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import sun.awt.RepaintArea;
import web.com.dao.ArticleDao;
import web.com.entity.Article;
import web.com.entity.User;
import web.com.service.ArticleService;
import web.com.until.FileImage;

/**
 * Servlet implementation class ArticleServlet
 */
@WebServlet({"/home/index.do"})
@MultipartConfig
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticleDao dao = new ArticleDao();
    ArticleService service = new ArticleService();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArticleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		if (request.getParameter("op") != null) {
			String op = request.getParameter("op");
			if (op.equals("add")) {
				addBlog(request, response);
			}
		}else {
			getBlog(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * 查询
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getBlog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String name = "";
		
		if (request.getParameter("name") != null) {
		name = request.getParameter("name");
		}
		System.out.println(name);
		List<Article> list = dao.getAllArticle(name);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/home/index.jsp").forward(request, response);
	}

	/**
	 * 新增
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addBlog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		//自定义类处理存储文件
		FileImage fileImage = new FileImage();
		Part part = request.getPart("myfile");
		String fileName = "0";
         System.out.println("测试数据结果："+(part.getSubmittedFileName().equals("")));
         //如果part.getSubmittedFileName()为“” 就不继续执行储存工具类 防止 取后缀报错 
         if(!part.getSubmittedFileName().equals("")){
			 fileName = fileImage.getFileName(request,part);
		 }

		String name = request.getParameter("name");
		String text = request.getParameter("blogText");

		User user = (User)request.getSession().getAttribute("user");

		System.out.println(user.getId());
		Article article = new Article(name,text,user.getId(),fileName);

		int a = 1;
		a= service.articleAdd(article);
		if (a>0) {
			response.sendRedirect("/web/home/index.do");
		}
	}

}
