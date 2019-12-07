package app;

import java.applet.AppletContext;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class MyApplet extends HttpServlet implements ActionListener
{
	 Button b;
     Label l1, l2;
     TextField tf1, tf2;
	
   public void init(ServletConfig config) throws ServletException 
	{
		 l1=new Label("Username");
         l2=new Label("Password");
         tf1=new TextField(11);
         tf2=new TextField(12);
         tf2.setEchoChar('*');
         b=new Button("Submit");
         b.addActionListener(this);
         Font f=new Font("Arial",Font.BOLD,20);;
         l1.setFont(f);
         l2.setFont(f);
         tf1.setFont(f);
         tf2.setFont(f);
         b.setFont(f);
         setBackground(Color.pink);
         add(l1);
         add(l2);
         add(tf1);
         add(tf2);
         add(b);
         
	}
   public void actionPerformed(ActionEvent e)  
   { 
   	try{
           URL u=new URL("http://localhost:1200/apps18/rr?name="+tf1.getText()+"&pass="+tf2.getText());
           AppletContext app=getAppletContext();	//global parameter like that of the ServletContext.
           app.showDocument(u,"servlet"); //name that is used in the frameset code in the main.html file.
           }catch(Exception ee)
                   {
                   ee.printStackTrace();
                   }
   	
   }


}
