package ebookmanagement;

import java.util.Date;

public class Returned extends AbstractEvent {

    private Long id;
    private String status;
    private Date returnedDate;

    public Returned(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Date getReturnedDate() { return returnedDate; }

    public void setReturnedDate(Date returnedDate) { this.returnedDate = returnedDate; }
}
