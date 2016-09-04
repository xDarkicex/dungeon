public class Player extends Mob {
  Inventory inventory = new Inventory();
  Player() {
    name = Interaction.get_string("Name your character");
    stats = new Stats(3,3,3);
    flavors = new String[]{ "You steady your weapon.", "You swing wildly dealing %d damage!", "You've died" };
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
