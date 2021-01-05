package web.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import web.com.entity.Article;
import web.com.entity.User;
import web.com.service.ArticleService;
import web.com.service.UserService;
import web.com.until.LayuiJson;
import web.com.until.PageData;

/**
 * 本类处理ajax请求
 * 添加 查询 修改 删除等
 */
@WebServlet("/BlogAjax")
public class BlogAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
      ArticleService service = new ArticleService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogAjax() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    //请求判断方法待添加
/**
 * 对请求进行判断 分别完成对应方法使用
 */
    
    
	/**
	 * @param request response
	 * ajax   发送数据
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置请求的编码格式
		request.setCharacterEncoding("utf-8");
		//设置响应的数据格式 编码格式
		response.setContentType("appection/json;charset=utf-8");
		//页码
		int pageNum  = 1;
		//总数
		int totalCount = 0;
		//当前页的数据个数
		int pageSize = 10;
		pageNum = Integer.parseInt(request.getParameter("pageNum"));
		pageSize = Integer.parseInt(request.getParameter("pageSize"));
		PageData<Article> pageData = service.getUserAll("",pageNum,pageSize);
		totalCount = pageData.getTotalCount();
		Gson gson = new Gson();
		LayuiJson<Article> layuiJson = new LayuiJson<Article>();
		layuiJson.setCode(0);
		layuiJson.setCount((long) totalCount);
		layuiJson.setData(pageData.getList());
		layuiJson.setMsg("");
		//使用GSON 把list转化为json格式的string
		String str = gson.toJson(layuiJson);
		PrintWriter pw = response.getWriter();
		//发送数据

		pw.print(str);
		request.setAttribute("pageNum",pageNum);
		request.setAttribute("pageSize",pageSize);
		System.out.println(str);
	}

	/**
	 * post请求
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
