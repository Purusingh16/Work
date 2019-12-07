package project;
import java.applet.Applet;
import java.awt.*;

public class Move extends Applet implements Runnable
        {
        Thread t;
        int x;
        public void init()  //override the method of applet
                {
                setBackground(Color.cyan);
                }

        public void start()  //applet class start. thread class start() is final and cannot overridden. when applet is minimized, stop() is called. when maximized, start() is called.
                {
                t=new Thread(this);
                t.start();
                }
        public void stop()  //when minimized
                {
                t.stop(); //thread is killed.
                t=null;  //means it doesnot point to that object anymore.
                }

        public void run()
                {
                while(true)
                        {
                        for(x=0;x<getSize().width;x+=18)  //each time, 18px is changed along x-axis
                                {
                                repaint();  //calls the paint() after some time interval.
                                try{
                                Thread.sleep(200);
                                }catch(InterruptedException e){}
                                }
                        }
                }

        public void paint(Graphics g)
                {
                g.setColor(Color.red);
                g.fillOval(x,200,100,100);
                }
        }

/*<applet code="Move" width=400 height=300>
</applet>*/
