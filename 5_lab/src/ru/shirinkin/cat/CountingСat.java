package ru.shirinkin.cat;

public class CountingСat implements Meowable{
    private final Meowable cat;
    private int count;

    //properties
    public int getCount() {
        return count;
    }

    //constructors
    public CountingСat(Meowable cat) {
        this.cat = cat;
    }

    //methods
    @Override
    public void meow() {
        cat.meow();
        count++;
    }

    public void resetCount() {
        count = 0;
    }

    @Override
    public String toString() {
        return cat.toString() + " мяукнул " + count + " раз(a)";
    }

}
