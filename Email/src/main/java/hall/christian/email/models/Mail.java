package hall.christian.email.models;

public class Mail {
    private String to;
    private String from;
    private String subject;
    private String message;

    public Mail(){}

    /** Parameterized constructor for an email
     * @param to the address we are sending to
     * @param from the address we are sending from
     * @param subject the email subject line
     * @param message the text contents of the email
     */
    public Mail(String to, String from, String subject, String message){
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.message = message;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
