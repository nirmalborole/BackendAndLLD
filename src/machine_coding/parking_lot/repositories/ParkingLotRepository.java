package machine_coding.parking_lot.repositories;

import machine_coding.parking_lot.models.Gate;
import machine_coding.parking_lot.models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {
    Map<Integer,ParkingLot>map;

    public ParkingLotRepository(Map<Integer, ParkingLot> map) {
        this.map = map;
    }
    public ParkingLotRepository() {
        this.map = new HashMap<>();
    }

    public ParkingLot getParkingLotByGateId(int gateid){
        for (Map.Entry<Integer, ParkingLot> entry : map.entrySet()) {
            ParkingLot value = entry.getValue();
            for (Gate gate : value.getGates()) {
                if(gate.getId() == gateid){
                    return value;
                }
            }
        }
        return null;
    }
}
