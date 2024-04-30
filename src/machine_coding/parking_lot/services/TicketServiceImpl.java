package machine_coding.parking_lot.services;

import machine_coding.parking_lot.models.*;
import machine_coding.parking_lot.repositories.GateRepository;
import machine_coding.parking_lot.repositories.ParkingLotRepository;
import machine_coding.parking_lot.repositories.TicketRepository;
import machine_coding.parking_lot.repositories.VehicleRepository;
import machine_coding.parking_lot.strategies.spot_assignment.AssignedSpotStategy;

import java.util.Date;

public class TicketServiceImpl implements Ticketservice{
    private GateService gateService;
    private VehicleRepository vehicleRepository;
    private AssignedSpotStategy assignedSpotStategy;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public TicketServiceImpl(GateService gateService, VehicleRepository vehicleRepository, AssignedSpotStategy assignedSpotStategy, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository) {
        this.gateService = gateService;
        this.vehicleRepository = vehicleRepository;
        this.assignedSpotStategy = assignedSpotStategy;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket generateTicket(int gateid, String vehicleNumber, String vehicleType) throws Exception {
        Gate gate = gateService.getGateById(gateid);
        VehicleType type = VehicleType.getTypeFromStr(vehicleType);
        Vehicle vehicle = vehicleRepository.createIfNotExist(vehicleNumber, type);
        ParkingLot parkinggate = parkingLotRepository.getParkingLotByGateId(gateid);
        if(parkinggate == null){
            throw new Exception("Invalid gate id");
        }
        Spot spot = assignedSpotStategy.assignSpot(type, parkinggate);
        Ticket ticket=new Ticket();
        ticket.setAssignedSpot(spot);
        ticket.setGate(gate);
        ticket.setVehicle(vehicle);
        ticket.setEntrytime(new Date());
        return ticketRepository.inserTicket(ticket);

    }

    @Override
    public Ticket getTicketById(int ticketId) {
        return ticketRepository.getTicketById(ticketId);
    }
}
