import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Subscriptions")
@IdClass(Key.class)
@Data
public class Subscription {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    Student student;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    Course course;

    @Column(name = "subscription_date")
    private Date subscriptionDate;
}

