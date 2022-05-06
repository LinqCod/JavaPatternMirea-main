package com.example.demo20.services;


import com.example.demo20.repositories.StudentRepository;
import com.example.demo20.tables.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentService() {
    }

    public void createEntity(Student student) {
        log.info("Save group:", student.toString());
        studentRepository.save(student);
    }


    public List<Student> readAllEntity() {

        log.info("readAllEntity students");
        return studentRepository.findAll();
    }


    public Student readOneEntity(long id) {
        log.info("readOneEntity student by id: ",  id);
        return studentRepository.findById(id).get();
    }


    public boolean updateEntity(Student student, long id) {
        log.info("updateEntity student by id: ",student.toString()," ", id);
        student.setId(id);
        studentRepository.save(student);
        return true;
    }


    public boolean deleteEntity(long id) {
        log.info("deleteEntity group by id: ", id);
        studentRepository.deleteById(id);
        return true;
    }

    public List<Student> sortStudentByFirstName() {
        log.info("sortStudentByFirstName");
        return studentRepository.findAll(Sort.by("firstName"));
    }

    public List<Student> filterStudentByFirstName(String firstName) {
        log.info("filterStudentByFirstName");
        return studentRepository.findAllByFirstName(firstName);
    }



    /**
     *
     * private final SessionFactory sessionFactory;
    private Session session;


    public StudentService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
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

    public List<Student> sortStudentByFirstName() {
        session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> dogCriteriaQuery =
                builder.createQuery(Student.class);
        Root<Student> root = dogCriteriaQuery.from(Student.class);

        dogCriteriaQuery.select(root).orderBy(builder.asc(root.get(
                "firstName")));
        Query<Student> query = session.createQuery(dogCriteriaQuery);
        return query.getResultList();
    }

    public List<Student> filterStudentByFirstName(String firstname) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> dogCriteriaQuery =
                builder.createQuery(Student.class);
        Root<Student> root = dogCriteriaQuery.from(Student.class);

        dogCriteriaQuery.select(root).where(builder.equal(root.get("firstName"),firstname));
        Query<Student> query = session.createQuery(dogCriteriaQuery);
        return query.getResultList();
    }

    @PreDestroy
    private void finish() {
        session.close();
    }*/
}
