public class Player {

  private String playerName = "";
  private double health = 100.0;
  private Weapons playerWeapon;
  private double playerDamage = 10;

  // All Weapon's Types
  private String[] attackSets = { "Sword", "Magic", "Fist" };
  // private String[] swordAttackSets = { "Spinning", "Charging" };
  // private String[] magicAttackSets = { "Fireball", "Rock Shower" };
  // private String[] fistAttackSets = { "Uppercut", "Ram-Slam" };

  // All Weapon's Damages
  // private double spinning = 20;
  // private double charging = 30;

  // private double fireball = 17.5;
  // private double rockShower = 25;

  // private double uppercut = 12.5;
  // private double ramSlam = 35;

  public Player(String pName, Weapons pWeapon) {
    playerName = pName;
    playerWeapon = new Weapons(pWeapon.getWeaponName(), pWeapon.getMoves(), pWeapon.getMovesDamage());

    begStatsChosen();
  }

  public void setPlayerWeapon(Weapons newWeapon) {
    playerWeapon.setWeaponName(newWeapon.getWeaponName());
    playerWeapon.setMoves(newWeapon.getMoves());
    playerWeapon.setMovesDamage(newWeapon.getMovesDamage());
  }

  private void begStatsChosen() {
    System.out.println("Your name is " + playerName + ", and your weapon is " + playerWeapon.getWeaponName() + ".");
  }

}
