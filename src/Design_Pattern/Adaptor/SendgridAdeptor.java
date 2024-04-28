package Design_Pattern.Adaptor;

import Design_Pattern.Adaptor.library.SendGrid;

public class SendgridAdeptor implements EmailHelperAdeptor{
    SendGrid client=new SendGrid();
    public void sendMail(String to, String from, String content) {
        client.sendemail(content,to,from,null,null);
    }
}
