package Design_Pattern.Adaptor.library;

public class MailGun {
    public void send(String to, String from, String content, String[]cc, String[]bcc){
        System.out.println("send email vis mailgun");
    }
}
