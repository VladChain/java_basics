import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LinkedPurchaseList")
@NoArgsConstructor
@Data
public class LinkedPurchaseList implements Serializable {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    Student studentId;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    Course courseId;

    public LinkedPurchaseList(Student studentId, Course courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }
}


