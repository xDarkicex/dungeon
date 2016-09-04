public class Dungeon {
  public int depth = 1;
  public Player player = new Player();
  private Event[] events = new Event[] {
    new StairEvent(),
    new ChestEvent(),
    new MonsterEvent(),
    new TrapEvent()
  };
  public void run(){
    Writer.say("Welcome to the dungeon, "+player.name+".");
    Writer.say(FlavorText.story_pieces[0]);
    while(player.living()) {
      Writer.purple(player.toString());
      Writer.cyan(FlavorText.story());
      int input = Interaction.choose(new String[]{"Continue","Rest"});
      Writer.clear();
      if(input == 1) { events[(int)(Math.random()*events.length)].execute(this); }
      // TODO: Re-enable this
      else { Writer.yellow("Rest temporarily disabled"); }
    }
    Writer.red(player.name+" has died.");
  }
  public static void main(String args[]){
    while(true){
      (new Dungeon()).run();
      Writer.yellow("Continue?");
      if(Interaction.choose(new String[]{"Yes","No"}) == 2) { break; }
    }
  }
}
