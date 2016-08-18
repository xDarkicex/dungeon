// import java.util.ArrayList;
// import java.util.Arrays;
import java.io.Console;
import java.io.PrintStream;

public class Dungeon {
  private static Game game = new Game();
  public static void main(String args[]){ game.run(); }
}
class Game {
  private Mob.Monster[] monsters = new Mob.Monster[]{
    Mob.Monster.SLIME,
    Mob.Monster.SKELETON
  };
  private String[][] trap_text = new String[][] {
    {
      "You trigger a tripwire",
      "Luckily, you fell causing an arrow to fly above your head",
      "You took an arrow to the knee!",
      "The arrow pierced your heart, killing you."
    },{
      "You Trigger a guillitine",
      "Thinking quickly you grab the shield of a fallen adventure, shielding yourself from near death.",
      "You try to dodge the massive blade, but it chops your right toe off.",
      "The Blade comes crushing down with intense speed slicing your head off, you see your body fall as the blood leaves your brain."
    },{
      "You Step on a pressure plate",
      "You take your foot away slowly, to your amazement, the plate does nothing the trap is broken",
      "The trap springs to life, but the spikes within this ancient trap have long since dulled.",
      "The room imediately bursts into flames."
    }
  };
  private String[] chest_text = new String[]{
    "You find a glorious chest, overflowing with gold coins.",
    "You spot a rickety old chest.",
    "You spot a boarded up cave, inside you see a plain box",
    "Inside a spider web their is a red box with a dragon inscribed on it.",
    "You spot a Chest.",
    "You spot a case.",
    "You spot a box.",
    "You spot a plain box, but get an overwhelming feeling of its importance.",
    "You spot a moss covered chest",
    "You spot a silver Chest.",
    "You spot a golden chest.",
    "You spot a bronze chest.",
    "You spot ye old chest",
    "you spot Black Birds Chest, sadly it feels empty and full of empty promises",
    "You spot prolevels chest, it feels smooth to the touch, Its said to be made of game fibers, but a steamboat captain told you that its really just cotton.",
    "You spot a chest made of pure gold, which has the cross of thy lord inscribed on it."
  };
  private String[] potion_text = new String[]{
    "You picked up a potion from a dead adventurer",
    "You find a rusty board, on futher inspection you see it that if is hiding a... *** ** POTION ** ***",
    "You find a potion, at the base of a Whomping Willow.",
    "You find a potion in the wrackage of a horseless Carriage.",
    "A man in the Shadows, gives you a potion, only to disapear before you can reply.",
    "You find a potion at an abandoned campsite",
    "You find a potion behind a rock",
    "You fiind a potion inside a creepy alter",
    "You find a potion under your pillow",
    "You find a potion in a babbling brook",
    "You found a potion in an old chest.",
    "You pick up a potion from the cold dead hands of your mothers ghost made real.",
    "You are made to endure the trial of nine, you are rewarded with a potion.. oh.. joy.."
  };
  private Player player = new Player();
  private Mob.Monster enemy;
  private Console console;
  // private PrintStream out = System.out;
  Game() { }
  public void puts(Object string) { System.out.println(string); }
  public void run(){
    console = System.console();
    while(player.health > 0) {
      puts("You take a step in the dungeon...");
      int chance = (int)Math.floor(Math.random()*100);
      puts(chance);
      if(chance < 50) {
        // Monster
        puts("Monster's aren't added yet.");
        Mob.Monster monster = Mob.Monster.SLIME;
        puts(monster);
      }
      else if(chance < 80) {
        // Health Potion
        puts(potion_text[(int)(Math.random()*potion_text.length)]);
        player.potion++;
        player.inventory();
      }
      else if(chance < 98) {
        puts(chest_text[(int)(Math.random()*chest_text.length)]);
        if(Math.random() < 0.5) {
          // Mimic!
          battle(Mob.Monster.MIMIC);
        }
        else {
          // Pheonix Down!
          puts("You find a pheonix down within a chest");
          player.pheonix++;
          player.inventory();
        }
      }
      else {
        // Insta-death
        String[] trap = trap_text[(int)(Math.random()*trap_text.length)];
        puts(trap[0]);
        if(Math.random() < 0.25) {
          //
          puts(trap[1]);
        }
        else if(Math.random() < 0.75) {
          // Hurt
          int damage = 7 * player.level;
          player.health -= damage;
          puts(trap[2]);

        }
        else { puts(trap[3]); player.kill(); }
      }
      String s = console.readLine();
    }
  }
  // Battle Mechanics
  public void battle(Mob.Monster enemy) {
    // Make sure the enemy is healed, these are reused to save memory.
    // set_level will automatically heal them, it's like leveling up.
    enemy.set_level(player.level);
    // Flavor text!
    puts(enemy.description);
    while((enemy.mob.health > 0) && (player.health > 0)) {
      puts("You: [HP "+player.health+"/"+player.get_max_health()+"]");
      puts(enemy.name + ": [HP "+enemy.mob.health+"/"+enemy.mob.get_max_health()+"]");
      player_turn(enemy);
      // monster_turn
    }
    // finalize stuff!
    if(player.health > 0) {
      int xp_gained = 1 + enemy.mob.level + (int)Math.floor(Math.random()*25);
      puts("Victory! [+"+xp_gained+" XP]");
      // You're still alive
      int previous_level = player.level;
      player.add_xp(xp_gained);
      if(player.level > previous_level) {
        // You leveled up
        puts("** **** Congrats! You leveled up! **** **");
      }
    }
    // set_xp(){
    //   player.set_xp = (int) 10
    // }
  }
  public void player_turn(Mob.Monster enemy) {
    int input = -1;
    while(input == -1){
      try {
        puts("[1: Attack] [2: Run]"+((player.potion>0)? " [3: Potion ("+player.potion+" left)]" : ""));
        input = Integer.parseInt(console.readLine());
      } catch(NumberFormatException e) {
        puts("You've got to input a valid number");
      }
      if((input < 1) || (input > 3)) {
        puts("That's not an option! 1-3 please.");
        input = -1;
      }
    }
    // At this point, we should have a valid option.
    switch(input) {
      case 1:
        // Attack
        // puts((enemy.mob.health) && (player.mob.health);
        enemy.mob.health -= player.get_attack();
        break;
      case 2:
        // Run!
        puts("Can't run!");
        break;
      case 3:
        // Potion!
        player.use_potion();
        break;
    }

  }
}
class Player extends Mob {
  public int potion = 2;
  public int pheonix = 0;
  Player() {
    System.out.println("Player created");
  }
  public void use_potion() {
    if(potion > 0) {
      potion--;
      int boost = 5 + (int)((double)level * 1.2);
      health += boost;
      System.out.println("You used a potion! +"+boost+" HP!");
      if (health > get_max_health()) { heal(); }
    }
    else {
      System.out.println("You don't have a potion to use!");
    }
  }
  public void inventory() {
    System.out.println("You have "+this.potion+" potions and "+this.pheonix+" pheonix downs.");
  }
  public boolean kill() {
    if(this.pheonix > 0) {
      System.out.println("You narrowly escape death thanks to your pheonix down.");
      this.pheonix--;
      heal();
      inventory();
      return false;
    }
    else {
      System.out.println("You've died. Game over.");
      this.health = 0;
      return true;
    }
  }
}
