package com.example.demotask10.components;


import com.example.demotask10.interfaces.Knight;

public class WeakKnight implements Knight {

    @Override
    public void fight() {
        System.out.println("Weak Knight fight");
    }
}
