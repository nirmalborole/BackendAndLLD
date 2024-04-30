package machine_coding.parking_lot.models;

import java.util.List;

public class Floor extends BaseModel{
    private int fllorNum;
    private List<Section> sections;
    private FloorStatus floorStatus;

    public int getFllorNum() {
        return fllorNum;
    }

    public void setFllorNum(int fllorNum) {
        this.fllorNum = fllorNum;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public FloorStatus getFloorStatus() {
        return floorStatus;
    }

    public void setFloorStatus(FloorStatus floorStatus) {
        this.floorStatus = floorStatus;
    }
}
