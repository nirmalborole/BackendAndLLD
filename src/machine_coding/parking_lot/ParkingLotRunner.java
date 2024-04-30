package machine_coding.parking_lot;

import machine_coding.parking_lot.Factory.CalculateFeesStategyFactory;
import machine_coding.parking_lot.controllers.InvoiceController;
import machine_coding.parking_lot.controllers.TicketController;
import machine_coding.parking_lot.dtos.GenerateInvoiceRequestDto;
import machine_coding.parking_lot.dtos.GenerateInvoiceResponceDto;
import machine_coding.parking_lot.dtos.GenerateTicketRequestDto;
import machine_coding.parking_lot.dtos.GenerateTicketResponseDto;
import machine_coding.parking_lot.models.*;
import machine_coding.parking_lot.repositories.*;
import machine_coding.parking_lot.services.*;
import machine_coding.parking_lot.strategies.spot_assignment.AssignedSpotStategy;
import machine_coding.parking_lot.strategies.spot_assignment.nearestFirstSpotAssignmentStategy;

import java.util.*;

public class ParkingLotRunner {
    public static void main(String[] args) {
        Gate gate1= new Gate();
        gate1.setGateType(GateType.ENTRY);
        gate1.setName("1A");
        gate1.setOperator(new Operator());
        gate1.setId(1);

        Gate gate2= new Gate();
        gate2.setGateType(GateType.EXIT);
        gate2.setName("4Z");
        gate2.setOperator(new Operator());
        gate2.setId(2);

        Map<Integer, Gate>gatemap= new HashMap<>();
        gatemap.put(1,gate1);
        gatemap.put(2,gate2);

        List<Spot> spots= Arrays.asList(new Spot("1A",SpotStatus.UNOCCUPIED,VehicleType.CAR),new Spot("2A",SpotStatus.UNOCCUPIED,VehicleType.CAR));
        List<Section>sections=new ArrayList<>();
        Section section= new Section();
        section.setName("AA");
        section.setId(1);
        section.setSpots(spots);
        sections.add(section);

        List<Floor> floors=new ArrayList<>();
        Floor floor=new Floor();
        floor.setId(1);
        floor.setFllorNum(1);
        floor.setFloorStatus(FloorStatus.OPERATIONAL);
        floor.setSections(sections);
        floors.add(floor);

        List<Gate>gates= Arrays.asList(gate1,gate2);

        ParkingLot parkingLot=new ParkingLot();
        parkingLot.setFloors(floors);
        parkingLot.setId(1);
        parkingLot.setGates(gates);

        Map<Integer,ParkingLot> parkingLotMap= new HashMap<>();
        parkingLotMap.put(1,parkingLot);

        Slab slab1= new Slab(1,VehicleType.CAR,0,2,10);
        Slab slab2= new Slab(2,VehicleType.CAR,2,4,20);
        Slab slab3= new Slab(3,VehicleType.CAR,4,8,25);
        Slab slab4= new Slab(4,VehicleType.CAR,8,-1,40);

        Map<Integer,Slab> slabMap=new HashMap<>();
        slabMap.put(1,slab1);
        slabMap.put(2,slab2);
        slabMap.put(3,slab3);
        slabMap.put(4,slab4);
        SlabRepository slabRepository=new SlabRepository(slabMap);
        InvoiceRepository invoiceRepository=new InvoiceRepository();
        CalculateFeesStategyFactory calculateFeesStategyFactory=new CalculateFeesStategyFactory(slabRepository);

        GateRepository gateRepository= new GateRepository(gatemap);
        ParkingLotRepository parkingLotRepository= new ParkingLotRepository(parkingLotMap);
        TicketRepository ticketRepository= new TicketRepository();
        VehicleRepository vehicleRepository= new VehicleRepository();

        GateService gateService= new GateService(gateRepository);
        AssignedSpotStategy assignedSpotStategy=new nearestFirstSpotAssignmentStategy();
        Ticketservice ticketservice= new TicketServiceImpl(gateService,vehicleRepository,assignedSpotStategy,parkingLotRepository,ticketRepository);
        TicketController ticketController= new TicketController(ticketservice);

        InvoiceService invoiceService=new InvoiceServiceImpl(ticketservice,gateService,calculateFeesStategyFactory,invoiceRepository);
        InvoiceController invoiceController=new InvoiceController(invoiceService);

        GenerateTicketRequestDto requestDto= new GenerateTicketRequestDto();
        requestDto.setGateId(1);
        requestDto.setVehicleType(VehicleType.CAR.toString());
        requestDto.setVehicleNumber("MH 14 2911");

        GenerateTicketResponseDto responseDto = ticketController.generateTicket(requestDto);
        System.out.println(responseDto);
        int ticketId=responseDto.getTicket().getId();

        GenerateInvoiceRequestDto invoiceRequestDto=new GenerateInvoiceRequestDto();
        invoiceRequestDto.setTicketId(ticketId);
        invoiceRequestDto.setGateId(gate2.getId());

        GenerateInvoiceResponceDto responceDto = invoiceController.generateInvoice(invoiceRequestDto);
        System.out.println(responceDto);

    }
}
