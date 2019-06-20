package model.Mail;

import java.text.Collator;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class MailService {
	private String text; // Inhalt
	private String bestellungsUUID;
	private String absender; // Mail adresse
	private String empfanger; // Mail adresse

	// Konstruktor
	public MailService(String text, String bestellungsUUID, String empfanger) {
		super();
		this.text = text;
		this.bestellungsUUID = bestellungsUUID;
		this.empfanger = empfanger;
	}

	// Getter+Setter
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getBestellungsID() {
		return bestellungsUUID;
	}

	public void setBestellungsID(String bestellungsUUID) {
		this.bestellungsUUID = bestellungsUUID;
	}

	public String getAbsender() {
		return absender;
	}

	public void setAbsender(String absender) {
		this.absender = absender;
	}

	public String getEmpfanger() {
		return empfanger;
	}

	public void setEmpfanger(String empfanger) {
		this.empfanger = empfanger;
	}

	// zusдtzliche Logik

	public void write() {

		// Den Email String in einer dafьr vorhergesehenen Box ausgeben
	}

	public String readUpdated() {
		String updatedText = "";
		Collator myCollator = Collator.getInstance();
		if (myCollator.equals(text, this.text)) {
			updatedText = text;
		} else {
			updatedText = this.text;
		}
		return updatedText;
	}

	public void send() {
		/*
		 * Man braucht von der zweiter Quelle javax.mail.jar;
		 * 
		 * Quellen: https://www.youtube.com/watch?v=pPdnxc754Dg
		 * https://github.com/eclipse-ee4j/javamail/releases
		 * https://confluence.hft-stuttgart.de/display/DFST/Exchange+access+data
		 */

		String username = "winfprojekt"; // Hier habe ich unser Yahoo-Mail genutzt, falls wir keine E-Mail Struktur
											// vorhanden haben.
		String password = "Hftboys2.0";
		Properties mailProperty = new Properties();
		mailProperty.put("mail.smtp.auth", "true");
		mailProperty.put("mail.smtp.starttls.enable", "true");
		mailProperty.put("mail.smtp.host", "smtp.mail.yahoo.com");
		mailProperty.put("mail.smtp.port", "587");

		Session session = Session.getInstance(mailProperty, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(username, password);
			}
		});

		MimeMessage msg = new MimeMessage(session);
		final String senderPlaceholder = "winfprojekt@yahoo.com"; // alternativ implementierbar mit der definierte
																	// String absender - wir brauchen aber tatsдchlich
																	// reale adresse.

		try {
			msg.setFrom(senderPlaceholder);
			msg.addRecipients(Message.RecipientType.TO, senderPlaceholder);
			msg.addRecipients(Message.RecipientType.CC, "winfprojekt@yahoo.com");
			msg.setSubject("Neue Lieferbestellung für HighSpeedProcurement");
			msg.setText(this.getText());
			Transport.send(msg);
			// Optional: einen extra pop-up-Fenster implementieren, e.g. mit "E-Mail
			// abgesendet"
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}