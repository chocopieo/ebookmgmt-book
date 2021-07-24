package ebookmanagement;

import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Book_table")
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String bookName;
    private Long rentalFee;
    private Long rentId;
    private Long userId;
    private String status;
    private Date registedDate;
    private Date approvedDate;

    @PrePersist
    private void prePersist() {
        // 최초 등록 시 등록일자 : 현재, 상태 : POSSIBLE로 세팅
        if(null == this.status) {
            this.registedDate = new Date();
            this.status = "POSSIBLE";
        }
    }

    @PostPersist
    public void onPostPersist() {
        if("POSSIBLE".equals(this.status)) {
            Registed registed = new Registed();
            BeanUtils.copyProperties(this, registed);
            registed.publishAfterCommit();
        }
    }

    @PostUpdate
    public void onPostUpdate() {
        if("APPROVED".equals(this.status) ) {
            Approved approved = new Approved();
            BeanUtils.copyProperties(this, approved);
            approved.publishAfterCommit();
        }
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
    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }




}
