package com.test.main;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailMail
{
	private JavaMailSender mailSender;

	public void setMailSender(JavaMailSender mailSender)
	{
		this.mailSender = mailSender;
	}

	public void sendMail(String subject, String content)
	{
		try
		{
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom("sashu@garretsongroup.com");
			helper.setTo(new String[] { "ashu.sushant@gmail.com" });
			helper.setSubject(subject);
			helper.setText(content);

			FileSystemResource file = new FileSystemResource("/home/ubuntu/test.txt");
			helper.addAttachment(file.getFilename(), file);
			mailSender.send(message);

		}
		catch (MessagingException e)
		{
			throw new MailParseException(e);
		}
	}
}
