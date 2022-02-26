package hall.christian.email.controllers;

import hall.christian.email.EmailApplication;
import hall.christian.email.models.Mail;
import hall.christian.email.service.EmailService;
import hall.christian.email.service.EmailServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("email")
public class EmailController {

    @Autowired
    /** This is autowired so that injection can occur for the EmailServiceImpl we are using to call send() below
     */
    private EmailServiceImpl emailService;
    static final Logger logger = LoggerFactory.getLogger(EmailApplication.class);

    @PostMapping
    /** This method receives an object from first API and sends out an email based on the info
     * @param message Object that is received from reimbursement API request
     * @return ResponseEntity
     */
    public ResponseEntity acknowledgeReceipt(@RequestBody List<String> message){
        logger.info("Received message " + message);
        if (message != null){
            Mail email = new Mail(message.get(0),"christian.h@revature.net",message.get(1),message.get(2));
            logger.info("Email object created from response body, sending email through email service...");
            emailService.send(email);
            return ResponseEntity.accepted().build();
        }
        //start thread to send email message elsewhere based on message we received (should have all mail model data from reimbursement api)
        //return accepted (202, accepted but processing later)
        return ResponseEntity.notFound().build();
    }

    public void SetEmailServiceImpl(EmailServiceImpl emailService){this.emailService = emailService;}
}
