import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "PurchaseList")
public @Data class PurchaseList {
    @EmbeddedId
    private  PurchaseListKey id;
    @Column(name = "student_name",insertable = false,updatable = false)
    private String studentName;
    @Column(name = "course_name",insertable = false,updatable = false)
    private String courseName;
    private int price;
    @Column(name = "subscription_date")
    private Date subscriptionDate;


}
