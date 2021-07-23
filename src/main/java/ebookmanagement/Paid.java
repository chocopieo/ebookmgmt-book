
package ebookmanagement;

import java.util.Date;

public class Paid extends AbstractEvent {

    private Long id;
    private Long rentId;
    private Long userId;
    private Long bookId;
    private Long rentalFee;
    private String status;
    private Date paidDate;

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
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    public Long getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(Long rentalFee) {
        this.rentalFee = rentalFee;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }
}

