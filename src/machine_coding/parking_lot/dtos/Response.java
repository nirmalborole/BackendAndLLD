package machine_coding.parking_lot.dtos;

public class Response {
    private ResponceStatus status;
    private String error;

    public ResponceStatus getStatus() {
        return status;
    }

    public void setStatus(ResponceStatus status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
