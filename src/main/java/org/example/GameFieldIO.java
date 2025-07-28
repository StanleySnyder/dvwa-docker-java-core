package org.example;

import java.io.*;

public class GameFieldIO {
    public static void writeFieldToFile(int[] field, String filename) throws IOException {
        if (field.length != 9) throw new IllegalArgumentException("Поле должно содержать 9 ячеек");

        int packed = 0;
        for (int i = 0; i < 9; i++) {
            int value = field[i] & 0b11;
            packed |= (value << (i * 2));
        }

        try (OutputStream os = new FileOutputStream(filename)) {
            os.write((packed >> 0) & 0xFF);
            os.write((packed >> 8) & 0xFF);
            os.write((packed >> 16) & 0xFF);
        }

        System.out.println("Поле записано в файл: " + filename);
    }

    public static int[] readFieldFromFile(String filename) throws IOException {
        int packed = 0;

        try (InputStream is = new FileInputStream(filename)) {
            packed |= is.read();
            packed |= is.read() << 8;
            packed |= is.read() << 16;
        }

        int[] field = new int[9];
        for (int i = 0; i < 9; i++) {
            field[i] = (packed >> (i * 2)) & 0b11;
        }

        return field;
    }
}
