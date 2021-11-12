import java.util.Scanner;
/* import java.util.Random; found at https://www.educative.io/edpresso/how-to-generate-random-numbers-in-java */

public class Main {

  // Fist Weapon
  static String[] fistTypes = new String[] { "Uppercut", "Ram-Slam" };
  static double[] fistTypesDamage = new double[] { 12, 20 };
  static Weapons fist = new Weapons("Fist", fistTypes, fistTypesDamage);

  // Magic Weapon
  static String[] magicTypes = new String[] { "Fireball", "Rock-Shower" };
  static double[] magicTypesDamage = new double[] { 12, 20 };
  static Weapons magic = new Weapons("Magic", magicTypes, magicTypesDamage);

  // Sword Weapon
  static String[] swordTypes = new String[] { "Sword-Spin", "Sword-Charge" };
  static double[] swordTypesDamage = new double[] { 12, 20 };
  static Weapons sword = new Weapons("Sword", swordTypes, swordTypesDamage);

  // Test Monster Slime

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // All Monster shall rise here
    String[] teachMTypes = new String[] { "Uppercut", "Ram-Slam" };
    double[] teachMTypesDamage = new double[] { 12.5, 35 };
    Monster teachMonster = new Monster("Random Rock", teachMTypes, teachMTypesDamage, 100.0, 10);

    System.out.print(ConsoleColors.CLEAR);

    /*----Start----*/
    System.out.println(ConsoleColors.BBL + "Welcome To Text-Playing!!");
    System.out.println(ConsoleColors.BL + "A Text based Role-Playing Game. The game was first called \"Text-like\"");
    System.out.println(ConsoleColors.RESET + "");

    TimeSleep(500);

    /*----Enter Hero Name----*/
    System.out.println("Please enter your name hero:");
    String playerName = input.nextLine();
    System.out.println("");

    Player player = new Player(playerName, fist);

    TimeSleep(500);

    /*----Weapon Choices----*/
    // Lets you choose the weapon
    weaponChoices(playerName);

    TimeSleep(500);

    System.out.println("");
    System.out.println("You have " + player.getMoney() + " Chips, which is the money for this game.");
    System.out.println(
        "Choose your starting weapon(Type \"1\" for Sword, \"2\" for Magic, \"3\" for Fist, \"4\" for More Info):");
    System.out.print("Answer: ");
    int playerWeaponChoice = input.nextInt();

    if (playerWeaponChoice == 4) {

    } else {

      setChosenWeapon(playerWeaponChoice, player);
    }

    System.out.println(ConsoleColors.PB + player + ConsoleColors.RESET);

    /* Teach how to fight */
    System.out.println("");

    System.out.print(
        "You are about to fight your first monster. You are going to have to use your attack moves. Like your weapon, "
            + player.getWName() + " has ");
    for (String stats : player.getWeaponMoveNames()) {
      System.out.print(stats + ", ");
    }
    System.out.print("as it's moves. Choose One to Move to attack the Monster");
    fight(player, teachMonster, input);

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
    if (chosenNum == 1) {
      user.setPlayerWeapon(sword);

    } else if (chosenNum == 2) {
      user.setPlayerWeapon(magic);

    } else if (chosenNum == 3) {
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

  private static void fight(Player player, Monster monster, Scanner input) {
    String mName = monster.getName();

    while (true) {
      System.out.println("Your Health is " + player.getHealth());
      System.out.println("It is your turn to attack " + mName + ".");
      System.out.println("Choose one to move(Type 1 for " + player.getWeaponMoveNames()[0] + ", 2 for "
          + player.getWeaponMoveNames()[1] + ").");

      int userChoice = input.nextInt();

      if (userChoice == 1) {
        System.out.println("You did " + player.getWeaponMoveDamage()[0] + " damage to " + mName + ".\n");
        monster.subtractHealth(player.getWeaponMoveDamage()[0]);
      } else if (userChoice == 2) {
        System.out.println("You did " + player.getWeaponMoveDamage()[1] + " damage to " + mName + ".\n");
        monster.subtractHealth(player.getWeaponMoveDamage()[1]);
      } else {
        System.out.println("You did 0 damage to " + mName + ".");
      }

      System.out.println("");
      System.out.println("The " + mName + "'s health is " + monster.getHealth() + ".");
      System.out.println("");

      if (monster.getHealth() <= 0) {
        player.addMoney(monster.onKilled());
        System.out.println("You have won this fight. Your balance is now " + player.getMoney() + ".\n");
        break;
      }

      System.out.println("It is now the " + mName + " turn to attack you.");
      player.subtractHealth(monster.attack());

      if (player.getHealth() <= 0) {
        System.out.println("You have lost this fight to " + mName + ". You are dead. \n---GAME OVER---");
        break;
      }
    }

    if (player.getHealth() <= 0) {
      System.exit(0);
    }
  }
}