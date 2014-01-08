import java.util.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
//javamail-1.4.7 ,add path:mail.jar
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

//change java compiler warning
import java.security.Security;

/**
 * Send email(including diagram) to user.<br/>
 * (Need to close your anti-virus software)
 * 
 * @author j9988t
 */
public class Mail {
	// mail address of user
	private String toMailAddr;
	// mail account of LnOS group3
	private String fromMailAccount = "lnos.group3";
	// password of LnOS group3
	private String passwd = "opensourceG3";
	private String subject = "LnOS Group3";
	private String content = "mail test";

	Properties props = new Properties();

	// set fromMailAccount & password
	Session session = Session.getDefaultInstance(props, new Authenticator() {
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(fromMailAccount, passwd);
		}
	});

	/**
	 * Constructor of Mail
	 * 
	 * @author j9988t
	 * @param addr
	 */
	public Mail(String addr) {
		this.toMailAddr = addr;
	}

	/**
	 * Set SMTP.
	 * 
	 * @author j9988t
	 */
	@SuppressWarnings("restriction")
	public void InitialSet() {
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		// need SMTP to test and verify
		props.setProperty("mail.smtp.auth", "true");
		// Simple Mail Transfer Protocol(SMTP)
		props.setProperty("mail.transprot.protocal", "smtp");
		// SMTP address
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		session.setDebug(false);
	}// end of InitialSet()

	/**
	 * Set mail & message content.
	 * 
	 * @author j9988t
	 * @throws MessagingException
	 * @throws AddressException
	 */
	public void Msg() throws AddressException, MessagingException {
		Message msg = new MimeMessage(session);
		// set LnOS group3 mail address
		msg.setFrom(new InternetAddress(fromMailAccount));
		// set user's mail address
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMailAddr, false));
		// set mail subject
		msg.setSubject(subject);
		// set mail time
		msg.setSentDate(new Date());

		// in mail
		MimeMultipart mainPart = new MimeMultipart();
		MimeBodyPart contentPart = new MimeBodyPart();
		MimeBodyPart dataPart = new MimeBodyPart();
		// set content
		contentPart.setText(content);
		// add content part
		mainPart.addBodyPart(contentPart);
		// set attached file
		DataSource dataSource = new FileDataSource("print.jpg");
		DataHandler dataHandler = new DataHandler(dataSource);
		dataPart.setDataHandler(dataHandler);
		dataPart.setFileName("Chart.jpg");
		// add data part
		mainPart.addBodyPart(dataPart);
		// save mail
		msg.setContent(mainPart);
		msg.saveChanges();
		// send mail
		Transport.send(msg);
		System.out.println("Sending mail to " + toMailAddr + " is done.");
	}// end of Msg()

}// end of class Mail