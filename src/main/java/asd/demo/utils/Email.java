/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.utils;
import com.sun.mail.smtp.SMTPTransport;
import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  
  
public class Email {  
// for example, smtp.mailgun.org
    private static final String SMTP_SERVER = "smtp.gmail.com";
    private static final String USERNAME = "Testingasdapp@gmail.com";
    private static final String PASSWORD = "Testing1234";

    private static final String EMAIL_FROM = "Testingasdapp@gmail.com";
    private static final String EMAIL_TO = "email_1@yahoo.com, email_2@gmail.com";
    private static final String EMAIL_TO_CC = "";

    private static final String EMAIL_SUBJECT = "Test Send Email via SMTP";
    private static final String EMAIL_TEXT = "Hello Java Mail \n ABC123";

   static String to;
   static String msg;
    
    public Email(String to,String body){

        Properties prop = System.getProperties();
        prop.put("mail.smtp.host", SMTP_SERVER); //optional, defined in SMTPTransport
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "587"); // default port 25
prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop, null);
        Message msg = new MimeMessage(session);

        try {
		
			// from
            msg.setFrom(new InternetAddress(EMAIL_FROM));

			// to 
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to, false));

	

			// subject
            msg.setSubject(EMAIL_SUBJECT);
			
			// content 
            msg.setText(body);
			

			// Get SMTPTransport
            SMTPTransport t;
            t = (SMTPTransport) session.getTransport("smtp");
			
			// connect
            t.connect(SMTP_SERVER, USERNAME, PASSWORD);
			
			// send
            t.sendMessage(msg, msg.getAllRecipients());

            System.out.println("Response: " + t.getLastServerResponse());

            t.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
}  