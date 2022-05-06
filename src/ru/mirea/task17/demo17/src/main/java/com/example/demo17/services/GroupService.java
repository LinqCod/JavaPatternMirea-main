package com.example.demo17.services;


import com.example.demo17.tables.Groups;
import com.example.demo17.tables.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class GroupService implements TableService<Groups> {

    private final SessionFactory sessionFactory;
    private Session session;

    public GroupService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
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

    public List<Groups> sortGroupsByName() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Groups> dogCriteriaQuery =
                builder.createQuery(Groups.class);
        Root<Groups> root = dogCriteriaQuery.from(Groups.class);

        dogCriteriaQuery.select(root).orderBy(builder.asc(root.get(
                "groupName")));
        Query<Groups> query = session.createQuery(dogCriteriaQuery);
        return query.getResultList();
    }

    public List<Groups> filterStudentByFirstName(String firstname) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Groups> dogCriteriaQuery =
                builder.createQuery(Groups.class);
        Root<Groups> root = dogCriteriaQuery.from(Groups.class);

        dogCriteriaQuery.select(root).where(builder.equal(root.get("groupName"),firstname));
        Query<Groups> query = session.createQuery(dogCriteriaQuery);
        return query.getResultList();
    }

    @PreDestroy
    private void finish() {
        session.close();
    }
}
