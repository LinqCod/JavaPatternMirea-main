package ru.mirea.task6.Prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Вы можете добавить в программу фабрику прототипов, которая будет хранить каталог прототипов.
 * Таким образом, вы сможете запрашивать у фабрики новые объекты, описывая нужные вам свойства.
 * Фабрика будет искать соответствующий прототип в кеше и возвращать вам копию.
 * **/
public class PensilStore {
    private static Map<String, Pencil> colorMap = new HashMap<String, Pencil>();

    static
    {
        colorMap.put("blue", new BluePencil());
        colorMap.put("red", new RedPencil());
    }

    public static Pencil getPencil(String colorName)
    {
        return (Pencil) colorMap.get(colorName).clone();
    }
}
