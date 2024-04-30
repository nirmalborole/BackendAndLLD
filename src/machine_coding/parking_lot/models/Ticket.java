package machine_coding.parking_lot.models;

import java.util.Date;

public class Ticket extends BaseModel{
    private Date entrytime;
    private Vehicle vehicle;
    private Spot assignedSpot;
    private Gate gate;

    public Date getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Spot getAssignedSpot() {
        return assignedSpot;
    }

    public void setAssignedSpot(Spot assignedSpot) {
        this.assignedSpot = assignedSpot;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }
}
