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
 * ���ദ��ajax����
 * ��� ��ѯ �޸� ɾ����
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
    
    //�����жϷ��������
/**
 * ����������ж� �ֱ���ɶ�Ӧ����ʹ��
 */
    
    
	/**
	 * @param request response
	 * ajax   ��������
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��������ı����ʽ
		request.setCharacterEncoding("utf-8");
		//������Ӧ�����ݸ�ʽ �����ʽ
		response.setContentType("appection/json;charset=utf-8");
		//ҳ��
		int pageNum  = 1;
		//����
		int totalCount = 0;
		//��ǰҳ�����ݸ���
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
		//ʹ��GSON ��listת��Ϊjson��ʽ��string
		String str = gson.toJson(layuiJson);
		PrintWriter pw = response.getWriter();
		//��������

		pw.print(str);
		request.setAttribute("pageNum",pageNum);
		request.setAttribute("pageSize",pageSize);
		System.out.println(str);
	}

	/**
	 * post����
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
