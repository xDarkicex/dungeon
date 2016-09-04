public class Dungeon {
  public int depth = 1;
  public Player player = new Player();
  private Event[] events = new Event[] {
    new StairEvent(),
    new ChestEvent(),
    new MonsterEvent(),
    new TrapEvent(),
    new ItemEvent()
  };
  public void run(){
    Writer.say("Welcome to the dungeon, "+player.name+".");
    if(player.name.equals("Pheonix")) {
      player.stats = new Stats(100,100,100);
      for(int x = 1; x < 1000; x++) { player.inventory.add_item(Item.PHEONIXDOWN); }
    } else if(player.name.equals("Moleman")) {
      depth=100;
      player.stats = new Stats(50,50,50);
      for(int x = 1; x < 1000; x++) { player.inventory.add_item(Item.POTION); }
    }
    while(player.living()) {
      Writer.purple(player.toString());
      Writer.cyan("[Depth "+depth+"] "+FlavorText.story());
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
