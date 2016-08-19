// import java.util.ArrayList;
// import java.util.Arrays;
import java.io.Console;
import java.io.PrintStream;


public class Dungeon {
  // Actual instance of the Game
  private Console console = System.console();
  private Player player = new Player();
  private Mob.Monster enemy;
  private Mob.Monster[] monsters = new Mob.Monster[]{
    Mob.Monster.SLIME,
    Mob.Monster.SKELETON
  };
  // Main game code
  public void run(){
    Writer.say("Welcome to the dungeon.");
    Writer.say("\n\n\n\n\n\n\n\n\n");
    Writer.say(FlavorText.story_pieces[0]);
    // Main game loop.
    while(player.health > 0) {
      String s = console.readLine();
      //player stats block
      Writer.blue("Player: Stats\n"+"Level: ["+player.level+"]");
      Writer.blue("Health: [HP "+player.health+"/"+player.get_max_health()+"]");
      Writer.cyan(FlavorText.story_pieces[(int)(Math.random()*FlavorText.story_pieces.length)]);
      //end
      int input = -1;
      while(input == -1){
        try {
          Writer.yellow("[1: Continue] [2: Rest]");
          input = Integer.parseInt(console.readLine());
        } catch(NumberFormatException e) {
          Writer.red("You've got to input a valid number");
        }
        if((input < 1) || (input > 2)) {
          Writer.red("That's not an option! 1-2 please.");
          input = -1;
        }
      }
      switch(input) {
        case 1:
          double chance = Math.random();

          // Monster spawn!
          if(chance < .50) { battle(monsters[(int)(Math.random()*monsters.length)]); }

          // Health Potion!
          else if(chance < .75) { Writer.green(FlavorText.potion()); player.potion++; player.inventory(); }

          // Chest!
          else if(chance < .90) {
            Writer.say(FlavorText.chests[(int)(Math.random()*FlavorText.chests.length)]);
            // Mimic!
            if(Math.random() < 0.25) { battle(Mob.Monster.MIMIC); }
            // Pheonix Down!
            else if(Math.random() < 70){ Writer.green(FlavorText.potion()); player.potion++; player.inventory();  }
            else { Writer.green("You find a pheonix down within a chest"); player.pheonix++; player.inventory(); }
          }
          // Trap!
          else {
            String[] trap = FlavorText.trap();
            Writer.red(trap[0]);
            // Safe
            if(Math.random() < 0.25) { Writer.blue(trap[1]); }
            // Hurt
            else if(Math.random() < 0.75) { int damage = 7 * player.level; player.health -= damage; Writer.red(trap[2]); }
            // Killed
            else { Writer.red(trap[3]); player.kill(); }
          }
          break;
          // rest
        case 2:
          // Writer.yellow("Rested");
          player.rest();
          break;
      }
    }
  }

  // Start a battle with enemy
  public void battle(Mob.Monster e) {
    // Set the game's enemy to e. This way we can access it outside of this function easier.
    enemy = e;
    // Make sure the enemy is healed, these are reused to save memory.
    // set_level will automatically heal them, it's like leveling up.
    enemy.set_level(player.level);
    // Flavor text!
    Writer.red(enemy.description);
    while((enemy.mob.health > 0) && (player.health > 0)) {
      Writer.blue("You: [HP "+player.health+"/"+player.get_max_health()+"]");
      Writer.red(enemy.name + ": [HP "+enemy.mob.health+"/"+enemy.mob.get_max_health()+"]");
      player_turn();
      if(enemy.mob.health <= 0) { break; }
      enemy_turn();
      if(player.health <= 0) { player.kill(); }
    }
    // finalize stuff!
    if(player.health > 0) {
      int xp_gained = 1 + enemy.mob.level + (int)Math.floor(Math.random()*25);
      Writer.green("Victory! [+"+xp_gained+" XP]");
      // You're still alive
      int previous_level = player.level;
      player.add_xp(xp_gained);
      if(player.level > previous_level) {
        // You leveled up
        Writer.green(FlavorText.level_up[(int)(Math.random()*FlavorText.level_up.length)]+"[Player level: "+player.level+"]");
      }
    }
  }
  // Player turn!
  public void player_turn() {
    int input = -1;
    while(input == -1){
      try {
        Writer.yellow("[1: Attack] [2: Run]"+((player.potion>0)? " [3: Potion ("+player.potion+" left)]" : ""));
        input = Integer.parseInt(console.readLine());
      } catch(NumberFormatException e) {
        Writer.red("You've got to input a valid number");
      }
      if((input < 1) || (input > 3)) {
        Writer.red("That's not an option! 1-3 please.");
        input = -1;
      }
    }
    // At this point, we should have a valid option.
    switch(input) {
      // Attack
      case 1:
        int damage = player.get_attack();
        enemy.mob.health -= damage;
        Writer.blue(FlavorText.attack_unarmed[(int)(Math.random()*FlavorText.attack_unarmed.length)]+" "+damage+" damage!");

        break;
      // Run!
      case 2:
        Writer.red(FlavorText.run_away[(int)(Math.random()*FlavorText.run_away.length)]);
        break;
      // Potion!
      case 3:
        player.use_potion();
        break;
    }
  }
  public void enemy_turn(){
    int damage = enemy.get_attack();
    player.health -= damage;
    Writer.red("The "+enemy.name+" attacks dealing "+damage+" damage!");
  }
  // Static bullshit
  private static Dungeon game = new Dungeon();
  public static void main(String args[]){ game.run(); }
}
