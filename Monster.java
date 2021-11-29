import java.util.Random;

public class Monster {

    private String monsterName;
    private String[] monsterMoves;
    private double[] damage;
    private double monsterHealth;
    private double monsterMaxHealth;
    private static int monstersKilled;
    private int killBenefits;

    Random rand = new Random();

    public Monster(String mName, String[] mMoves, double[] mDamage, double health, int benefits) {
        this.monsterName = mName;
        this.monsterMoves = mMoves;
        this.damage = mDamage;
        this.monsterHealth = health;
        this.killBenefits = benefits;
    }

    /* Returns the Monsters Health */
    public String getName() {
        return this.monsterName;
    }

    /* Monster's Attack Function */
    public double attack() {
        int maxInt = 4;
        int randAttack = rand.nextInt(maxInt);

        if (randAttack == 0) {
            return damage[0];
        } else if (randAttack == 1) {
            return damage[1];
        } else if (randAttack == 2) {
            return 0.0;
        } else {
            addHealth(rand.nextInt(74));
            return 0.17845;
        }
    }

    /* Returns Current Health of the Monster */
    public double getHealth() {
        return monsterHealth;
    }

    /* Sets Health */
    public void setHealth(double newHealth) {
        this.monsterHealth = newHealth;
    }

    /* Adds Health */
    public void addHealth(double x) {
        this.monsterHealth += x;

        if (this.monsterHealth > this.monsterMaxHealth) {
            this.monsterHealth = this.monsterMaxHealth;
        }
    }

    /* Subtracts Health */
    public void subtractHealth(double x) {
        this.monsterHealth -= x;
    }

    /* Returns money to the player after monster killed */
    public int onKilled() {
        return this.killBenefits;
    }
}