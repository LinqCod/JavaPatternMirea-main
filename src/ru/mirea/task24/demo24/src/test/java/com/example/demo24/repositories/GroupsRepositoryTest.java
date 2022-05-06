package com.example.demo24.repositories;

import com.example.demo24.tables.Groups;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class GroupsRepositoryTest {

    @Autowired
    private GroupsRepository  underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldFindAllByGroupNameEquals() {
        //given
        Groups groups1 = new Groups();
        groups1.setGroupName("IKBO-01-20");
        underTest.save(groups1);

        Groups groups2 = new Groups();
        groups2.setGroupName("IKBO-02-20");
        underTest.save(groups2);

        //when
        List<Groups> expectedOne = underTest.findAllByGroupNameEquals("IKBO-01-20");
        List<Groups> expectedTwo = underTest.findAllByGroupNameEquals("IKBO-02-20");

        //then
        assertThat(expectedOne).isNotNull();
        assertThat(expectedOne.size()).isEqualTo(1);
        assertThat(expectedOne.get(0).getGroupName()).isEqualTo("IKBO-01-20");

        assertThat(expectedTwo).isNotNull();
        assertThat(expectedTwo.size()).isEqualTo(1);
        assertThat(expectedTwo.get(0).getGroupName()).isEqualTo("IKBO-02-20");

    }

    @Test
    void itShouldNotFindAllByGroupNameEquals() {
        //given
        Groups groups1 = new Groups();
        groups1.setGroupName("IKBO-01-20");
        underTest.save(groups1);

        //when
        List<Groups> expectedThree = underTest.findAllByGroupNameEquals("IKBO-03-20");

        //then

        assertThat(expectedThree).isNotNull();
        assertThat(expectedThree.size()).isEqualTo(0);
    }
}