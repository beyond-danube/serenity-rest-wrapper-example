package io.siniavtsev.examples.utils;

import java.util.Random;

public class RandomEnumValue {

    public static <T extends Enum<?>> T randomEnumValue(Class<T> clazz){
        var random  = new Random();
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
