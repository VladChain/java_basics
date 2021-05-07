import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teachers")
@Data
public class Teacher {

    String name;
    int age;
    int salary;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToMany(mappedBy="teacher", fetch=FetchType.EAGER)
    private List<Course> courses;
}
