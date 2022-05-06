package ru.mirea.task1;

import java.util.ArrayList;
import java.util.Arrays;

public class TestTaskOne {

    public static void main(String[] args) {
        int[] array = new int[10];

        for (int i = 0; i < 10; i++) {
            array[i]=((int) Math.round((Math.random()*9)));
            //System.out.println(array[i]);
        }

        for (int item: array
             ) {
            System.out.print(item+" ");
        }

        System.out.println();

       SummatorMassive<int[]> doing = new SummatorMassive<int[]>() {
           @Override
           public String sumMas(int[] ints) {
               Arrays.sort(ints);//сортировка

               int first_zero=-1;
               for(int i=0;i<ints.length;i++){
                   if(ints[i]==0){
                       first_zero=i;
                   }
               }

               if (first_zero!=-1) return (Integer.toString(ints[first_zero+1]))+"0";
               if (first_zero==9) return "No";

               int temp=ints[0];
               for(int i=0;i<ints.length;i++){
                   if (ints[i]!=temp){
                       //return "Yes";
                       return (Integer.toString(temp)+Integer.toString(ints[i]));
                   }
               }
               return "No";
           }
       };
        System.out.println();
        System.out.println(doing.sumMas(array));
    }



}
