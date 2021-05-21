import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Courses")
@Data
@NoArgsConstructor
public class Course implements Serializable {

    String name;
    int duration;
    String description;
    int price;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    private CourseType type;

    @Column(name = "students_count")
    private Integer studentsCount;

    @Column(name = "price_per_hour")
    private float pricePerHour;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<Subscription> subscriptions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    List<PurchaseList> purchaseLists;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Teacher teacher;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "subscriptions",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")})
    private List<Student> students;

    @Override
    public String toString() {
        return name;
    }
}