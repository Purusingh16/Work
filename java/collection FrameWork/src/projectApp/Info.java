package projectApp;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Info extends Applet implements ActionListener
{
	ArrayList a1;
    Panel p,pp,p1,p2,s1,s2,s3,s4;
    Label l1,l2,l3,l4;
    TextField tf1,tf2,tf3,tf4;
    TextArea ta,tt;
    Button b1,b2,b3;
    Font f;
    
    public void init()
    {
    setLayout(new BorderLayout());
    p=new Panel();
    pp=new Panel();
    b1=new Button("Insert");
    f=new Font("Arial", Font.BOLD, 20);
    b1.setFont(f);
    b1.addActionListener(this);

    b2=new Button("Retrieve");
    b2.setFont(f);
    b2.addActionListener(this);

    b3=new Button("Search");
    b3.setFont(f);
    b3.addActionListener(this);

    pp.add(b1);
    pp.add(b2);
    pp.add(b3);
    add(pp,BorderLayout.SOUTH);
    add(p);

    p.setLayout(new GridLayout(2,1));  //(row,column)
    p1=new Panel();
    p2=new Panel();

    p1.setLayout(new GridLayout(4,1));
    p.add(p1);
    p.add(p2);

    s1=new Panel();
    l1=new Label("Name");
    l1.setFont(f);
    tf1=new TextField(12);
    tf1.setFont(f);
    s1.add(l1);
    s1.add(tf1);

    s2=new Panel();
    l2=new Label("Roll Number");
    l2.setFont(f);
    tf2=new TextField(12);
    tf2.setFont(f);
    s2.add(l2);
    s2.add(tf2);

    s3=new Panel();
    l3=new Label("Fee");
    l3.setFont(f);
    tf3=new TextField(12);
    tf3.setFont(f);
    s3.add(l3);
    s3.add(tf3);

    s4=new Panel();
    l4=new Label("Search");
    tf4=new TextField(12);
    l4.setFont(f);
    tf4.setFont(f);
    s4.add(l4);
    s4.add(tf4);

    p1.add(s1);
    p1.add(s2);
    p1.add(s3);
    p1.add(s4);

    ta=new TextArea(10,20);  //10rows, each line 20characters
    tt=new TextArea(10,20);
    ta.setFont(f);
    tt.setFont(f);
    ta.setEditable(false);
    tt.setEditable(false);
    p2.add(ta);
    p2.add(tt);

    a1=new ArrayList();
    }

	@Override
	public void actionPerformed(ActionEvent e)
	{
		 if(e.getSource()==b1)
         {
         Student ss=new Student();
         ss.name=tf1.getText();
         ss.roll=Integer.parseInt(tf2.getText());  //return type is string
         ss.fee=Double.parseDouble(tf3.getText());
         a1.add(ss);
         }
 else if(e.getSource()==b2)
         {
         int size=a1.size();
         for(int i=0;i<size;i++)
                  {
                  Student aa=(Student)a1.get(i);
                  ta.append("Name is "+aa.name+"\nRoll Number is "+aa.roll+"\nFee is "+aa.fee);
                  }
         }
 else
         {
         int size=a1.size();
         for(int i=0;i<size;i++)
                 {
                 Student kk=(Student)a1.get(i);
                 if(kk.name.equalsIgnoreCase(tf4.getText()))
                         {
                         tt.append("Name is "+kk.name+"\nRoll number is "+kk.roll+"\nFee is "+kk.fee);
                         }
                 }
         }
 }
		
}


class Student
{
String name;
int roll;
double fee;
}

/*<applet code="Info" width=430 height=430>
</applet>*/

