package machine_coding.parking_lot.strategies.PricingStrategy;

import machine_coding.parking_lot.models.VehicleType;

import java.util.Date;

public interface CalculatefeeStategy {
    public double calculateFees(Date entryTime, Date exitTime, VehicleType vehicleType);
}
