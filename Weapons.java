public class Weapons {
  private String weaponName;
  private String[] attackMoves;
  private double[] damage;

  public Weapons(String wName, String[] aMoves, double[] movesDamage) {
    weaponName = wName;
    attackMoves[0] = aMoves[0];
    attackMoves[1] = aMoves[1];

    damage[0] = movesDamage[0];
    damage[1] = movesDamage[1];
  }

  //Returns The name of the Weapon
  public String getWeaponName() {
    return weaponName;
  }

  //Returns all Moves
  public String[] getMoves() {
    return attackMoves;
  }

  //Returns Moves Damage
  public double[] getMovesDamage() {
    return damage;
  }

  //Returns First Move Name
  public String getMoveOne() {
    return attackMoves[0];
  }

  //Returns First Move Damage
  public double getMoveDamageOne() {
    return damage[0];
  }

  //Returns Second Move Name
  public String getMoveTwo() {
    return attackMoves[1];
  }

  //Returns Second Move Damage
  public double getMoveDamageTwo() {
    return damage[1];
  }

  //Sets the Weapon Name
  public void setWeaponName(String name) {
    this.weaponName = name;
  }

  //Sets all Moves
  public void setMoves(String[] newMoves) {
    this.attackMoves = newMoves;
  }

  //Sets Moves Damage
  public void setMovesDamage(double[] newMovesDamage) {
    this.damage = newMovesDamage;
  }

  //Sets First Move Name
  public void setMoveOne(String name) {
    this.attackMoves[0] = name;
  }

  //Sets First Move Damage
  public void setMoveDamageOne(double damage) {
    this.damage[0] = damage;
  }

  //Sets Second Move Name
  public void setMoveTwo(String name) {
    this.attackMoves[1] = name;
  }

  //Sets Second Move Damage
  public void setMoveDamageTwo(double damage) {
    this.damage[1] = damage;
  }
}
