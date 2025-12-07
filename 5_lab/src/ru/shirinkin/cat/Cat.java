package ru.shirinkin.cat;

public class Cat implements Meowable{
    private final String name;

    //properties
    public String getName() {
        return new String(name);
    }

    //constructors
    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void meow() {
        System.out.println(this.getName() + ": Мяу!");
    }

    @Override
    public String toString() {
        return new String("Кот: " + name);
    }

}
