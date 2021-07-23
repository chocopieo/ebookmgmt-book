package ebookmanagement;

import java.util.Date;

public class Registed extends AbstractEvent {

    private Long id;
    private String bookName;
    private Long rentalFee;
    private String status;
    private Date registedDate;

    public Registed(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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
    public Date getRegistedDate() {
        return registedDate;
    }

    public void setRegistedDate(Date registedDate) {
        this.registedDate = registedDate;
    }
}
