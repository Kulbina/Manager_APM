package com.example.apm_manager.dao.proposal;

import com.example.apm_manager.models.Client;
import com.example.apm_manager.models.Contract;
import com.example.apm_manager.models.Proposal;
import com.example.apm_manager.services.ClientService;
import com.example.apm_manager.utils.hibernate_factory.HibernateFactoryUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ProposalDAOImpl implements ProposalDAO {

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
    public Proposal findById(int id) {
        Session session = getSession();
        if (session == null) {
            return null;
        }
        Proposal proposal = session.get(Proposal.class, id);
        session.close();
        return proposal;
    }

    @Override
    public void save(Proposal proposal) {
        Session session = getSession();
        if (session == null) {
            return;
        }
        Transaction tx1 = session.beginTransaction();
        session.persist(proposal);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Proposal proposal) {
        Session session = getSession();
        if (session == null) {
            return;
        }
        Transaction tx1 = session.beginTransaction();
        session.saveOrUpdate(proposal);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Proposal proposal) {
        Session session = getSession();
        if (session == null) {
            return;
        }
        Transaction tx1 = session.beginTransaction();
        session.remove(proposal);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Proposal> findAll() {
        Session session = getSession();
        if (session == null) {
            return null;
        }
        Query<Proposal> query = session.createQuery("From Proposal", Proposal.class);
        List<Proposal> proposals = query.getResultList();
        session.close();
        return proposals;
    }

    @Override
    public List<Proposal> findAllByClientId(int clientId) {
        Session session = getSession();
        if (session == null) {
            return null;
        }
        ClientService clientService = new ClientService();
        Client client = clientService.findClientById(clientId);
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Proposal> cr = cb.createQuery(Proposal.class);
        Root<Proposal> root = cr.from(Proposal.class);
        cr.select(root)
                .where(
                        cb.equal(root.get("client"), client)
                );

        Query<Proposal> query = session.createQuery(cr);
        List<Proposal> proposals = query.getResultList();
        session.close();
        return proposals;
    }

}
