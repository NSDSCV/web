package web.com.filtr;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 */
@WebFilter(urlPatterns = "/home1/*")
public class HomeFiltr implements Filter {

    /**
     * Default constructor. 
     */
    public HomeFiltr() {
        // TODO Auto-generated constructor stub
    }


    /**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	System.out.println("¹ýÂË³É¹¦");
	HttpServletRequest req = (HttpServletRequest) request;
	HttpServletResponse res = (HttpServletResponse) response;
	HttpSession session = req.getSession();
	System.out.println("ssession£º"+session.getAttribute("user"));
	if (session.getAttribute("user")==null) {
		res.sendRedirect("/web/user/login.jsp");
	}
		chain.doFilter(request, response);
	}

}
