package model.Mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class ToStringTest {
private static String test1 = "";

	public static void main(String[] args) {
		
		test1 = "iskam nov red\nnadqvam se tova da\n\nraboti";
		StringBuffer sb = new StringBuffer();
		sb.append("Sehr geehrte Herren,\n\n");
		sb.append("Wir haben eine neue Bestellung fьr Sie erstellt.\n\n");
		sb.append("Hier kommt den Textkцrper der Bestellung;/nDies ist ein Test!");
		String test2 = "Sehr geehrte Damen und Herren,\n" + 
				"Wir haben eine neue Bestellung fьr Sie erstellt.\n" + 
				"Hier kommt den Text der Bestellung /n Dies ist ein Test!";
		
		//System.out.println(test1);
		//System.out.println(test2);
		
		String username ="winfprojekt"; 
		String password ="Hftboys2.0";
		Properties mailProperty = new Properties();
		mailProperty.put("mail.smtp.auth", "true");
		mailProperty.put("mail.smtp.starttls.enable", "true");
		mailProperty.put("mail.smtp.host", "smtp.mail.yahoo.com");
		mailProperty.put("mail.smtp.port", "587");

		Session session = Session.getInstance(mailProperty, new javax.mail.Authenticator()  {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(username, password);
			}
		});
		
		MimeMessage msg = new MimeMessage(session);
		
		final String senderPlaceholder = "winfprojekt@yahoo.com";				
		//System.out.println("\nCurrent classloader chain: "+JavaEETrainingUtill.getCurrentClassLoaderDetail(););
		try {
			msg.setFrom(senderPlaceholder);
			msg.addRecipients(Message.RecipientType.TO, "winfprojekt@yahoo.com");
			msg.setSubject("Neue Lieferbestellung für HighSpeedProcurement");
			//msg.setText(test2);
			msg.setContent(msg, "text/plain; charset=UTF-8");
			Transport.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		
	}
}
