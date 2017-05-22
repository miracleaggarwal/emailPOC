package com.test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run
{
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

		MailMail mm = (MailMail) context.getBean("mailMail");
		mm.sendMail("Test Subject", "This is text content");

	}
}
