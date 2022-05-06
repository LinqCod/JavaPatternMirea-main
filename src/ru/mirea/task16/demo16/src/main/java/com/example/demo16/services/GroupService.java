package com.example.demo16.services;


import com.example.demo16.tables.Groups;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService implements TableService<Groups> {

    private final SessionFactory sessionFactory;
    private Session session;

    public GroupService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createEntity(Groups student) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(student);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Groups> readAllEntity() {
        session = sessionFactory.openSession();
        List<Groups> students = session.createQuery("select i from Groups i", Groups.class).getResultList();
        session.close();
        return students;
    }

    @Override
    public Groups readOneEntity(long id) {
        session = sessionFactory.openSession();
        Groups student = session.createQuery("from Groups where id = :id", Groups.class).setParameter("id", id).getSingleResult();
        session.close();
        return student;
    }

    @Override
    public boolean updateEntity(Groups student, long id) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("update Groups set groupName=:n where id = :id")
                .setParameter("id", id)
                .setParameter("n", student.getGroupName());
        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean deleteEntity(long id) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete from Groups where id = :id")
                .setParameter("id", id);
        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
        session.close();
        return true;
    }

    /**
     @Autowired private final SessionFactory factory;

     private Session session;

     public GroupService(SessionFactory factory) {
     this.factory = factory;
     }

     @PostConstruct private void init() {
     session = factory.openSession();
     }

     public List<Groups> getGroups() {
     return session.createQuery("FROM Groups ").getResultList();
     }

     public void save(Groups value) {
     session.beginTransaction();
     if (value.getId() == null)
     session.persist(value);
     else
     session.merge(value);
     session.getTransaction().commit();

     }

     public void remove(Integer id) {
     session.beginTransaction();
     Groups item = session.find(Groups.class, id);
     if (item != null) session.remove(item);
     session.getTransaction().commit();
     }

     @PreDestroy private void finish() {
     session.close();
     }
     */
}
