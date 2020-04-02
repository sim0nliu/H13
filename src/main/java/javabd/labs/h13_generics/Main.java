package javabd.labs.h13_generics;

import javabd.labs.h10_inheritance.Android;
import javabd.labs.h10_inheritance.Human;
import javabd.labs.h10_inheritance.Person;

public class Main {
    public static void main(String[] args) {
        House<Person> hp;
        House<Android> ha;
//        House<String> string; //Dit werkt niet

        Human owner = new Person("Piet", 10);
        hp = new House<Person>(owner);

        Human servant = new Android();
        ha = new House<Android>(servant);
        System.out.println(ha);
        System.out.println(hp);
    }
}
