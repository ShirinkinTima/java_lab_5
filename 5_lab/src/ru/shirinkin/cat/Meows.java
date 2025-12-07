package ru.shirinkin.cat;
import java.util.Collection;
import java.util.Random;

public class Meows {
    //default
    public static void meowsCare(Meowable cat){
        if(cat==null){
            throw new NullPointerException("Meowable obj is null");
        }
        Random random = new Random();
        int n = random.nextInt(7) + 1;
        for (int i = 0; i < n; i++) {
            cat.meow();
        }
    }

    //with a numerical value
    public static void meowsCare(Meowable cat, int n){
        if(cat==null){
            throw new NullPointerException("Meowable obj is null");
        }
        if(n!=0){
            for (int i = 0; i < n; i++) {
                cat.meow();
            }
        }
    }

//    //for any meowable
//    public static void meowsCare(Collection<? extends Meowable> meowables) {
//        for (Meowable meowable : meowables) {
//            meowable.meow();
//        }
//    }
}
