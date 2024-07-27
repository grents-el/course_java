import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@AllArgsConstructor
@Data
public  class LinkedPurchaseKey implements Serializable {

    @Column(name ="student_id")
    private int studentId;

    @Column(name ="course_id")
    private int courseId;

    public LinkedPurchaseKey() {

    }


}
