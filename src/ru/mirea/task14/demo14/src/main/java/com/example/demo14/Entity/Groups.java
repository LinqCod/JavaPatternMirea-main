package com.example.demo14.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//используем Lombok
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Groups {
    private  String  groupName;

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                '}';
    }
}
