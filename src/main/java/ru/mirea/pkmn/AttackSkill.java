package ru.mirea.pkmn;

import java.io.Serializable;

public class AttackSkill implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String description;
    private String cost;
    private int damage;
    public AttackSkill(String name, String description, String cost, int damage) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.damage = damage;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCost() {
        return cost;
    }
    public void setCost(String cost) {
        this.cost = cost;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    @Override
    public String toString() {
        return String.format("%s / %s / %d", cost, name, damage);
    }
}