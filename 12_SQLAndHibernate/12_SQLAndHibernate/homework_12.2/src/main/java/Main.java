import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

public class Main {

    private static Logger logger;

    public static void main(String[] args) {

        logger = LogManager.getRootLogger();

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            Course course = session.get(Course.class, 3);
            System.out.println(course.getName() + " = " + course.getStudentsCount() + " students;");

            session.close();

        } catch (Exception ex) {
            logger.info("Invalid data entry");
            ex.printStackTrace();
        }
    }
}
