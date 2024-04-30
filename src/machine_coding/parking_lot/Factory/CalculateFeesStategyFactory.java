package machine_coding.parking_lot.Factory;

import machine_coding.parking_lot.repositories.SlabRepository;
import machine_coding.parking_lot.strategies.PricingStrategy.CalculatefeeStategy;
import machine_coding.parking_lot.strategies.PricingStrategy.WeekDayStrategy;
import machine_coding.parking_lot.strategies.PricingStrategy.WeekEndStrategy;

import java.util.Calendar;
import java.util.Date;

public class CalculateFeesStategyFactory {
    private  SlabRepository slabRepository;

    public CalculateFeesStategyFactory(SlabRepository slabRepository) {
        this.slabRepository = slabRepository;
    }

    public CalculatefeeStategy getcalculatefeeStategy(Date exitDate){
        Calendar calendar= Calendar.getInstance();
        calendar.setTime(exitDate);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        boolean isweeked= day== Calendar.SATURDAY || day==Calendar.SUNDAY;
        CalculatefeeStategy calculatefeeStategy;
        if(isweeked){
            calculatefeeStategy=new WeekEndStrategy(slabRepository);
        }else {
            calculatefeeStategy=new WeekDayStrategy();
        }
        return calculatefeeStategy;

    }
}
