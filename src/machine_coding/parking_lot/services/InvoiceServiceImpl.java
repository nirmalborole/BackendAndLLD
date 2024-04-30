package machine_coding.parking_lot.services;

import machine_coding.parking_lot.Exceptions.InvalidTicketException;
import machine_coding.parking_lot.Exceptions.InvalidgateException;
import machine_coding.parking_lot.Factory.CalculateFeesStategyFactory;
import machine_coding.parking_lot.models.*;
import machine_coding.parking_lot.repositories.InvoiceRepository;
import machine_coding.parking_lot.repositories.SlabRepository;
import machine_coding.parking_lot.strategies.PricingStrategy.CalculatefeeStategy;
import machine_coding.parking_lot.strategies.PricingStrategy.WeekDayStrategy;
import machine_coding.parking_lot.strategies.PricingStrategy.WeekEndStrategy;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class InvoiceServiceImpl implements InvoiceService{
    private Ticketservice ticketservice;
    private GateService gateService;
    private CalculateFeesStategyFactory factory;
    private InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(Ticketservice ticketservice, GateService gateService, CalculateFeesStategyFactory factory, InvoiceRepository invoiceRepository) {
        this.ticketservice = ticketservice;
        this.gateService = gateService;
        this.factory = factory;
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Invoice generateInvoice(int ticketId, int gateId) throws InvalidTicketException, InvalidgateException {
        Ticket ticket = this.ticketservice.getTicketById(ticketId);
        if(ticket == null){
            throw new InvalidTicketException("This is not valid ticket id");
        }
        Gate gate = this.gateService.getGateById(gateId);
        if(gate == null){
            throw new InvalidgateException("gate not valid");
        }
        if(gate.getGateType().equals(GateType.ENTRY)){
            throw new InvalidgateException("this is entry gate");
        }

        Date entryDate= ticket.getEntrytime();
        Date exitDate= new Date();
        CalculatefeeStategy calculatefeeStategy = factory.getcalculatefeeStategy(exitDate);
        double totalamont = calculatefeeStategy.calculateFees(entryDate, exitDate, ticket.getVehicle().getVehicleType());

        InvoiceDetails invoiceDetails= new InvoiceDetails();
        invoiceDetails.setName("Parking fees");
        invoiceDetails.setPrice(totalamont);
        Invoice invoice= new Invoice();
        invoice.setDetails(Arrays.asList(invoiceDetails));
        invoice.setTicket(ticket);
        invoice.setExitTime(exitDate);
        return invoiceRepository.insertInvoice(invoice);
    }
}
