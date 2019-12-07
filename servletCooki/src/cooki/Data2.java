package cooki;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Data2
 */
public class Data2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        Cookie kk[]=req.getCookies();
        for(int i=0;i<kk.length;i++)
                {
                out.println("<b>Value is: "+kk[i].getValue()+"</b>");
                }
	}

}
