package utils;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMail {
    public static void main(String[] args) throws Exception {
    }
    // 发送函数
    public static void sendEmail(String id,String code) throws Exception {
        Properties pro = new Properties();
        pro.setProperty("mail.host", "smtp.qq.com");
        pro.setProperty("mail.transport.protocol", "smtp");
        pro.setProperty("mail.smtp.auth", "true");

        Auth auth = new Auth();
        Session session = Session.getDefaultInstance(pro,auth);
        Transport ts = session.getTransport();
        ts.connect("smtp.qq.com","2313100144@qq.com","pzjgthrjzbtyecfg");

        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress("2313100144@qq.com"));
        mimeMessage.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(id));
        mimeMessage.setSubject("购买信息");
        mimeMessage.setContent("卡密信息购买信息如下\n"+code, "text/html;charset=utf-8");
        ts.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        ts.close();

    }
}
