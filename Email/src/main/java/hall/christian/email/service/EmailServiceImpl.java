package hall.christian.email.service;

import hall.christian.email.EmailApplication;
import hall.christian.email.models.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service("mailService")
public class EmailServiceImpl implements EmailService {

    /** This is autowired so that injection can occur for the JavaMailSenderImpl
     */
    private JavaMailSenderImpl emailSender;
    static final Logger logger = LoggerFactory.getLogger(EmailApplication.class);

    public EmailServiceImpl(){}

    @Autowired
    public EmailServiceImpl(JavaMailSenderImpl javaMailSender) {
        this.emailSender = javaMailSender;
    }

    @Override
    /** This method sets up and sends email using the JavaMailSenderImpl and MimeMessage interfaces
     * @param email Object that is received from reimbursement API request
     */
    public void send(Mail email) {
        logger.info("Received email.");
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

                mimeMessageHelper.setSubject(email.getSubject());
                mimeMessageHelper.setFrom(new InternetAddress(email.getFrom(), "Revature"));
                mimeMessageHelper.setTo(email.getTo());
                mimeMessageHelper.setText(email.getMessage());
                logger.info("Email constructed and being sent!");
                emailSender.send(mimeMessageHelper.getMimeMessage());

        }catch (MessagingException e){
            logger.info("Email construction failed: Messaging Exception");
            e.printStackTrace();
        }catch (UnsupportedEncodingException e){
            logger.info("Email construction failed: UnsupportedEncodingException");
            e.printStackTrace();
        }
    }

    @Autowired
    public void setJavaMailSenderImpl(JavaMailSenderImpl jMSI){this.emailSender = jMSI;}
}
