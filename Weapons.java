public class Weapons {
  private String weaponName;
  private double weaponDamage;
  private String[][] attackType;
  private int defectType;

  public Weapons(String wName, double wDamage, String[] typeOne, String[] typeTwo, int dType) {
    weaponName = wName;
    weaponDamage = wDamage;
    attackType[0][0] = typeOne[0];
    attackType[1][0] = typeOne[1];

    attackType[0][1] = typeTwo[0];
    attackType[1][1] = typeTwo[1];
    defectType = dType;
  }

  public String getWeaponName() {
    return weaponName;
  }

  public double getWeaponDamage() {
    return weaponDamage;
  }

  public String getAttackTypeOne() {
    return attackType[0][0];
  }

  public String getAttackTypeTwo() {
    return attackType[1][1];
  }
}
