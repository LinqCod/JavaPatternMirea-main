package com.example.demo20.repositories;

import com.example.demo20.tables.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//!имена используем, что предлагает идея, иначе ошибку не найдем даже
@Repository
public interface GroupsRepository extends JpaRepository<Groups, Long> {
    List<Groups> findAllByGroupNameEquals(String groupName);
}
