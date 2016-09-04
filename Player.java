public class Player extends Mob {
  Inventory inventory = new Inventory();
  Player() {
    name = Interaction.get_string("Name your character");
    stats = new Stats(10,5,5);
    if(name.equals("Pheonix")) {
      stats = new Stats(100,100,100);
      for(int x = 1; x < 1000; x++) { inventory.add_item(Item.PHEONIXDOWN); }
    }
    flavors = new String[][]{ {"You Square up; focusing your mind on the enemy, lets hope you paid attention in your karate classes!"}, {
      "You flail wildly damaging the opponent for %d damage.",
      "Fist clentched, you throw a punch directly for the dick. %d ddamage!",
      "Twisting wildly you poke your enemy dealing %d damage.",
      "Grabbing for anything near by, you find a stick, it breaks as you bring it crashing down on your foes skull. %d damage!"
    },{"You've died"}};
    stats.set_level(1);
    heal();
  }
  public boolean living() {
    if(!super.living()) {
      if(inventory.use(Item.PHEONIXDOWN)) {
        Writer.say("Thankfully you had a pheonix down on you to live another day.");
        heal();
        return true;
      }
      return false;
    }
    return true;
  }
  public String toString() {
    return super.toString()+" "+inventory.toString();
  }
}
