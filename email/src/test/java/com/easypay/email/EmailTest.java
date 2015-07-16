package com.easypay.email;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class EmailTest {

	@BeforeClass
	public static void beforeClass() throws Exception{
		EmailHelper.init("email.xml");
	}
	/**
	 * 文本信息
	 * @throws Exception
	 */
	@Test
	public void testTextEmail() throws Exception{
		EmailMessage emailMessage = new EmailMessage();
		emailMessage.setSubject("测试文本信息");
		List<String> to = new ArrayList<String>();
		to.add("734839030@qq.com");
		to.add("573568056@qq.com");
		emailMessage.setTo(to);
		emailMessage.setMsg("我的文本信息");
		EmailHelper.send(emailMessage);
	}
	/**
	 * 测试html信息
	 * @throws Exception 
	 */
	@Test
	public void testHtmlEmail() throws Exception{
		EmailMessage emailMessage = new EmailMessage();
		emailMessage.setType(EmailType.HTML);
		emailMessage.setSubject("测试html信息");
		List<String> to = new ArrayList<String>();
		to.add("734839030@qq.com");
		to.add("573568056@qq.com");
		emailMessage.setTo(to);
		//可以用模板输出
		emailMessage.setHtmlMsg("<b>我是html信息</b>");
		EmailHelper.send(emailMessage);
	}
	/**
	 * 测试抄送信息
	 * @throws Exception 
	 */
	@Test
	public void testCC() throws Exception{
		EmailMessage emailMessage = new EmailMessage();
		emailMessage.setSubject("测试抄送信息");
		List<String> to = new ArrayList<String>();
		to.add("huangdf@easypay.com.hk");
		to.add("573568056@qq.com");
		emailMessage.setTo(to);
		//抄送
		List<String> cc = new ArrayList<String>();
		cc.add("734839030@qq.com");
		emailMessage.setCc(cc);
		//可以用模板输出
		emailMessage.setMsg("测试抄送信息");
		EmailHelper.send(emailMessage);
	}
	/**
	 * 测试密送信息
	 * @throws Exception 
	 */
	@Test
	public void testBcc() throws Exception{
		EmailMessage emailMessage = new EmailMessage();
		emailMessage.setSubject("测试密送信息");
		List<String> to = new ArrayList<String>();
		to.add("huangdf@easypay.com.hk");
		to.add("573568056@qq.com");
		emailMessage.setTo(to);
		//密送
		List<String> bcc = new ArrayList<String>();
		bcc.add("734839030@qq.com");
		emailMessage.setBcc(bcc);
		emailMessage.setMsg("测试密送信息");
		EmailHelper.send(emailMessage);
	}
	/**
	 * 测试附件信息
	 * @throws Exception 
	 */
	@Test
	public void testAttach() throws Exception{
		System.out.println(this.getClass().getResource("/"));
		EmailMessage emailMessage = new EmailMessage();
		emailMessage.setSubject("测试附件信息");
		List<String> to = new ArrayList<String>();
		to.add("huangdf@easypay.com.hk");
		to.add("573568056@qq.com");
		emailMessage.setTo(to);
		emailMessage.setMsg("测试附件信息");
		EmailMessageAttachment attachment = new EmailMessageAttachment();
		//附件描述
		attachment.setDescription("日志文件");
		//附件名称
		attachment.setName("log4j.properties");
		//附件路径
		attachment.setPath(System.getProperty("user.dir") + "/src/main/java/log4j.properties");
		emailMessage.addAttachment(attachment);
		EmailHelper.send(emailMessage);
	}
}
