package ebookmanagement;

import java.util.Date;

public class Refunded extends AbstractEvent {

    private Long id;
    private Long rentId;
    private String status;
    private Date refundedDate;

    public Refunded(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getRentId() {
        return rentId;
    }

    public void setRentId(Long rentId) {
        this.rentId = rentId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Date getRefundedDate() { return refundedDate; }

    public void setRefundedDate(Date refundedDate) { this.refundedDate = refundedDate; }
}
