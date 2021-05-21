import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PurchaseList")
@Data
public class PurchaseList implements Serializable {

    private int price;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="student_name", referencedColumnName = "name")
    Student student;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="course_name", referencedColumnName = "name", nullable = false)
    Course course;


    @Column(name = "subscription_date")
    Date subscriptionDate;

    public Student getStudentName() {
        return student;
    }

    public Course getCourseName() {
        return course;
    }

    @Override
    public String toString() {
        return student + " = " + course;
    }
}
