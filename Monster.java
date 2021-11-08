import java.util.Random;

public class Monster {

    private String monsterName;
    private String[] monsterMoves;
    private double[] damage;
    private double health;
    private static int monstersKilled;
    Random rand = new Random();

    public Monster(String mName, String[] mMoves, double[] mDamage, double health) {
        this.monsterName = mName;
        this.monsterMoves = mMoves;
        this.damage = mDamage;
        this.health = health;
    }

    public double attack() {
        int maxInt = 3;
        int randAttack = rand.nextInt(maxInt);

        if (randAttack == 0) {
            return damage[0];
        } else if (randAttack == 1) {
            return damage[1];
        }

        return 0.0;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double newHealth) {
        this.health = newHealth;
    }

    public int onKilled() {
        return 10;
    }
}
