package franmail.fjarquellada.es.franmail.model;

/**
 * Created by francisco on 25/3/18.
 */

public class Mail {

    private String subject;
    private String body;
    private String mailTo;
    private String color;

    public Mail(String subject, String body, String mailTo) {
        this.subject = subject;
        this.body = body;
        this.mailTo = mailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
