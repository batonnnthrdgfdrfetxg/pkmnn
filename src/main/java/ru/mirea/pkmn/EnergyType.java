package ru.mirea.pkmn;

public enum EnergyType {
    FIRE, GRASS, WATER, LIGHTNING, PSYCHIC, FIGHTING, DARKNESS, METAL, FAIRY, DARK, DRAGON, COLORLESS;
    @Override
    public String toString() {
        return name();
    }
}