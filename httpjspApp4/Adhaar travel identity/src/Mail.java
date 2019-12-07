import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class Mail 
{
 public static void sendMail(String adminusername,String adminpassword,String adminmailid,String msg)
    {
        try
        {
			
			
            String host = "smtp.gmail.com";
		
	
            String adminus =adminusername;
	
	
            String adminpasword =adminpassword;
            Properties props = System.getProperties();
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.user",adminus );
            props.put("mail.smtp.password",adminpasword);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
			
		
            String[] to = {adminmailid};

            Session session = Session.getDefaultInstance(props, null);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(adminus));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i=0; i < to.length; i++ ) 
            { // changed from a while loop
                toAddress[i] = new InternetAddress(to[i]);
            }
            System.out.println(Message.RecipientType.TO);

            for( int i=0; i < toAddress.length; i++) 
            {// changed from a while loop
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }
            message.setSubject("sending in a group");
		
		
            message.setText(msg);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, adminus,adminpasword);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }
}
