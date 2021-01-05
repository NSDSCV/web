package web.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.google.gson.Gson;
import web.com.dao.ArticleDao;
import web.com.entity.Article;
import web.com.entity.User;
import web.com.service.ArticleService;
import web.com.service.UserService;
import web.com.until.FileImage;
import web.com.until.LayuiJson;
import web.com.until.PageData;

/**
 * ���Ʋ� Servlet �û�servlet ��ͨ��ת��
 */
@WebServlet({ "/user/user.do" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticleDao dao = new ArticleDao();
	ArticleService service = new ArticleService();
	UserService userservice = new UserService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
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

	/**
	 * get����
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("op") != null) {
			String op = request.getParameter("op");
			if (op.equals("add")) {
				addUser(request, response);
			} else if (op.equals("login")) {
				login(request, response);
			} else if (op.equals("showUserList")) {

			} else if (op.equals("reg")) {
				addUser(request, response);
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * ��ѯ
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String name = "";

		if (request.getParameter("name") != null) {
			name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
		}
		System.out.println(name);
		List<Article> list = dao.getAllArticle(name);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/home/index.jsp").forward(request, response);
	}

	/**
	 * ���� ע���˺�ʹ��
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String username = "";
		String password = "";
		String name = "";
		String reg = "0";
		if (request.getParameter("username") != null) {
			username = request.getParameter("username");
			name = request.getParameter("name");
			password = request.getParameter("password");
			System.out.println(reg);
			// �ж��ǲ��ǹ���ԱȨ�� 0��ͨ�˺� 1����Ա�˺�
			if (request.getParameter("regUser") != null) {
				reg = "1";
				System.out.println(reg);
			}
			System.out.println(reg);
			System.out.println("username:" + username + "-----------------" + "password:" + password);
			userservice.regUser(name, username, password, reg);
		}

	}

	/**
	 * ��¼�ж�
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.setCharacterEncoding("UTF-8");
//		request.setCharacterEncoding("UTF-8");
		String username = "";
		String password = "";
		if (request.getParameter("username") != null) {
			username = request.getParameter("username");
			password = request.getParameter("password");
//			System.out.println(username);
//			System.out.println(password);
		}
		User user = userservice.login(username, password);
		HttpSession session = request.getSession();
		if (user != null) {
			if (request.getParameter("ck") != null) {
				// �洢cookie
				Cookie cookie = new Cookie("username", username);
				cookie.setMaxAge(3600);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
			session.setAttribute("user", user);

			// ��֤ͨ��������index
			response.sendRedirect("/web/home/index.do");
		} else {
			response.sendRedirect("/user/login.jsp");
//			request.setAttribute("user", user);
//			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	/**
	 * ��ѯ��ҳģ��
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getPageUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		// ������Ӧ�����ݸ�ʽ �����ʽ
		response.setContentType("appection/json;charset=utf-8");
		// ҳ��
		int pageNum = 1;
		// ����
		int totalCount = 0;
		// ��ǰҳ�����ݸ���
		int pageSize = 10;
		pageNum = Integer.parseInt(request.getParameter("pageNum"));

		pageSize = Integer.parseInt(request.getParameter("pageSize"));
		String name = "";
		if (request.getParameter("name") != null) {
			name = request.getParameter("name");
		}
		System.out.println("�Զ��������Ϣ name  =  " + name);
		PageData<User> pageData = userservice.getUserAll(name, pageNum, pageSize);
		totalCount = pageData.getTotalCount();

		Gson gson = new Gson();
		LayuiJson<User> layuiJson = new LayuiJson<User>();
		layuiJson.setCode(0);
		layuiJson.setCount((long) totalCount);
		layuiJson.setData(pageData.getList());
		layuiJson.setMsg("");
		// ʹ��GSON ��listת��Ϊjson��ʽ��string
		String str = gson.toJson(layuiJson);
		PrintWriter pw = response.getWriter();
		// ��������
		pw.print(str);
	}

}
