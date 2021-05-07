import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Key implements Serializable {

   Student student;
   Course course;

    public Key(Integer studentId, Integer courseId) {
        this(new Student(studentId), new Course(courseId));
    }
}