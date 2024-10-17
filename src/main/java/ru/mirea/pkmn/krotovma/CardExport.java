package ru.mirea.pkmn.krotovma;

import ru.mirea.pkmn.Card;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CardExport {
    public void exportCard(Card card, String filename) {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(card);
            System.out.println("Карта успешно экспортирована в " + filename);
        } catch (IOException e) {
            System.err.println("Ошибка при экспорте карты: " + e.getMessage());
        }
    }
}