package machine_coding.parking_lot.strategies.PricingStrategy;

import machine_coding.parking_lot.Utils.DateTimeUtil;
import machine_coding.parking_lot.models.Slab;
import machine_coding.parking_lot.models.VehicleType;
import machine_coding.parking_lot.repositories.SlabRepository;

import java.util.Date;
import java.util.List;

public class WeekEndStrategy implements CalculatefeeStategy{
    private SlabRepository slabRepository;

    public WeekEndStrategy(SlabRepository slabRepository) {
        this.slabRepository = slabRepository;
    }

    @Override
    public double calculateFees(Date entryTime, Date exitTime, VehicleType vehicleType) {
        List<Slab> slabs = this.slabRepository.getSlabByVehicleType(vehicleType);
        int hours = DateTimeUtil.calculatehours(entryTime, entryTime);
        double totalamount=0;
        for(Slab slab:slabs){
            if(hours >= slab.getStartHour() && slab.getEndHour() != -1){
                if(hours>= slab.getEndHour()){
                    totalamount+=(slab.getEndHour()-slab.getStartHour())* slab.getPricePerHour();
                }else{
                    totalamount+=(hours-slab.getStartHour())* slab.getPricePerHour();
                }
            }else if(slab.getEndHour() == -1){
                totalamount+=(hours - slab.getStartHour())* slab.getPricePerHour();
            }else{
                break;
            }
        }
        return totalamount;
    }
}
