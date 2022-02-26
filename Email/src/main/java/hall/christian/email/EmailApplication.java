package hall.christian.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@SpringBootApplication
public class EmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailApplication.class, args);
    }

    /*@Bean
    public JavaMailSenderImpl emailSender(){
        JavaMailSenderImpl emailSender = new JavaMailSenderImpl();

        return emailSender;
    }*/
}
