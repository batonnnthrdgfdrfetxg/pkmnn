package ru.mirea.pkmn.krotovma;

import ru.mirea.pkmn.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CardImport {
    public Card importCards(String filePath) {
        Card card = new Card();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            line = br.readLine();
            if (line != null && !line.isEmpty()) {
                card.setPokemonStage(PokemonStage.valueOf(line));
            } else {
                throw new IllegalArgumentException("Missing Pokemon Stage");
            }
            line = br.readLine();
            if (line != null && !line.isEmpty()) {
                card.setName(line);
            } else {
                throw new IllegalArgumentException("Missing Pokemon Name");
            }
            line = br.readLine();
            if (line != null && !line.isEmpty()) {
                card.setHp(Integer.parseInt(line));
            } else {
                throw new IllegalArgumentException("Missing Pokemon HP");
            }
            line = br.readLine();
            if (line != null && !line.isEmpty()) {
                card.setPokemonType(EnergyType.valueOf(line));
            } else {
                throw new IllegalArgumentException("Missing Pokemon Type");
            }
            line = br.readLine();
            if (line != null && !line.isEmpty() && !line.equals("-")) {
                CardImport cardImport2 = new CardImport();
                Card card2 = cardImport2.importCards(line);
                card.setEvolvesFrom(card2);
            }
            line = br.readLine();
            if (line != null && !line.isEmpty()) {
                String[] skillLines = line.split(", ");
                List<AttackSkill> skills = new ArrayList<>();
                for (String skillLine : skillLines) {
                    String[] skillData = skillLine.split(" / ");
                    skills.add(new AttackSkill(skillData[1], "", skillData[0], Integer.parseInt(skillData[2])));
                }
                card.setSkills(skills);
            } else {
                throw new IllegalArgumentException("Missing Pokemon Skills");
            }
            line = br.readLine();
            if (line != null && !line.isEmpty()) {
                String[] weaknessParts = line.split("x"); // Разделяем по "x"
                card.setWeaknessType(EnergyType.valueOf(weaknessParts[0])); // Первый элемент — тип энергии
            }
            line = br.readLine();
            if (line != null && !line.isEmpty() && !line.equals("-")) {
                card.setResistanceType(EnergyType.valueOf(line));
            }
            line = br.readLine();
            if (line != null && !line.isEmpty()) {
                card.setRetreatCost(line);
            }
            line = br.readLine();
            if (line != null && !line.isEmpty()) {
                card.setGameSet(line);
            }
            line = br.readLine();
            if (line != null && !line.isEmpty()) {
                card.setRegulationMark(line.charAt(0));
            }
            line = br.readLine();
            if (line != null && !line.isEmpty()) {
                String[] ownerData = line.split(" / ");
                card.setPokemonOwner(new Student(ownerData[0], ownerData[1], ownerData[2], ownerData[3]));
            }
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Error while importing card: " + e.getMessage());
        }
        return card;
    }
    public Card importCardByte(String filename) {
        Card card = null;
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            card = (Card) objectIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error while importing card: " + e.getMessage());
        }
        return card;
    }
}