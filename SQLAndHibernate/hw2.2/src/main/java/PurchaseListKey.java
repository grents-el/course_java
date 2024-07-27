import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

public @Data class PurchaseListKey implements Serializable {
    @Column(name = "Student_name")
    private String studentName;
    @Column(name = "Course_name")
    private String courseName;


}
