package com.example.demo16.services;


import com.example.demo16.tables.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class StudentService implements TableService<Student> {
    private final SessionFactory sessionFactory;
    private Session session;

    public StudentService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createEntity(Student student) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(student);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Student> readAllEntity() {
        session = sessionFactory.openSession();
        List<Student> students = session.createQuery("select i from Student i", Student.class).getResultList();
        session.close();
        return students;
    }

    @Override
    public Student readOneEntity(long id) {
        session = sessionFactory.openSession();
        Student student = null;
        try {
            student = session.createQuery("from Student where id = :id", Student.class)
                    .setParameter("id", id).getSingleResult();
        }
        catch (NoResultException noResultException){

        }
        System.out.println(student);
        session.close();
        return student;
    }

    @Override
    public boolean updateEntity(Student student, long id) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("update Student set firstName=:n, lastName=:y, middleName=:z where id = :id")
                .setParameter("id", id)
                .setParameter("n", student.getFirstName())
                .setParameter("y", student.getLastName())
                .setParameter("z", student.getMiddleName());
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
        Query q = session.createQuery("delete from Student where id = :id")
                .setParameter("id", id);
        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
        session.close();
        return true;
    }

    /**@Autowired private final SessionFactory factory;
    private Session session;

    public StudentService(SessionFactory factory) {
    this.factory = factory;
    }

     @PostConstruct private void init() {
     session = factory.openSession();
     }

     public List<Student> getStudents() {
     return session.createQuery("FROM Student ").getResultList();
     }

     public void save(Student value) {
     session.beginTransaction();
     if (value.getId() == null)
     session.persist(value);
     else
     session.saveOrUpdate(value);
     session.getTransaction().commit();

     }

     public void remove(Integer id) {
     session.beginTransaction();
     Student item = session.find(Student.class, id);
     if (item != null) session.remove(item);
     session.getTransaction().commit();
     }

     @PreDestroy private void finish() {
     session.close();
     }
     */
}
