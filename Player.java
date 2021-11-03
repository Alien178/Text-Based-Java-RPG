public class Player {

  private String playerName = "";
  private double health = 100.0;
  private int money = 100;
  private Weapons playerWeapon;

  public Player(String pName, Weapons pWeapon) {
    this.playerName = pName;
    this.playerWeapon = new Weapons(pWeapon.getWeaponName(), pWeapon.getMoves(), pWeapon.getMovesDamage());
  }

  public void setPlayerWeapon(Weapons newWeapon) {
    this.playerWeapon.setWeaponName(newWeapon.getWeaponName());
    this.playerWeapon.setMoves(newWeapon.getMoves());
    this.playerWeapon.setMovesDamage(newWeapon.getMovesDamage());
  }

  public String toString() {
    return "Your name is " + playerName + ", and your weapon is " + playerWeapon.getWeaponName() + ".";
  }
}