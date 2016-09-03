// import java.util.ArrayList;
// import java.util.Arrays;
import java.io.Console;
import java.io.PrintStream;

public class Dungeon {
  public Player player = new Player();
  // private Mob enemy;
  private Event[] events = new Event[] {
    new ChestEvent(),
    // new ItemEvent(),
    new MonsterEvent(),
    new TrapEvent()
  };
  // Main game code
  public void run(){
    Writer.clear();
    Writer.say("Welcome to the dungeon!");
    Writer.say(FlavorText.story_pieces[0]);
    while(player.health > 0) {
      Writer.purple(player.toString());
      Writer.cyan(FlavorText.story());
      int input = Interaction.choose(new String[]{"Continue","Rest"});
      Writer.clear();
      if(input == 1) { events[(int)(Math.random()*events.length)].execute(this); }
      else {
        Writer.yellow("Rest temporarily disabled");
        // player.rest();
      }
    }
  }
  // Static bullshit
  private static Dungeon game;
  public static void main(String args[]){
    // game.run();
    while(true){
      game = new Dungeon();
      game.run();
      Writer.yellow("Continue?");
      if(Interaction.choose(new String[]{"Yes","No"}) == 1) { continue; }
      else { break; }
    }
  }
}
