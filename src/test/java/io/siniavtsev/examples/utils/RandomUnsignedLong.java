package io.siniavtsev.examples.utils;

import java.util.Random;

public class RandomUnsignedLong {

    public static Long randomUnsignedLong() {
        return new Random().nextLong(1L, Long.MAX_VALUE);
    }
}
