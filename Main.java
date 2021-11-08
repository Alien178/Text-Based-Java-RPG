import java.util.Scanner;
/* import java.util.Random; found at https://www.educative.io/edpresso/how-to-generate-random-numbers-in-java */

public class Main {

  // Fist Weapon
  static String[] fistTypes = new String[] { "Uppercut", "Ram-Slam" };
  static double[] fistTypesDamage = new double[] { 12.5, 35 };
  static Weapons fist = new Weapons("Fist", fistTypes, fistTypesDamage);

  // Magic Weapon
  static String[] magicTypes = new String[] { "Fireball", "Rock-Shower" };
  static double[] magicTypesDamage = new double[] { 17.5, 25 };
  static Weapons magic = new Weapons("Magic", magicTypes, magicTypesDamage);

  // Sword Weapon
  static String[] swordTypes = new String[] { "Sword-Spin", "Sword-Charge" };
  static double[] swordTypesDamage = new double[] { 20, 30 };
  static Weapons sword = new Weapons("Sword", swordTypes, swordTypesDamage);

  //

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print(ConsoleColors.CLEAR);

    /*----Start----*/
    System.out.println(ConsoleColors.BBL + "Welcome To Text-Playing!!");
    System.out.println(ConsoleColors.BL + "A Text based Role-Playing Game.");
    System.out.println(ConsoleColors.RESET + "");

    TimeSleep(500);

    /*----Enter Hero Name----*/
    System.out.println("Please enter your name hero:");
    String playerName = input.nextLine();
    System.out.println("");

    TimeSleep(500);

    /*----Weapon Choices----*/
    // Lets you choose the weapon
    weaponChoices(playerName);

    TimeSleep(500);

    System.out.println("");
    System.out.println("Choose your starting weapon(Type \"0\" for Sword, \"1\" for Magic, and \"2\" for Fist):");
    System.out.print("Answer: ");
    int playerWeapon = input.nextInt();

    Player player = new Player(playerName, fist);
    setChosenWeapon(playerWeapon, player);

    System.out.println(ConsoleColors.PB + player + ConsoleColors.RESET);

    input.close();
  }

  // This method makes the currently running thread to stop for x amount of time.
  public static void TimeSleep(int x) {
    try {
      Thread.sleep(x);

    } catch (InterruptedException ex) {

      Thread.currentThread().interrupt();
    }
  }

  private static void setChosenWeapon(int chosenNum, Player user) {
    if (chosenNum == 0) {
      user.setPlayerWeapon(sword);

    } else if (chosenNum == 1) {
      user.setPlayerWeapon(magic);

    } else if (chosenNum == 2) {
      user.setPlayerWeapon(fist);

    } else {
      user.setPlayerWeapon(fist);
    }
  }

  private static void weaponChoices(String playerName) {
    System.out.println(ConsoleColors.BB + "Here are your starting weapon choices, " + playerName
        + "(Even attack type has 2 attacks: One normal and one special):");

    TimeSleep(250);

    System.out.println(ConsoleColors.CB + "Sword: " + ConsoleColors.C
        + "Has two types of attack Sword-Spin and Sword-Charge. Spinning does 20 damage. Sword-Charge does 30 damage. The damage value gets decreased from time to time but caps out at a point. There are going to be ways to sharpen your blades.");

    TimeSleep(250);

    System.out.println(ConsoleColors.RB + "Magic: " + ConsoleColors.R
        + "Has two types of attack Fireball and Rock-Shower. Fireball does 17.5 damage. Rock-Shower does 25 damage. The abilities will takes away your more health than the Fist weapon from time to time because you either get hit by a rock or burned by the fireball. There are going to be ways to increase health.");

    TimeSleep(250);

    System.out.println(ConsoleColors.YB + "Fist: " + ConsoleColors.Y
        + "Has two types of attack Uppercut and Ram-Slam. Uppercut does 12.5 damage. Ram-Slam does 35 damage. Takes away your health every time you use Ram-Slam. There are going to be ways to increase health."
        + ConsoleColors.RESET);
  }

  private static void fight(Player player, Monster monster) {
    double pHealth = player.getHealth();
    double mHealth = monster.getHealth();

  }
}