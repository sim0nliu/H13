package javabd.labs.h13_generics;

import javabd.labs.h10_inheritance.Human;

public class House<P extends Human> {
    private Human owner;

    public <H extends Human> House(H owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "This house is owned by [" + owner.toString() + "] and it says [" +
                owner.greet() + "].";


//        Use Person.toString Person.greet()
    }
}
