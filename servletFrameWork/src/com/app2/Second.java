package com.app2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Second extends HttpServlet
        {
        public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
                {
                try{
                res.setContentType("text/html");
                PrintWriter out=res.getWriter();
                HttpSession ses=req.getSession(false);
                String name=(String)ses.getAttribute("uname");  //uname was passed when setAttribute was called.
                String pass=(String)ses.getAttribute("pass");
                out.println("<body bgcolor='pink'><center>Welcome to the 2nd page Mr. "+name);
                out.println("<br><br>Is this your Password? "+pass+" :p ");
                out.println("</center></body>");
                out.close();
                }catch(Exception e)
                        {
                        e.printStackTrace();
                        }
        }
}
