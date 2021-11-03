public class Weapons {
  private String weaponName;
  private String[] attackMoves;
  private double[] damage;

  public Weapons(String wName, String[] aMoves, double[] movesDamage) {
    weaponName = wName;
    this.attackMoves = aMoves;
    this.damage = movesDamage;
  }

  // Returns The name of the Weapon
  public String getWeaponName() {
    return this.weaponName;
  }

  // Returns all Moves
  public String[] getMoves() {
    return this.attackMoves;
  }

  // Returns Moves Damage
  public double[] getMovesDamage() {
    return this.damage;
  }

  // Returns First Move Name
  public String getMoveOne() {
    return this.attackMoves[0];
  }

  // Returns First Move Damage
  public double getMoveDamageOne() {
    return this.damage[0];
  }

  // Returns Second Move Name
  public String getMoveTwo() {
    return this.attackMoves[1];
  }

  // Returns Second Move Damage
  public double getMoveDamageTwo() {
    return this.damage[1];
  }

  // Sets the Weapon Name
  public void setWeaponName(String name) {
    this.weaponName = name;
  }

  // Sets all Moves
  public void setMoves(String[] newMoves) {
    this.attackMoves = newMoves;
  }

  // Sets Moves Damage
  public void setMovesDamage(double[] newMovesDamage) {
    this.damage = newMovesDamage;
  }

  // Sets First Move Name
  public void setMoveOne(String name) {
    this.attackMoves[0] = name;
  }

  // Sets First Move Damage
  public void setMoveDamageOne(double damage) {
    this.damage[0] = damage;
  }

  // Sets Second Move Name
  public void setMoveTwo(String name) {
    this.attackMoves[1] = name;
  }

  // Sets Second Move Damage
  public void setMoveDamageTwo(double damage) {
    this.damage[1] = damage;
  }

  public String toString() {
    return "Name: " + weaponName + "\nType One: " + attackMoves[0] + "\nType One Damage: " + damage[0] + "\nType Two: "
        + attackMoves[1] + "\nType Two Damage: " + damage[1];
  }
}