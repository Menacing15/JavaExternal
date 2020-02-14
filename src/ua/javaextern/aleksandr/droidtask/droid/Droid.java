package ua.javaextern.aleksandr.droidtask.droid;

public abstract class Droid {

    private int attackValue;
    private int armorValue;
    private int healthValue;
    private String name;


    public Droid(String name, int attackValue, int armorValue, int healthValue) {
        this.name = name;
        this.attackValue = attackValue;
        this.armorValue = armorValue;
        this.healthValue = healthValue;
    }

    abstract void move();
    abstract void work();
    abstract void speak();

    public void attackMovement(Droid droid) {
        if (droid.armorValue > 0) {
            droid.armorValue = droid.armorValue - attackValue / 2;
        } else {
            droid.healthValue = droid.healthValue - attackValue;
        }
    }

    public boolean isAlive() {
        return healthValue > 0;
    }

    public int getArmorValue() {
        return armorValue;
    }
    public int getHealthValue() {
        return healthValue;
    }
    public String getName() {
        return name;
    }
}
