package com.example.apm_manager.dao.client;

import com.example.apm_manager.models.Client;
import com.example.apm_manager.models.Contract;
import com.example.apm_manager.models.Proposal;
import com.example.apm_manager.utils.hibernate_factory.HibernateFactoryUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDAO {

    private Session getSession() {
        List<Class> targets = new ArrayList<>();
        targets.add(Client.class);
        targets.add(Proposal.class);
        targets.add(Contract.class);

        try {
            return HibernateFactoryUtil.getSessionFactory(targets).openSession();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Client findById(int id) {
        Session session = getSession();
        if (session == null) {
            return null;
        }
        Client client = session.get(Client.class, id);
        session.close();
        return client;
    }

    @Override
    public Client findByPhoneNumber(Long phoneNumber) {
        Session session = getSession();
        if (session == null) {
            return null;
        }
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Client> cr = cb.createQuery(Client.class);
        Root<Client> root = cr.from(Client.class);
        cr.select(root).where(cb.equal(root.get("phoneNumber"), phoneNumber));

        Query<Client> query = session.createQuery(cr);
        List<Client> results = query.getResultList();
        session.close();
        if (results.size() == 0) return null;
        return results.get(0);
    }

    @Override
    public void save(Client client) {
        Session session = getSession();
        if (session == null) {
            return;
        }
        Transaction tx1 = session.beginTransaction();
        session.persist(client);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Client client) {
        Session session = getSession();
        if (session == null) {
            System.out.println("Session null");
            return;
        }
        Transaction tx1 = session.beginTransaction();
        System.out.println(client.toString());
        session.saveOrUpdate(client);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Client client) {
        Session session = getSession();
        if (session == null) {
            return;
        }
        Transaction tx1 = session.beginTransaction();
        session.remove(client);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Client> findAll() {
        Session session = getSession();
        if (session == null) {
            return null;
        }
        Query<Client> query = session.createQuery("From Client", Client.class);
        List<Client> clients = query.getResultList();
        session.close();
        return clients;
    }

    @Override
    public List<Client> findByFIO(String firstName, String secondName, String lastName) {
        Session session = getSession();
        if (session == null) {
            return null;
        }
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Client> cr = cb.createQuery(Client.class);
        Root<Client> root = cr.from(Client.class);
        cr.select(root)
                .where(
                        cb.equal(root.get("firstName"), firstName),
                        cb.equal(root.get("secondName"), secondName),
                        cb.equal(root.get("lastName"), lastName)
                );

        Query<Client> query = session.createQuery(cr);
        List<Client> clients = query.getResultList();
        session.close();
        return clients;
    }

    @Override
    public Client findByPassport(Integer passportSeries, Integer passportNumber) {
        Session session = getSession();
        if (session == null) {
            return null;
        }
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Client> cr = cb.createQuery(Client.class);
        Root<Client> root = cr.from(Client.class);
        cr.select(root)
                .where(
                        cb.equal(root.get("passportSeries"), passportSeries),
                        cb.equal(root.get("passportNumber"), passportNumber)
                );

        Query<Client> query = session.createQuery(cr);
        List<Client> results = query.getResultList();
        session.close();
        if (results.size() == 0) return null;
        return results.get(0);
    }
}
