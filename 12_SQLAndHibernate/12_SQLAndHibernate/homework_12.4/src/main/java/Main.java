import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Logger logger = LogManager.getRootLogger();
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            //заполнение таблицы LinkedPurchaseList
            String sql = "select * from PurchaseList";
            Query query = session.createSQLQuery(sql).addEntity(PurchaseList.class);
            List<PurchaseList> purchaseList = query.list();

            transaction = session.beginTransaction();

            purchaseList.forEach(p -> session.save(new LinkedPurchaseList(p.getStudentName(),
                    p.getCourseName())));

            purchaseList.forEach(System.out::println);

//            transaction.commit();
            session.close();

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
