package ua.javaextern.aleksandr.droidtask.droid;

import ua.javaextern.aleksandr.droidtask.strategy.AttackStrategy;

import java.io.Serializable;

public abstract class Droid implements Serializable {

    private int attackValue;
    private int armorValue;
    private int healthValue;
    private String name;
    private AttackStrategy attackStrategy;

    public Droid(){

    }

    public Droid(String name, int attackValue, int armorValue, int healthValue, AttackStrategy attackStrategy) {
        this.name = name;
        this.attackValue = attackValue;
        this.armorValue = armorValue;
        this.healthValue = healthValue;
        this.attackStrategy = attackStrategy;
    }

    abstract void speak();

    public void attackMove(Droid droid) {
        this.attackStrategy.attack(droid,attackValue);
    }

    public boolean isAlive() {
        return healthValue > 0;
    }
    public int getArmorValue() {
        return armorValue;
    }
    public void setArmorValue(int newValue) {
        armorValue = newValue;
    }
    public int getHealthValue() {
        return healthValue;
    }
    public void setHealthValue(int newValue) {
        healthValue = newValue;
    }
    public String getName() {
        return name;
    }
}
