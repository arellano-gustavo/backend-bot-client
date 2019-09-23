package mx.gob.impi.chatbot.persistence.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

//@Configuration 
public class MailConfig {
/*
    @Value("${mail.protocol}")
    private String protocol;
    
    @Value("${mail.starttls.enable}")
    private boolean starttls;
    
    @Value("${mail.host}")
    private String host;
    
    
    @Value("${mail.username}")
    private String username;
    
    @Value("${mail.password}")
    private String password;
    
    @Value("{mail.smtp.auth}$")
    private boolean smtpAuth;
*/
    @Value("${mail.port}")
    private int port;
/*
    @Bean
    public JavaMailSender javaMailService() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(port);

        javaMailSender.setJavaMailProperties(getMailProperties());

        return javaMailSender;
    }

    private Properties getMailProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.debug", "false");
        return properties;
    }*/
}