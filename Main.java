import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {

  // Fist Weapon
  static String[] fistTypes = new String[] { "Uppercut", "Ram-Slam" };
  static double[] fistTypesDamage = new double[] { 12.5, 35 };
  static Weapons fist = new Weapons("Fist", fistTypes, fistTypesDamage, 0);

  // Magic Weapon
  static String[] magicTypes = new String[] { "Fireball", "Rock-Shower" };
  static double[] magicTypesDamage = new double[] { 17.5, 25 };
  static Weapons magic = new Weapons("Magic", magicTypes, magicTypesDamage, 25);

  // Sword Weapon
  static String[] swordTypes = new String[] { "Sword-Spin", "Sword-Charge" };
  static double[] swordTypesDamage = new double[] { 20, 30 };
  static Weapons sword = new Weapons("Sword", swordTypes, swordTypesDamage, 30);

  static ArrayList<Object> playerHistory = new ArrayList<Object>();
  static Random rand = new Random();

  // Test Monster Slime

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // All Monster shall rise here
    String[] teachMTypes = new String[] { "Rock Punch", "Rock-Slam" };
    double[] teachMTypesDamage = new double[] { 5, 10 };
    Monster teachMonster = new Monster("Random Rock", teachMTypes, teachMTypesDamage, 100.0, 10);

    String[] goblinTypes = new String[] { "Goblin Punch", "Goblin Throw" };
    double[] goblinTypesDamage = new double[] { 7.5, 12.5 };
    Monster goblin = new Monster("Goblin", goblinTypes, goblinTypesDamage, 100.0, 20);

    String[] slimeTypes = new String[] { "Slime Swallow", "Slime Mega-Pound" };
    double[] slimeTypesDamage = new double[] { 6, 10 };
    Monster slime = new Monster("Slime", slimeTypes, slimeTypesDamage, 100.0, 20);

    String[] ninjaTypes = new String[] { "Ninja Star", "Super Ninja" };
    double[] ninjaTypesDamage = new double[] { 10, 20 };
    Monster ninja = new Monster("Ninja", ninjaTypes, ninjaTypesDamage, 200.0, 50);

    String[] sageTypes = new String[] { "Sage Punch", "Super Sage" };
    double[] sageTypesDamage = new double[] { 12.5, 25 };
    Monster sage = new Monster("Sage", sageTypes, sageTypesDamage, 150.0, 35);

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

    playerHistory.add(playerName);

    Player player = new Player(playerName, fist);

    TimeSleep(500);

    /*----Weapon Choices----*/
    // Lets you choose the weapon
    weaponChoices(player);

    TimeSleep(500);

    while (true) {
      System.out.println("You have " + player.getMoney() + " Chips, which is the money for this game.");
      System.out.println(
          "Choose your starting weapon(Type \"1\" for Sword, \"2\" for Magic, \"3\" for Fist, \"4\" for More Info):");
      System.out.print("Answer: ");
      int playerWeaponChoice = input.nextInt();

      if (playerWeaponChoice == 4) {
        weaponChoices(player);
      } else {
        setChosenWeapon(playerWeaponChoice, player);
        break;
      }
    }

    System.out.println(player + ConsoleColors.RESET);

    TimeSleep(2000);

    /* Teach how to fight */
    System.out.println("");

    System.out.print(
        "You are about to fight your first monster. You are going to have to use your attack moves. Like your weapon, "
            + player.getWName() + " has ");
    for (String stats : player.getWeaponMoveNames()) {
      System.out.print(stats + ", ");
    }

    System.out.println("as it's moves. Choose One to Move to attack the Monster. ");
    fight(player, teachMonster, input);

    teachMonster.setHealth(100);

    chooseRoutes(player, goblin, slime, input);

    chooseRoutes(player, ninja, sage, input);

    chooseRoutes(player, sage, slime, input);

    chooseRoutes(player, slime, ninja, input);

    System.out.println("You have beaten the game. Congrats!!! \nTHE END!!!");

    input.close();
  }

  public static void chooseRoutes(Player player, Monster mOne, Monster mTwo, Scanner input) {

    TimeSleep(1000);
    System.out.println("You see two doors");
    TimeSleep(1000);
    System.out.println("The First Door is made of Gold." + "The Second Door is made of Bronze.");
    TimeSleep(1000);
    System.out.println("You hear terrifying voice from both doors. Which one will you choose?");

    System.out.println("");

    System.out.println("Type 1 for Golden Door or 2 for Bronze Door or 3 to exit the game.");

    int playerChoice = input.nextInt();

    if (playerChoice == 1) {
      playerHistory.add("Golden Door");

      System.out.println("The Door Opens...");
      System.out.println("You enter the room and a monster jumps out at you.");
      System.out.println("You see that its a " + mOne.getName() + " and you get ready to fight.");
      playerHistory.add("Fighting " + mOne.getName());

      fight(player, mOne, input);

    } else if (playerChoice == 2) {
      playerHistory.add("Bronze Door");

      int random = rand.nextInt(15);

      if (random == 9) {
        System.out.println("The Door Opens...");
        System.out.println("You see a msyterious shop and you approach it with caution.");
        System.out.println("There is a shopkeeper, which looks like a turtle.");
        System.out.println("You approach the shopkeeper");
        System.out.println("The shopkeeper says: \"Welcome to Weapon Switch...\" ");
        System.out.println("You can switch you weapons here.");
        System.out.println("Do you want to switch weapons? (1 for Yes or 2 for No)");

        while (true) {
          playerChoice = input.nextInt();

          if (playerChoice == 1) {
            weaponChoices(player);

            playerChoice = input.nextInt();

            setChosenWeapon(playerChoice, player);

          } else if (playerChoice == 2) {
            playerHistory.add("Golden Door");

            System.out.println("You enter the other door.");
            System.out.println("The Door Opens...");
            System.out.println("You enter the room and a monster jumps out at you.");
            System.out.println("You see that its a " + mOne.getName() + " and you get ready to fight.");
            playerHistory.add("Fighting " + mOne.getName());

            fight(player, mOne, input);
            break;

          }
        }

      } else {
        System.out.println("The Door Opens...");
        System.out.println("You enter the room and a monster jumps out at you.");
        System.out.println("You see that its a " + mTwo.getName() + " and you get ready to fight.");
        playerHistory.add("Fighting " + mTwo.getName());

        fight(player, mTwo, input);
      }

    } else {
      System.exit(0);
    }
  }

  // This method makes the currently running thread to stop for x amount of time.
  public static void TimeSleep(int x) {
    try {
      Thread.sleep(x);

    } catch (InterruptedException ex) {

      Thread.currentThread().interrupt();
    }
  }

  // Sets the Weapon and Subtracts Money
  private static void setChosenWeapon(int chosenNum, Player user) {
    if (chosenNum == 1) {
      user.setPlayerWeapon(sword);
      user.subtractMoney(30);
      playerHistory.add(sword);

    } else if (chosenNum == 2) {
      user.setPlayerWeapon(magic);
      user.subtractMoney(25);
      playerHistory.add(magic);

    } else if (chosenNum == 3) {
      user.setPlayerWeapon(fist);
      playerHistory.add(fist);

    } else {
      user.setPlayerWeapon(fist);
      playerHistory.add(fist);
    }
  }

  // Weapons Choices
  private static void weaponChoices(Player player) {
    System.out.println("");
    System.out.println(ConsoleColors.BB + "Here are your weapon choices, " + player.getName()
        + ":");

    TimeSleep(250);

    // System.out.println(ConsoleColors.CB + "Sword: " + ConsoleColors.YB + "Cost:
    // 30 Chips. " + ConsoleColors.C
    // + "\nHas two types of attack Sword-Spin and Sword-Charge. \nSword-Spin: 20
    // damage \nSword-Charge: 30 damage \nThe damage value gets decreased from time
    // to time but caps out at a point. There are going to be ways to sharpen your
    // blades.\n");

    System.out.println(ConsoleColors.CB + "-----Sword-----");
    System.out.println(ConsoleColors.YB + "Cost: " + ConsoleColors.Y + sword.getWeaponCost());
    System.out.println(ConsoleColors.RB + sword.getMoveOne() + ": " + ConsoleColors.R + sword.getMoveDamageOne());
    System.out.println(ConsoleColors.RB + sword.getMoveTwo() + ": " + ConsoleColors.R + sword.getMoveDamageTwo());
    System.out.println(ConsoleColors.GB + "Facts: " + ConsoleColors.G
        + "The damage value gets decreased from time to time but caps out at a point. There are going to be ways to sharpen your blades.\n");

    TimeSleep(250);

    // System.out.println(ConsoleColors.RB + "Magic: " + ConsoleColors.R + "Has two
    // types of attack Fireball and Rock-Shower. Fireball does 17.5 damage.
    // Rock-Shower does 25 damage. The abilities will takes away your more health
    // than the Fist weapon from time to time because you either get hit by a rock
    // or burned by the fireball. There are going to be ways to increase health.");

    System.out.println(ConsoleColors.CB + "-----Magic-----");
    System.out.println(ConsoleColors.YB + "Cost: " + ConsoleColors.Y + magic.getWeaponCost());
    System.out.println(ConsoleColors.RB + magic.getMoveOne() + ": " + ConsoleColors.R + magic.getMoveDamageOne());
    System.out.println(ConsoleColors.RB + magic.getMoveTwo() + ": " + ConsoleColors.R + magic.getMoveDamageTwo());
    System.out.println(ConsoleColors.GB + "Facts: " + ConsoleColors.G
        + "The abilities will takes away your more health than the Fist weapon from time to time because you either get hit by a rock or burned by the fireball. There are going to be ways to increase health.\n");

    TimeSleep(250);

    // System.out.println(ConsoleColors.GB + "Fist: " + ConsoleColors.G + "Has two
    // types of attack Uppercut and Ram-Slam. Uppercut does 12.5 damage. Ram-Slam
    // does 35 damage. Takes away your health every time you use Ram-Slam. There are
    // going to be ways to increase health." + ConsoleColors.RESET);

    System.out.println(ConsoleColors.CB + "-----Fist-----");
    System.out.println(ConsoleColors.YB + "Cost: " + ConsoleColors.Y + fist.getWeaponCost());
    System.out.println(ConsoleColors.RB + fist.getMoveOne() + ": " + ConsoleColors.R + fist.getMoveDamageOne());
    System.out.println(ConsoleColors.RB + fist.getMoveTwo() + ": " + ConsoleColors.R + fist.getMoveDamageTwo());
    System.out.println(ConsoleColors.GB + "Facts: " + ConsoleColors.G
        + "Takes away your health every time you use Ram-Slam. There are going to be ways to increase health.\n"
        + ConsoleColors.RESET);
  }

  // Fight Scene between Player and the Monster
  private static void fight(Player player, Monster monster, Scanner input) {
    String mName = monster.getName();
    double mAttack;
    double pWDamage = 102.0;

    while (true) {
      // Prints Player's health
      System.out.println(ConsoleColors.RB + "\n" + "Your Health is " + player.getHealth());

      // Prints the turn
      System.out.println(ConsoleColors.GB + "\nIt is your turn to attack " + mName + ".");

      // Prints the Player's attacks
      System.out.println(ConsoleColors.PB + "\nChoose one to move(Type 1 for " + player.getWeaponMoveNames()[0]
          + ", 2 for " + player.getWeaponMoveNames()[1] + ")." + ConsoleColors.P);

      int userChoice = input.nextInt();

      // Player's choice of attack
      if (userChoice == 1) {
        System.out.println("You did " + player.getWeaponMoveDamage()[0] + " damage to " + mName + ".\n");
        pWDamage = player.getWeaponMoveDamage()[0];
        monster.subtractHealth(pWDamage);

      } else if (userChoice == 2) {
        System.out.println("You did " + player.getWeaponMoveDamage()[1] + " damage to " + mName + ".\n");
        pWDamage = player.getWeaponMoveDamage()[1];
        monster.subtractHealth(pWDamage);

      } else {
        System.out.println("You did 0 damage to " + mName + ".");

      }

      System.out.println("");

      // Sets the health 0.0 if the health goes to negative numbers.
      if (monster.getHealth() < 0) {
        monster.setHealth(0.0);
      }

      // Prints the monster's health
      System.out
          .println(ConsoleColors.RB + "The " + mName + "'s health is " + monster.getHealth() + "." + ConsoleColors.PB);
      System.out.println("");

      // Checks If the monster's health is 0 and if it is then ends the while loop and
      // gives the player feedback.
      if (monster.getHealth() <= 0) {
        player.addMoney(monster.onKilled());
        System.out
            .println(ConsoleColors.CB + "You have won this fight. Your balance is now " + player.getMoney() + ".\n");
        break;
      }

      // Prints the turn
      System.out.println("It is now the " + mName + " turn to attack you." + ConsoleColors.P);

      // Runs the attack function in the monster class.
      mAttack = monster.attack();

      /*
       * If the value returned by the attack function is 0.17845 then it prints the
       * monster healed else the monster attack the player.
       */
      if (mAttack == 0.17845) {
        System.out.println(mName + " healed it self.");

      } else if (mAttack == 0) {
        System.out.println("You blocked the " + mName + "'s attack.");

      } else {
        player.subtractHealth(monster.attack());

      }

      // Checks If the Player's health is 0 and if it is then ends the while loop and
      // gives the player feedback.
      if (player.getHealth() <= 0) {
        System.out.println("You have lost this fight to " + mName + ". You are dead. \n---GAME OVER---");
        break;
      }

    }

    // Exits the console
    if (player.getHealth() <= 0) {
      System.exit(0);
    }
  }
}