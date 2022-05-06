package com.example.demo24.services;

import com.example.demo24.repositories.GroupsRepository;
import com.example.demo24.repositories.StudentRepository;
import com.example.demo24.tables.Groups;
import com.example.demo24.tables.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private EmailService emailService;
    @Mock
    private StudentRepository groupsRepository;
    private StudentService underTest;

    @BeforeEach
    void setUp() {
        underTest = new StudentService(groupsRepository, emailService);
    }

    @Test
    void createEntity() {
        // given
        Student student = new Student();
        student.setFirstName("Pit");
        student.setMiddleName("John");
        student.setLastName("Bush");

        //when
        underTest.createEntity(student);

        //then

        //ArgumentCaptor хранит и предоставляет все значения соответствующего параметра,
        // с которыми метод был вызван до того, как данный
        ArgumentCaptor<Student> groupsArgumentCaptor =
                ArgumentCaptor.forClass(Student.class);

        //С помощью Mockito разработчик создает имитатор — мок, указывает библиотеке,
        // что делать при вызове определенных методов, а затем использует экземпляр имитатора в своем тесте
        // вместо реального объекта.
        Mockito.verify(groupsRepository).save(groupsArgumentCaptor.capture());
        Mockito.verify(emailService).sendNotification(groupsArgumentCaptor.capture());

        Student groupsArgumentCaptorValue = groupsArgumentCaptor.getValue();
        Assertions.assertThat(groupsArgumentCaptorValue).isEqualTo(student);
    }

    @Test
    void readAllEntity() {
        // given
        Student student = new Student();
        student.setFirstName("Pit");
        student.setMiddleName("John");
        student.setLastName("Bush");
        // given
        Student student2 = new Student();
        student2.setFirstName("Bill");
        student2.setMiddleName("Johnik");
        student2.setLastName("Bushik");

        Mockito.when(groupsRepository.findAll()).thenReturn(List.of(student, student2));

        //when
        List<Student> expected = underTest.readAllEntity();

        //then
        Mockito.verify(groupsRepository).findAll();
        assertThat(expected).isNotNull();
        assertThat(expected.size()).isEqualTo(2);
        assertThat(expected.get(0).getFirstName()).isEqualTo("Pit");
        assertThat(expected.get(1).getFirstName()).isEqualTo("Bill");

    }

    @Test
    void readOneEntity() {
        // given
        Student student = new Student();
        student.setFirstName("Pit");
        student.setMiddleName("John");
        student.setLastName("Bush");
        student.setId(2l);
        //Groups groups2 = new Groups();
        //groups2.setGroupName("IKBO-02-20");
        //groups2.setId(5l);

        //Класс Optional обладает схожими свойствами — при написании кода разработчик часто не может знать
        // — будет ли существовать нужный объект на момент исполнения программы или нет,
        // и в таких случаях приходится делать проверки на null
        Mockito.when(groupsRepository.getById(student.getId())).thenReturn(student);

        //when
        Student expected = underTest.readOneEntity(student.getId());

        //then
        Mockito.verify(groupsRepository).getById(student.getId());
        assertThat(expected).isEqualTo(student);
    }

    @Test
    void updateEntity() {
        // given
        Student student = new Student();
        student.setFirstName("Pit");
        student.setMiddleName("John");
        student.setLastName("Bush");
        student.setId(2l);

        // when
        underTest.updateEntity(student,student.getId());

        // then
        Mockito.verify(groupsRepository).save(student);
    }

    @Test
    void deleteEntity() {
        // given
        Student student = new Student();
        student.setFirstName("Pit");
        student.setMiddleName("John");
        student.setLastName("Bush");
        student.setId(2l);

        // when
        underTest.deleteEntity(student.getId());

        // then
        Mockito.verify(groupsRepository).deleteById(student.getId());
    }

    @Test
    void sortStudentByFirstName() {
        // given
        Student student = new Student();
        student.setFirstName("Pit");
        student.setMiddleName("John");
        student.setLastName("Bush");
        student.setId(2l);

        Student student2 = new Student();
        student2.setFirstName("Alex");
        student2.setMiddleName("John");
        student2.setLastName("Bush");
        student2.setId(3l);

        Mockito.when(groupsRepository.findAll(Sort.by("firstName"))).thenReturn(List.of(student2, student));

        //when
        List<Student> expected = underTest.sortStudentByFirstName();

        //then
        Mockito.verify(groupsRepository).findAll(Sort.by("firstName"));
        assertThat(expected).isNotNull();
        assertThat(expected.size()).isEqualTo(2);
        assertThat(expected.get(0).getFirstName()).isEqualTo("Alex");
    }

    @Test
    void filterStudentByFirstName() {
        Student student = new Student();
        student.setFirstName("Pit");
        student.setMiddleName("John");
        student.setLastName("Bush");
        student.setId(2l);

        Student student2 = new Student();
        student2.setFirstName("Alex");
        student2.setMiddleName("John");
        student2.setLastName("Bush");
        student2.setId(3l);

        Mockito.when(groupsRepository.findAllByFirstName(student2.getFirstName())).thenReturn(List.of(student2));

        //when
        List<Student> expected = underTest.filterStudentByFirstName(student2.getFirstName());

        //then
        Mockito.verify(groupsRepository).findAllByFirstName(student2.getFirstName());
        assertThat(expected).isNotNull();
        assertThat(expected.size()).isEqualTo(1);
        assertThat(expected.get(0).getFirstName()).isEqualTo("Alex");
    }
}