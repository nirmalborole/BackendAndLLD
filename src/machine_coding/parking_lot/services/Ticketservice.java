package machine_coding.parking_lot.services;

import machine_coding.parking_lot.models.Ticket;

public interface Ticketservice {
    public Ticket generateTicket(int gateid,String vehicleNumber,String vehicleType)throws Exception;
    public Ticket getTicketById(int ticketId);
}
