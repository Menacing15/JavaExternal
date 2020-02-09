package ua.javaextern.aleksandr.droids;

public abstract class Droid {
    private int attackValue;
    private int armorValue;
    private int healthValue;
    private String name;

    private String currentDefensePosition ;

    public Droid(String name ,int attack, int armor, int health, String defPos) {
        this.name = name;
        attackValue = attack;
        armorValue = armor;
        healthValue = health;
        currentDefensePosition = defPos;
    }

    abstract void move();
    abstract void work();
    abstract void speak();

    public void attack(Droid droid, String attackedPart) {
        if(attackedPart.equals("head") || attackedPart.equals("chest") || attackedPart.equals("legs")){
            System.out.println(name + " attacks " + droid.name + "...");
            if (droid.currentDefensePosition.equals(attackedPart) && armorValue > 0) {
                droid.armorValue = droid.armorValue - attackValue;
            } else {
                droid.healthValue = droid.healthValue - attackValue;
            }
            resultAfterAttack(droid);
        }else {
            System.out.println(name + " misses!");
        }
    }

    public void defend(String part){
        if(part.equals("head") || part.equals("chest") || part.equals("legs")) {
            currentDefensePosition = part;
        }
    }

    private void resultAfterAttack(Droid droid) {
        if (droid.armorValue <= 0) {
            droid.armorValue = 0;
        }
        if (!isAlive(droid)) {
            System.out.println("Droid " + droid.name + " is no longer working");
        } else {
            System.out.println(droid.name + " is still alive with health: " + droid.healthValue
                    + " ,and armor: " + droid.armorValue);
        }
    }

    private boolean isAlive(Droid droid){
        return droid.healthValue > 0;
    }

    public void powerup(){
        System.out.println("finally, some good ******* food");
        armorValue = armorValue + 150;
        healthValue = healthValue + 150;
    }

}
