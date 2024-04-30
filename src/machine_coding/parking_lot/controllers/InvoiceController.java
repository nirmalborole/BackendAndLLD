package machine_coding.parking_lot.controllers;

import machine_coding.parking_lot.Exceptions.InvalidRequestException;
import machine_coding.parking_lot.dtos.GenerateInvoiceRequestDto;
import machine_coding.parking_lot.dtos.GenerateInvoiceResponceDto;
import machine_coding.parking_lot.dtos.ResponceStatus;
import machine_coding.parking_lot.dtos.Response;
import machine_coding.parking_lot.models.Invoice;
import machine_coding.parking_lot.services.InvoiceService;

import java.security.spec.ECField;

public class InvoiceController {
    InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public GenerateInvoiceResponceDto generateInvoice(GenerateInvoiceRequestDto requestDto){
        GenerateInvoiceResponceDto responceDto= new GenerateInvoiceResponceDto();
        try{
            if(requestDto.getTicketId() < 0){
                throw new InvalidRequestException("ticket id not valid");
            }
            if(requestDto.getGateId()<0){
                throw new InvalidRequestException("Gate id nt valid");
            }
        }catch(Exception e){
            Response response= new Response();
            response.setStatus(ResponceStatus.FAILED);
            response.setError(e.getMessage());
            responceDto.setResponse(response);
            return responceDto;
        }
        try{
            Invoice invoice = invoiceService.generateInvoice(requestDto.getTicketId(), requestDto.getGateId());
            Response response= new Response();
            response.setStatus(ResponceStatus.SUCESS);
            responceDto.setInvoice(invoice);
            responceDto.setResponse(response);
            return responceDto;
        }catch (Exception e){
            Response response= new Response();
            response.setStatus(ResponceStatus.FAILED);
            response.setError(e.getMessage());
            responceDto.setResponse(response);
            return responceDto;
        }
    }
}
