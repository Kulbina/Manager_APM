package com.example.apm_manager.dao.contract;

import com.example.apm_manager.models.Client;
import com.example.apm_manager.models.Contract;
import com.example.apm_manager.models.Proposal;
import com.example.apm_manager.utils.hibernate_factory.HibernateFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ContractDAOImpl implements ContractDAO{

    private Session getSession(){
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
    public Contract findById(int id) {
        Session session = getSession();
        if (session == null) {
            return null;
        }
        Contract contract = session.get(Contract.class, id);
        session.close();
        return contract;
    }

    @Override
    public void save(Contract contract) {
        Session session = getSession();
        if (session == null) {
            return;
        }
        Transaction tx1 = session.beginTransaction();
        session.persist(contract);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Contract contract) {
        Session session = getSession();
        if (session == null) {
            return;
        }
        Transaction tx1 = session.beginTransaction();
        session.saveOrUpdate(contract);
        tx1.commit();
        session.close();

    }

    @Override
    public void delete(Contract contract) {
        Session session = getSession();
        if (session == null) {
            return;
        }
        Transaction tx1 = session.beginTransaction();
        session.remove(contract);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Contract> findAll() {
        Session session = getSession();
        if (session == null) {
            return null;
        }
        Query<Contract> query = session.createQuery("From Contract ", Contract.class);
        List<Contract> contracts = query.getResultList();
        session.close();
        return contracts;
    }
}
