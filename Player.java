public class Player extends Mob {
  Player() {
    name = Interaction.get_string("Name your character");
    stats = new Stats(3,3,3);
    flavors = new String[]{ "You steady your weapon.", "You swing wildly dealing %d damage!", "You've died" };
    stats.set_level(1);
    heal();
  }
}
