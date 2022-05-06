package com.example.demo20.services;


import com.example.demo20.repositories.GroupsRepository;
import com.example.demo20.tables.Groups;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GroupService  {
    private GroupsRepository groupsRepository;

    @Autowired
    GroupService(GroupsRepository groupsRepository) {
        this.groupsRepository = groupsRepository;
    }

    public GroupService() {
    }

    public void createEntity(Groups groups){
        log.info("Save group:", groups.toString());
        groupsRepository.save(groups);
    }

    public List<Groups> readAllEntity() {
        log.info("readAllEntity group");
        // session = sessionFactory.openSession();
        return groupsRepository.findAll();
    }

    public Groups readOneEntity(long id) {
        log.info("readOneEntity group by id: ",  id);
        return groupsRepository.findById(id).get();
    }


    public boolean updateEntity(Groups groups, long id) {
        log.info("updateEntity group by id: ",groups.toString()," ", id);
        groups.setId(id);
        groupsRepository.save(groups);
        return true;
    }


    public boolean deleteEntity(long id) {
        log.info("deleteEntity group by id: ", id);
        groupsRepository.deleteById(id);
        return true;
    }

    public List<Groups> sortGroupsByName() {
        log.info("sortGroupsByName");
        return groupsRepository.findAll(Sort.by("groupName"));
    }

    public List<Groups> filterGroupByFirstName(String firstName) {
        log.info("filterGroupByFirstName");
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
