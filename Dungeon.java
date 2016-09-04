// import java.util.ArrayList;
// import java.util.Arrays;
import java.io.Console;
import java.io.PrintStream;

public class Dungeon {
  public Player player = new Player();
  private Event[] events = new Event[] {
    new ChestEvent(),
    new MonsterEvent(),
    new TrapEvent()
  };
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
      // TODO: Re-enable this
      else { Writer.yellow("Rest temporarily disabled"); }
    }
  }

  public static void main(String args[]){
    while(true){
      (new Dungeon()).run();
      Writer.yellow("Continue?");
      if(Interaction.choose(new String[]{"Yes","No"}) == 2) { break; }
    }
  }
}
