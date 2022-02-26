package hall.christian.email.service;
import hall.christian.email.models.Mail;
import org.springframework.stereotype.Component;

@Component
public interface EmailService {
    public void send(Mail email);
}
