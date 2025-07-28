package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            BackupCreator.backupFiles("data", "backup");
        } catch (IOException e) {
            System.out.println("Ошибка при копировании: " + e.getMessage());
        }

        int[] field = {1, 2, 0, 3, 2, 1, 0, 0, 1};

        GameFieldIO.writeFieldToFile(field, "game.dat");
        int[] restored = GameFieldIO.readFieldFromFile("game.dat");

        System.out.print("Восстановленное поле: ");
        for (int value : restored) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}