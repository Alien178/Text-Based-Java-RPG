import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    //Fist Weapon
    String[] fistTypes = new String[] {"Uppercut", "Ram-Slam"};
    double[] fistTypesDamage = new double[] {12.5, 35};
    Weapons fist = new Weapons("Fist", fistTypes, fistTypesDamage);

    //Magic Weapon
    String[] magicTypes = new String[] {"Fireball", "Rock-Shower"};
    double[] magicTypesDamage = new double[] {17.5, 25};
    Weapons magic = new Weapons("Fist", magicTypes, magicTypesDamage);

    //Sword Weapon
    String[] swordTypes = new String[] {"Sword-Spin", "Sword-Charge"};
    double[] swordTypesDamage = new double[] {20, 30};
    Weapons sword = new Weapons("Fist", swordTypes, swordTypesDamage);

    


    /*----Start----*/
    System.out.println("Welcome To Textlike!!");
    System.out.println("A game that is a Text based RPG game.");
    System.out.println("");

    TimeSleep(500);

    /*----Enter Hero Name----*/
    System.out.println("Please enter your name hero:");
    String playerName = input.nextLine();
    System.out.println("");

    TimeSleep(500);

    /*----Choose Weapon----*/
    System.out.println(ConsoleColors.BB + "Here are your starting weapon choices, " + playerName
        + "(Even attack type has 2 attacks: One normal and one special):");
    System.out.println(ConsoleColors.CB
        + "Sword: Has two types of attack Sword-Spin and Sword-Charge. Spinning does 20 damage. Sword-Charge does 30 damage. The damage value gets decreased from time to time but caps out at a point. There are going to be ways to sharpen your blades.");
    System.out.println(ConsoleColors.RB
        + "Magic: Has two types of attack Fireball and Rock-Shower. Fireball does 17.5 damage. Rock-Shower does 25 damage. The abilities will takes away your more health than the Fist weapon from time to time because you either get hit by a rock or burned by the fireball. There are going to be ways to increase health.");
    System.out.println(ConsoleColors.YB
        + "Fist: Has two types of attack Uppercut and Ram-Slam. Uppercut does 12.5 damage. Ram-Slam does 35 damage. Takes away your health every time you use Ram-Slam. There are going to be ways to increase health."
        + ConsoleColors.RESET);

    TimeSleep(500);

    System.out.println("");
    System.out.println("Choose your starting weapon(Type Sword, Magic, and Fist):");
    String playerWeapon = input.nextLine();
    playerWeapon.toUpperCase();

    Player player = new Player(playerName, sword);
  }

  // This method makes the currently running thread to stop for x amount of time.
  public static void TimeSleep(int x) {
    try {
      Thread.sleep(x);

    } catch (InterruptedException ex) {

      Thread.currentThread().interrupt();
    }
  }
}
