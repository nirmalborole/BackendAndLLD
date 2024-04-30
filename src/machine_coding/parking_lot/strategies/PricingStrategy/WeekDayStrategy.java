package machine_coding.parking_lot.strategies.PricingStrategy;

import machine_coding.parking_lot.Utils.DateTimeUtil;
import machine_coding.parking_lot.models.VehicleType;

import java.util.Date;

public class WeekDayStrategy implements CalculatefeeStategy{
    @Override
    public double calculateFees(Date entryTime, Date exitTime, VehicleType vehicleType) {
        return DateTimeUtil.calculatehours(entryTime,exitTime)*10;
    }
}
