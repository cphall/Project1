package hall.christian.email;
import hall.christian.email.controllers.EmailController;
import hall.christian.email.models.Mail;
import hall.christian.email.service.EmailService;
import hall.christian.email.service.EmailServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


public class EmailServiceImplTests {
    private EmailServiceImpl emailServiceImpl;
    private EmailService emailService;
    private EmailController emailController;
    private MimeMessage mimeMessage;
    private JavaMailSenderImpl javaMailSender;
    private Mail mailObj;

    @BeforeEach
    public void initBeforeTests(){
        emailService = mock(EmailService.class);
        emailController = mock(EmailController.class);
        emailController.SetEmailServiceImpl(emailServiceImpl);
        mailObj = mock(Mail.class);
        mimeMessage = new MimeMessage((Session) null);
        javaMailSender = mock(JavaMailSenderImpl.class);
        when(javaMailSender.createMimeMessage()).thenReturn(mimeMessage);
        emailServiceImpl = new EmailServiceImpl(javaMailSender);
    }

    @Test
    public void shouldSendEmail(){
        Mail email = new Mail("pwnfest7@gmail.com", "christianphall@gmail.com","Test","This is a test");
        doNothing().when(emailService).send(isA(Mail.class));
        emailService.send(email);

        verify(emailService, times(1)).send(email);
    }

    @Test
    public void sendMailSubjectTest() throws MessagingException {
        String subject = "test";
        Mail mail = new Mail("test@gmail.com", "sender@gmail.com" , subject, "test");
        emailServiceImpl.send(mail);
        String mimeMessageSubject = mimeMessage.getSubject();
        assertEquals(subject, mimeMessageSubject);
    }

    @Test
    public void wontSendEmail(){
        Assertions.assertThrows(NullPointerException.class, () -> {
            doThrow(NullPointerException.class).when(emailService).send(isNull());
            emailService.send(null);
        });
    }

    @Test
    public void shouldFailReturnResponseNullParam() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            when(emailController.acknowledgeReceipt(null)).thenThrow(NullPointerException.class);
            emailController.acknowledgeReceipt(null);
        });
    }

    @Test
    public void shouldReturnToEmail()
    {
        when(mailObj.getTo()).thenReturn("test@gmail.com");
        String test = mailObj.getTo();
        assertNotNull(test);
    }

}
