
class Player extends Mob {
  public int potion = (int)Math.floor(Math.random()*3);
  public int pheonix = 0;
  public int rest = 3;
  // Player() { System.out.println("Player created"); }
  public void use_potion() {
    if(potion > 0) {
      potion--;
      int boost = 5 + (int)((double)level * 1.2);
      health += boost;
      Writer.blue("You used a potion! +"+boost+" HP!");
      if (health > get_max_health()) { heal(); }
    }
    else { Writer.say("You don't have a potion to use!"); }
  }

  public void rest(){
    if(rest > 0){
      rest--;
      int boost = 10 + (int)((double)level * 1.5);
      health += boost;
      Writer.blue("You are well rested! +"+boost+" HP!");
      if (health > get_max_health()) { heal(); }
    }
    else { Writer.say("You Cant Rest just yet!"); }
  }
  public void inventory() {
    Writer.say("You have "+this.potion+" potions and "+this.pheonix+" pheonix downs.");
  }
  public boolean kill() {
    if(this.pheonix > 0) {
      Writer.blue("You narrowly escape death thanks to your pheonix down.");
      this.pheonix--;
      heal();
      inventory();
      return false;
    }
    else {
      Writer.red("You've died. Game over.");
      this.health = 0;
      return true;
    }
  }
}
