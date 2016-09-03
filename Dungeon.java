// import java.util.ArrayList;
// import java.util.Arrays;
import java.io.Console;
import java.io.PrintStream;

public class Dungeon {
  // Actual instance of the Game
  private Console console = System.console();
  public Player player = new Player();
  private Event[] events = new Event[] {
    new ChestEvent(),
    new ItemEvent(),
    new MonsterEvent(),
    new TrapEvent()
  };
  private Mob.Monster enemy;
  public Mob.Monster[] monsters = new Mob.Monster[]{
    Mob.Monster.SLIME,
    Mob.Monster.SKELETON,
    Mob.Monster.VAMPIRE,
    Mob.Monster.SICKLYRAT,
    Mob.Monster.RAT,
    Mob.Monster.BLOATFLY,
    Mob.Monster.SPIDER,
    Mob.Monster.LARGESPIDER,
    Mob.Monster.ANGERYRAT
  };
  // Main game code

  public void run(){
    Writer.clear();
    // Get player race
    Writer.say("Build Adventurer, Select Race: ");
    int user_selection = Interaction.choose(FlavorText.player_race);
    // Set the player_race
    player.set_player_race(user_selection-1);
    // Welcome the user adrians thing >> FlavorText.player_type[player.get_player_type()]
    Writer.say("Welcome to the dungeon!");
    Writer.say(FlavorText.story_pieces[0]);
    // Main game loop.
    while(player.health > 0) {
      // String s = console.readLine();
      Writer.purple(player.toString());
      Writer.cyan(FlavorText.story());
      int input = Interaction.choose(new String[]{"Continue","Rest"});
      Writer.clear();
      if(input == 1) { events[(int)(Math.random()*events.length)].execute(this); }
      else { player.rest(); }
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

    int input = Interaction.choose(new String[]{"Attack","Run","Potion ("+player.potion+" left)"});
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
  public static void main(String args[]){
    game.run();
    while(true){
      Writer.yellow("Continue?");
      int input = Interaction.choose(new String[]{"Yes","No"});

      switch(input) {
      // read cards
      case 1:
        game = new Dungeon();
        game.run();
      break;
      // reenter values
      case 2:
      break;
      }
      break;
    }
  }

}
