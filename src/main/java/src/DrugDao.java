package src;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class DrugDao {

    HibernateFactory hibernateFactory = new HibernateFactory();

    public void saveDrug(Drug drug) {
        Session session = hibernateFactory.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.save(drug);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("saveDrug - coś nie tak!");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public Drug readDrug(Long id) {
        Session session = hibernateFactory.getSessionFactory().openSession();
        Drug drug = null;
        try {
            drug = session.get(Drug.class, id);
        } catch (Exception e) {
            System.out.println("readDrug - coś nie tak!");
        } finally {
            session.close();
        }
        return drug;
    }

    public void deleteDrug(Long id) {
        Session session = hibernateFactory.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Drug drug = session.find(Drug.class, id);
            session.delete(drug);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("deleteDrug - coś nie tak!");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public void updateDrug(Drug newDrug) {
        Session session = hibernateFactory.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Drug drug4db = session.find(Drug.class, newDrug.getId());
            drug4db.setDrugType(newDrug.getDrugType());
            drug4db.setProdYear(newDrug.getProdYear());
            drug4db.setPrice(newDrug.getPrice());
            drug4db.setName(newDrug.getName());
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("deleteDrug - coś nie tak!");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }


    public List<Drug> getDrugsByPower(DrugType drugType) {
        List<Drug> drugs = new ArrayList<>();
        Session session = hibernateFactory.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Query query = session.createNativeQuery("SELECT id FROM drugs WHERE drugType LIKE ?");
            query.setParameter(1, drugType.toString());
            List<BigInteger> resultList = query.getResultList();
            for (BigInteger id : resultList) {
                drugs.add(readDrug(id.longValue()));
            }
        } catch (Exception e) {
            System.out.println("getDrugsByPower - coś nie tak!");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return drugs;

    }


}
