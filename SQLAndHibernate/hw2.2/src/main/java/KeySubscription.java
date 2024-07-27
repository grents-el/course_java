import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@ToString
@Getter
@Setter
@NoArgsConstructor
public @Data class KeySubscription implements Serializable {
   // static final long serialVersionUTD=1L;
    //@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   // @JoinColumn(name = "student_id",columnDefinition = "integer")
    //private Students students;
    //@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   // @JoinColumn(name = "course_id", columnDefinition = "integer")
    //private Course course;

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;
}
