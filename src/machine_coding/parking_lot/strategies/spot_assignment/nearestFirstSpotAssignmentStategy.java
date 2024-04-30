package machine_coding.parking_lot.strategies.spot_assignment;

import machine_coding.parking_lot.Exceptions.NoSpotAvailableException;
import machine_coding.parking_lot.models.*;

public class nearestFirstSpotAssignmentStategy implements AssignedSpotStategy{
    @Override
    public Spot assignSpot(VehicleType vehicleType, ParkingLot parkingLot) throws NoSpotAvailableException {
        for (Floor floor : parkingLot.getFloors()) {
            if(floor.getFloorStatus().equals(FloorStatus.OPERATIONAL)) {
                for (Section section : floor.getSections()) {
                    for (Spot spot : section.getSpots()) {
                        if(spot.getVehicleType().equals(vehicleType) && spot.getSpotStatus().equals(SpotStatus.UNOCCUPIED)){
                            spot.setSpotStatus(SpotStatus.UNOCCUPIED);
                            return spot;
                        }
                    }
                }
            }
        }
        throw new NoSpotAvailableException("no spot available for this type: "+ vehicleType);
    }
}
