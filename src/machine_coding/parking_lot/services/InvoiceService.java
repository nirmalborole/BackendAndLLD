package machine_coding.parking_lot.services;

import machine_coding.parking_lot.Exceptions.InvalidTicketException;
import machine_coding.parking_lot.Exceptions.InvalidgateException;
import machine_coding.parking_lot.models.Invoice;
import machine_coding.parking_lot.models.Ticket;

public interface InvoiceService {
    public Invoice generateInvoice(int ticketId, int gateId) throws InvalidTicketException, InvalidgateException;

}
