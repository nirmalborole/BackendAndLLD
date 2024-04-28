package Design_Pattern.Adaptor;

public class clients {
    public static void main(String[] args) {
        EmailHelper emailHelper= new EmailHelper(new MailgunAdeptor());
        emailHelper.sendEmail("Nirmal@com","scaler@com","done!");
    }
}
