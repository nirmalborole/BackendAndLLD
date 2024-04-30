package machine_coding.parking_lot.controllers;

import machine_coding.parking_lot.Exceptions.InvalidRequestException;
import machine_coding.parking_lot.dtos.GenerateTicketRequestDto;
import machine_coding.parking_lot.dtos.GenerateTicketResponseDto;
import machine_coding.parking_lot.dtos.ResponceStatus;
import machine_coding.parking_lot.dtos.Response;
import machine_coding.parking_lot.models.Ticket;
import machine_coding.parking_lot.services.Ticketservice;
//import machine_coding.tictactoe.exceptions.InvalidgateException;

public class TicketController {
    private Ticketservice ticketservice;

    public TicketController(Ticketservice ticketservice) {
        this.ticketservice = ticketservice;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto requestDto){
        GenerateTicketResponseDto responseDto=new GenerateTicketResponseDto();
        try {
            if (requestDto.getGateId() < 0) {
                throw new InvalidRequestException("Gate id not valid");
            }
            if (requestDto.getVehicleType() == null || requestDto.getVehicleType().equals(" ")) {
                throw new InvalidRequestException("this not supported type");
            }
        }catch(Exception e){
            Response response= new Response();
            response.setStatus(ResponceStatus.FAILED);
            response.setError(e.getMessage());
            responseDto.setResponse(response);
            return responseDto;
        }
        Response response=new Response();
        try {
            Ticket ticket = ticketservice.generateTicket(requestDto.getGateId(), requestDto.getVehicleNumber(), requestDto.getVehicleType());
            responseDto.setTicket(ticket);
            response.setStatus(ResponceStatus.SUCESS);

        }catch (Exception e){
            response.setStatus(ResponceStatus.FAILED);
            response.setError(e.getMessage());
        }
        responseDto.setResponse(response);

        return responseDto;
    }
}
