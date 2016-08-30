public class Player extends Mob {
  public int potion = (int)(Math.random()*3);
  public int pheonix = 0;
  public int rest = 3;
  public int player_type;

  public void set_player_type(int player_type) {
    this.player_type = player_type; // 1 = human 2 = orc;
  }
  public int get_player_type() {
    return player_type;
  }

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
  public void add_xp(int amount) {
    // This is a Mob method, we're overriding it though!
    int previous_level = level;
    // Let's call the original add_xp method, and give it the amount of XP we're gaining.
    super.add_xp(amount);
    // Now let's check if we leveled up.
    if(previous_level < level) {
      // We did! Reset rest.
      rest = 3;
    }
  }
  public void rest() {
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

  public String toString() {
    // This is a default method that all Java objects have! We're overriding it.
    return "Player: [Level "+level+"] [HP "+health+"/"+get_max_health()+"] [Potions "+potion+"] [Pheonix Downs "+pheonix+"] [Rests "+rest+"]";
  }
}
