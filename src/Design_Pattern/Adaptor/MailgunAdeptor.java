package Design_Pattern.Adaptor;

import Design_Pattern.Adaptor.library.MailGun;

public class MailgunAdeptor implements EmailHelperAdeptor{
    MailGun client= new MailGun();
    @Override
    public void sendMail(String to, String from, String content) {
        client.send(to,from,content,null,null);
    }
}
