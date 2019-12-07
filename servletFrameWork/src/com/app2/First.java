package com.app2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class First extends HttpServlet
        {
        public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
                {
                try{
                res.setContentType("text/html");
                PrintWriter out=res.getWriter();
                String name=req.getParameter("name");
                String pass=req.getParameter("pass");
                String email=req.getParameter("email");
                out.println("<body bgcolor='yellow'><center>Welcome to Mozilla Firefox");
                out.println("<b> Mr. "+name+"<br><br>");
                HttpSession ses=req.getSession();
                ses.setAttribute("uname",name);
                ses.setAttribute("pass",pass);
                out.println("<a href='servlet2'>click me</a>");
                out.println("</center></body>");
                out.close();
                }catch(Exception e)
                        {
                        e.printStackTrace();
                        }
                }
        }

