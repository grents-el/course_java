import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Subscriptions")
@Getter
@Setter
public @Data class Subscriptions {
    @EmbeddedId
    public KeySubscription id;

    @Column(name = "student_id",insertable = false,updatable = false)
    private int studentId;

    @Column(name = "course_id",insertable = false,updatable = false)
    private int courseId;

    @Column(name = "subscription_date")
    private Date subscription_date;

}
