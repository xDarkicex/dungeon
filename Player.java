public class Player extends Mob {
  // public int potion = (int)(Math.random()*3);
  // public int pheonix = 2;
  // public int rest = 3;
  Player() {
    name = "Player";
    stats = new Stats(3,3,3);
    flavors = new String[]{ "You steady your weapon.", "You swing wildly dealing %d damage!", "You've died" };
    stats.set_level(1);
    heal();
  }
  // public void inventory() { Writer.say("You have "+this.potion+" potions and "+this.pheonix+" pheonix downs."); }
  // public boolean kill() {
  //   if(this.pheonix > 0) {
  //     Writer.blue("You narrowly escape death thanks to your pheonix down.");
  //     this.pheonix--;
  //     heal();
  //     inventory();
  //     return false;
  //   }
  //   else {
  //     Writer.red("You've died. Game over.");
  //     this.health = 0;
  //     return true;
  //   }
  // }
}
