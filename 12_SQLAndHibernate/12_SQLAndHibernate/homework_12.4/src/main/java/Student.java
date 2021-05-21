import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Students")
@Data
public class Student implements Serializable {

    private String name;
    private int age;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "registration_date")
    private Date registrationDate;

    @OneToMany(mappedBy = "student")
    private List<Subscription> subscriptions;

    @OneToMany(mappedBy = "student")
    private List<PurchaseList> purchaseLists;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses;

    @Override
    public String toString() {
        return name;
    }
}