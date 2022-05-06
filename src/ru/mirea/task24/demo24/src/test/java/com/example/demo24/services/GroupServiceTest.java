package com.example.demo24.services;

import com.example.demo24.repositories.GroupsRepository;
import com.example.demo24.tables.Groups;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class GroupServiceTest {

    @Mock
    private EmailService emailService;
    @Mock
    private GroupsRepository groupsRepository;
    private GroupService underTest;

    //перед каждым тестом получаем чистые данные
    @BeforeEach
    public void setUp() {
        underTest = new GroupService(groupsRepository, emailService);
    }

    @Test
    void createEntity() {
        // given
        Groups groups = new Groups();
        groups.setGroupName("IKBO-01-20");

        //when
        underTest.createEntity(groups);

        //then

        //ArgumentCaptor хранит и предоставляет все значения соответствующего параметра,
        // с которыми метод был вызван до того, как данный
        ArgumentCaptor<Groups> groupsArgumentCaptor =
                ArgumentCaptor.forClass(Groups.class);

        //С помощью Mockito разработчик создает имитатор — мок, указывает библиотеке,
        // что делать при вызове определенных методов, а затем использует экземпляр имитатора в своем тесте
        // вместо реального объекта.
        Mockito.verify(groupsRepository).save(groupsArgumentCaptor.capture());
        Mockito.verify(emailService).sendNotification(groupsArgumentCaptor.capture());

        Groups groupsArgumentCaptorValue = groupsArgumentCaptor.getValue();
        Assertions.assertThat(groupsArgumentCaptorValue).isEqualTo(groups);
    }

    @Test
    void readAllEntity() {
        // given
        Groups groups = new Groups();
        groups.setGroupName("IKBO-01-20");
        Groups groups2 = new Groups();
        groups2.setGroupName("IKBO-02-20");

        Mockito.when(groupsRepository.findAll()).thenReturn(List.of(groups, groups2));

        //when
        List<Groups> expected = underTest.readAllEntity();

        //then
        Mockito.verify(groupsRepository).findAll();
        assertThat(expected).isNotNull();
        assertThat(expected.size()).isEqualTo(2);
        assertThat(expected.get(0).getGroupName()).isEqualTo("IKBO-01-20");
        assertThat(expected.get(1).getGroupName()).isEqualTo("IKBO-02-20");
    }

    @Test
    void readOneEntity() {
        // given
        Groups groups = new Groups();
        groups.setGroupName("IKBO-01-20");
        groups.setId(2L);
        //Groups groups2 = new Groups();
        //groups2.setGroupName("IKBO-02-20");
        //groups2.setId(5l);

        //Класс Optional обладает схожими свойствами — при написании кода разработчик часто не может знать
        // — будет ли существовать нужный объект на момент исполнения программы или нет,
        // и в таких случаях приходится делать проверки на null
        Mockito.when(groupsRepository.getById(groups.getId())).thenReturn(groups);

        //when
        Groups expected = underTest.readOneEntity(groups.getId());

        //then
        Mockito.verify(groupsRepository).getById(groups.getId());
        assertThat(expected).isEqualTo(groups);
    }

    @Test
    void updateEntity() {
        // given
        Groups groups = new Groups();
        groups.setGroupName("IKBO-01-20");
        groups.setId(2L);

        // when
        underTest.updateEntity(groups,groups.getId());

        // then
        Mockito.verify(groupsRepository).save(groups);
    }

    @Test
    void deleteEntity() {
        // given
        Groups groups = new Groups();
        groups.setGroupName("IKBO-01-20");
        groups.setId(2L);

        // when
        underTest.deleteEntity(groups.getId());

        // then
        Mockito.verify(groupsRepository).deleteById(groups.getId());
    }

    @Test
    void sortGroupsByName() {
        // given
        Groups groups = new Groups();
        groups.setGroupName("IKBO-02-20");
        Groups groups2 = new Groups();
        groups2.setGroupName("IKBO-01-20");

        Mockito.when(groupsRepository.findAll(Sort.by("groupName"))).thenReturn(List.of(groups2, groups));

        //when
        List<Groups> expected = underTest.sortGroupsByName();

        //then
        Mockito.verify(groupsRepository).findAll(Sort.by("groupName"));
        assertThat(expected).isNotNull();
        assertThat(expected.size()).isEqualTo(2);
        assertThat(expected.get(0).getGroupName()).isEqualTo("IKBO-01-20");
    }

    @Test
    void filterGroupByFirstName() {
        // given
        Groups groups = new Groups();
        groups.setGroupName("IKBO-01-20");
        Groups groups2 = new Groups();
        groups2.setGroupName("IKBO-02-20");

        Mockito.when(groupsRepository.findAllByGroupNameEquals(groups2.getGroupName())).thenReturn(List.of(groups2));

        //when
        List<Groups> expected = underTest.filterGroupByFirstName(groups2.getGroupName());

        //then
        Mockito.verify(groupsRepository).findAllByGroupNameEquals(groups2.getGroupName());
        assertThat(expected).isNotNull();
        assertThat(expected.size()).isEqualTo(1);
        assertThat(expected.get(0).getGroupName()).isEqualTo("IKBO-02-20");
    }
}