package ru.mirea.pkmn.krotovma;

import ru.mirea.pkmn.Card;

import java.io.*;

public class PkmnApplication {

    public static void main(String[] args) {
        CardImport importer = new CardImport();
        System.out.println("Beartic:");
        Card mainCard = loadCard(importer, "src/main/resources/my_card.txt");
        String firstCardFilePath = readLinkFromMainCard("src/main/resources/my_card.txt");
        if (firstCardFilePath != null) {
            System.out.println("Cubchoo:");
            loadCard(importer, firstCardFilePath);
        } else {
            System.out.println("Ссылка на первый файл не найдена.");
        }
        System.out.println("\nИмпортируемая карта:");
        loadCardFromBinary("src/main/resources/Glastrier.crd");
    }
    private static Card loadCard(CardImport importer, String filePath) {
        Card card = importer.importCards(filePath);
        if (card != null) {
            System.out.println(card);
            saveCardToBinary(card);
        }
        return card;
    }
    private static void saveCardToBinary(Card card) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(card.getName() + ".crd"))) {
            oos.writeObject(card);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении карты в бинарный файл: " + e.getMessage());
        }
    }
    private static void loadCardFromBinary(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Card card = (Card) ois.readObject();
            System.out.println(card);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при чтении карты из бинарного файла: " + e.getMessage());
        }
    }
    private static String readLinkFromMainCard(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            for (int i = 0; i < 5; i++) {
                line = br.readLine();
                if (i == 4 && line != null) {
                    return line;
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return null;
    }
}