import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Logger logger = LogManager.getRootLogger();
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Course course = session.get(Course.class, 1);
            System.out.println("Название курса: " + course.getName());
            System.out.println("Имя учителя: " + course.getTeacher().getName());
            System.out.println("Количество студентов на курсе: " + course.getStudents().size());
            System.out.println("Общее количество студентов у преподавателя: " +
                    course.getStudentsCount());
            System.out.println();

            List<Student> studentList = course.getStudents();
            System.out.println("Список студентов курса " + course.getName() + ":");
            studentList.forEach(student -> System.out.println(student.getName()));
            System.out.println();

            Student student = session.get(Student.class, 2);
            System.out.println("Имя студента: " + student.getName());

            List<Course> courseList = student.getCourses();
            System.out.println("Студент " + student.getName() + " подписан на курсы:");
            courseList.forEach(courses -> System.out.println(courses.getName()));
            System.out.println();

            Teacher teacher = session.get(Teacher.class, 10);
            System.out.println("Имя учителя: " + teacher.getName());

            List<Course> courses = teacher.getCourses();
            System.out.println("Список курсов, который преподает " + teacher.getName() + ":");
            courses.forEach(c -> System.out.println(c.getName()));
            System.out.println();

            Student studentId = session.get(Student.class, 2);
            Course courseId = session.get(Course.class, 1);
            Subscription subscription1 = session
                    .get(Subscription.class, new Key(studentId, courseId));
            System.out.println(subscription1);
            Subscription subscription2 = session
                    .get(Subscription.class, new Key(1, 2));
            System.out.println(subscription2);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                logger.info("Invalid data entry");
                transaction.rollback();
                ex.printStackTrace();
            }
            ex.printStackTrace();
        }
    }
}
