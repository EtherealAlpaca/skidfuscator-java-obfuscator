package dev.skidfuscator.obfuscator.util;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class RandomUtil {
    private final Random random = new Random();

    public int nextInt() {
        return nextInt(Integer.MAX_VALUE);
    }

    public int nextInt(int bound) {
        return random.nextInt(bound);
    }

    public String randomIsoString(int size) {
        final int leftLimit = 48; // numeral '0'
        final int rightLimit = 122; // letter 'z'
        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(size)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public String randomAlphabeticalString(int size) {
        final int leftLimit = 97; // letter 'a'
        final int rightLimit = 122; // letter 'z'

        return random.ints(leftLimit, rightLimit + 1)
                .limit(size)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}