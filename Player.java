public class Player {

  private String playerName = "";
  private double maxHealth = 100.0;
  private double health = 100.0;
  private int money = 100;
  private Weapons playerWeapon;

  public Player(String pName, Weapons pWeapon) {
    this.playerName = pName;
    this.playerWeapon = new Weapons(pWeapon.getWeaponName(), pWeapon.getMoves(), pWeapon.getMovesDamage());
  }

  /* Helps To set a New Player Weapon */
  public void setPlayerWeapon(Weapons newWeapon) {
    this.playerWeapon.setWeaponName(newWeapon.getWeaponName());
    this.playerWeapon.setMoves(newWeapon.getMoves());
    this.playerWeapon.setMovesDamage(newWeapon.getMovesDamage());
  }

  /* Sets and Gets Health */
  public double getHealth() {
    return health;
  }

  public void setHealth(double newHealth) {
    this.health = newHealth;

    if (health > maxHealth) {
      this.health = this.maxHealth;
    }
  }

  public void addHealth(double x) {
    this.health += x;
  }

  public void subtractHealth(double x) {
    this.health -= x;
  }

  /* Sets and Gets Money */
  public double getMoney() {
    return this.money;
  }

  public void setMoney(int newMoney) {
    this.money = newMoney;
  }

  public void addMoney(int x) {
    this.money += x;
  }

  public void subtractMoney(int x) {
    this.money -= x;
  }

  public String[] getWeaponMoveNames() {
    return playerWeapon.getMoves();
  }

  public String getWName() {
    return playerWeapon.getWeaponName();
  }

  public double[] getWeaponMoveDamage() {
    return playerWeapon.getMovesDamage();
  }

  public String toString() {
    return "Your name is " + playerName + ", and your weapon is " + playerWeapon.getWeaponName() + ".";
  }
}