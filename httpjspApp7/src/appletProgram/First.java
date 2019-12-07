package appletProgram;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class First extends Applet implements ActionListener
{
	 Button b1,b2;
     Font f;

     public void init()
             {
             f=new Font("Arial",Font.BOLD,20);
             b1=new Button("Red");
             b2=new Button("Green");
             b1.addActionListener(this);
             b2.addActionListener(this);
             b1.setFont(f);
             b2.setFont(f);
             add(b1);
             add(b2);
             }

     public void actionPerformed(ActionEvent ae)
             {
             if(ae.getSource()==b1)
                     {
                     setBackground(Color.red);
                     }
             else
                     {
                     setBackground(Color.green);
                     }
             }

}
