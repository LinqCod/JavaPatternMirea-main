package com.example.demo17.tables;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

//используем Lombok
@Entity
@Table(name = "groupsR")
@Setter
@Getter
@NoArgsConstructor
public class Groups {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "groupname")
    private String groupName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "groups")//ссылаемся на Groups параметр
    private List<Student> students;

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                '}';
    }
}
