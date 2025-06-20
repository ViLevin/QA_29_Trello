package utils;

import java.util.Random;

public class RandomUtils {
    static Random random = new Random();

    public static String generateString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        char[] randomeString = new char[length];
        int index = 0;
        int charLength = characters.length();
        for (int i = 0; i < length; i++) {
            index = random.nextInt(charLength);
            randomeString[i] = characters.charAt(index);
        }
        return new String(randomeString);
    }
}
