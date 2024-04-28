package Design_Pattern.Adaptor;

public class EmailHelper {
    EmailHelperAdeptor adeptor;

    public EmailHelper(EmailHelperAdeptor adeptor) {
        this.adeptor = adeptor;
    }

    public void sendEmail(String to, String from, String content){
        adeptor.sendMail(to,from,content);
    }
}
