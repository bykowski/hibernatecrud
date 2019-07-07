package src;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DrugDao {

    HibernateFactory hibernateFactory = new HibernateFactory();

    public void saveDrug(Drug drug) {
        Session session = hibernateFactory.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.save(drug);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("coś nie tak!");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
