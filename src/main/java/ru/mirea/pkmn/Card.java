package ru.mirea.pkmn;

import java.io.Serializable;
import java.util.List;

public class Card implements Serializable {
    private static final long serialVersionUID = 1L;

    private PokemonStage pokemonStage;
    private String name;
    private int hp;
    private EnergyType pokemonType;
    private Card evolvesFrom;
    private List<AttackSkill> skills;
    private EnergyType weaknessType;
    private int weaknessMultiplier;
    private EnergyType resistanceType;
    private String retreatCost;
    private String gameSet;
    private char regulationMark;
    private Student pokemonOwner;

    public Card() {
    }
    public Card(String name) {
        this.name = name;
    }
    public PokemonStage getPokemonStage() {
        return pokemonStage;
    }
    public void setPokemonStage(PokemonStage pokemonStage) {
        this.pokemonStage = pokemonStage;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public EnergyType getPokemonType() {
        return pokemonType;
    }
    public void setPokemonType(EnergyType pokemonType) {
        this.pokemonType = pokemonType;
    }
    public Card getEvolvesFrom() {
        return evolvesFrom;
    }
    public void setEvolvesFrom(Card evolvesFrom) {
        this.evolvesFrom = evolvesFrom;
    }
    public List<AttackSkill> getSkills() {
        return skills;
    }
    public void setSkills(List<AttackSkill> skills) {
        this.skills = skills;
    }
    public EnergyType getWeaknessType() {
        return weaknessType;
    }
    public void setWeaknessType(EnergyType weaknessType) {
        this.weaknessType = weaknessType;
    }
    public int getWeaknessMultiplier() {
        return weaknessMultiplier;
    }
    public void setWeaknessMultiplier(int weaknessMultiplier) {
        this.weaknessMultiplier = weaknessMultiplier;
    }
    public EnergyType getResistanceType() {
        return resistanceType;
    }
    public void setResistanceType(EnergyType resistanceType) {
        this.resistanceType = resistanceType;
    }
    public String getRetreatCost() {
        return retreatCost;
    }
    public void setRetreatCost(String retreatCost) {
        this.retreatCost = retreatCost;
    }
    public String getGameSet() {
        return gameSet;
    }
    public void setGameSet(String gameSet) {
        this.gameSet = gameSet;
    }
    public char getRegulationMark() {
        return regulationMark;
    }
    public void setRegulationMark(char regulationMark) {
        this.regulationMark = regulationMark;
    }
    public Student getPokemonOwner() {
        return pokemonOwner;
    }
    public void setPokemonOwner(Student pokemonOwner) {
        this.pokemonOwner = pokemonOwner;
    }
    @Override
    public String toString() {
        return "Card{" +
                "pokemonStage=" + pokemonStage +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", pokemonType=" + pokemonType +
                ", evolvesFrom=" + evolvesFrom +
                ", skills=" + skills +
                ", weaknessType=" + weaknessType +
                ", weaknessMultiplier=" + weaknessMultiplier +
                ", resistanceType=" + resistanceType +
                ", retreatCost='" + retreatCost + '\'' +
                ", gameSet='" + gameSet + '\'' +
                ", regulationMark=" + regulationMark +
                ", pokemonOwner=" + pokemonOwner +
                '}';
    }
}