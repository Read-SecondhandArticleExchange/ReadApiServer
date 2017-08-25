package Read.Domain.Main;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Read.Domain.Book.Book;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	MainMapper mainMapper;

	@Override
	public Summary getSummary() {
		return mainMapper.getSummary();
	}

	@Override
	public ArrayList<Book> getRecentBookList() {
		return mainMapper.getRecentBookList();
	}

	@Override
	public void sendMail(String address, String name, String phone, String contents) throws Exception {
		String host = "smtp.worksmobile.com";
		final String user = "ceo@app-read.me";
		final String password = "rpo920617";
		String port = "587";
		String fromAddress = address;
		String toAddress = "ceo@app-read.me";
		String mailSubject = name + " / " + phone + "님이 보내신 메일입니다.";
		String MailContents = contents;

		Properties props = new Properties();

		// smtp에 필요한 인증부
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", host);
		props.put("mail.smtp.auth", "true");

		// 호스트 / 포트
		props.put("mail.smtp.host", host);
		if (port != null) {
			props.put("mail.smtp.port", port);
			props.put("mail.smtp.socketFactory.port", port);
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		}

		// 인증을 포함한 메시지 만들기
		Message msg = new MimeMessage(Session.getInstance(props, new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		}));

		msg.setFrom(new InternetAddress(fromAddress));
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));

		// Subject
		msg.setSubject(mailSubject);

		// Text
		msg.setText(MailContents);

		// send the message
		Transport.send(msg);
	}

}
