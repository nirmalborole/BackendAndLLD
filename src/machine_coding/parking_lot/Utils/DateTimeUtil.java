package machine_coding.parking_lot.Utils;

import java.util.Date;

public class DateTimeUtil {
    public static int calculatehours(Date start, Date end){
        long diff= start.getTime()-end.getTime();
        long diffinsec= diff/1000;
        int hour=(int) Math.ceil((double) diffinsec/3600);
        return hour;
    }
}
