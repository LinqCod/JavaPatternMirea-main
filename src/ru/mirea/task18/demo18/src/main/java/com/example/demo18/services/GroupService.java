package com.example.demo18.services;


import com.example.demo18.repositories.GroupsRepository;
import com.example.demo18.tables.Groups;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class GroupService  {
    private GroupsRepository groupsRepository;

    @Autowired
    GroupService(GroupsRepository groupsRepository) {
        this.groupsRepository = groupsRepository;
    }

    public GroupService() {
    }

    public void createEntity(Groups groups){
        //log.info("Save manufacture");
        groupsRepository.save(groups);
    }

    public List<Groups> readAllEntity() {
        // session = sessionFactory.openSession();
        return groupsRepository.findAll();
    }

    public Groups readOneEntity(long id) {
        return groupsRepository.getById(id);
    }


    public boolean updateEntity(Groups student, long id) {
        student.setId(id);
        groupsRepository.save(student);
        return true;
    }


    public boolean deleteEntity(long id) {
        groupsRepository.deleteById(id);
        return true;
    }

    public List<Groups> sortGroupsByName() {
        return groupsRepository.findAll(Sort.by("groupName"));
    }

    public List<Groups> filterGroupByFirstName(String firstName) {
        return groupsRepository.findAllByGroupNameEquals(firstName);
    }

    /**
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
        //session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(student);
        transaction.commit();
        //session.close();
    }

    @Override
    public List<Groups> readAllEntity() {
       // session = sessionFactory.openSession();
        List<Groups> students = session.createQuery("select i from Groups i", Groups.class).getResultList();
        //session.close();
        return students;
    }

    @Override
    public Groups readOneEntity(long id) {
        //session = sessionFactory.openSession();
        Groups student = session.createQuery("from Groups where id = :id", Groups.class).setParameter("id", id).getSingleResult();
        //session.close();
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
        //session.close();
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
        //session.close();
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
    }*/
}
