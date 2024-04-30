package machine_coding.parking_lot.models;

import java.util.Date;
import java.util.List;

public class Invoice extends BaseModel{
    private Ticket ticket;
    private Date exitTime;
    private double totalAmount;
    private List<InvoiceDetails> details;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    private void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<InvoiceDetails> getDetails() {
        return details;
    }

    public void setDetails(List<InvoiceDetails> details) {
        this.details = details;
        double totalAmount=0;
        for(InvoiceDetails invoiceDetails:details){
            totalAmount+= invoiceDetails.getPrice();
        }
        setTotalAmount(totalAmount);
    }
}
