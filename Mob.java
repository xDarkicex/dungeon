public class Mob {
  public int health;
  public String name;
  public Stats stats;
  // flavors = String[]{ "Appearance", "Attack", "Defeat" }
  public String[] flavors;
  Mob() { }
  Mob(Monster monster) {
    name = monster.name;
    stats = monster.stats;
    flavors = monster.flavors;
    stats.set_level(1);
    heal();
  }
  // Return true if leveled up
  public void heal() {
    health = stats.max_health();
    // Writer.say("Healing to "+health);
  }
  public boolean kill() {
    health = 0;
    return true;
  }
  // Return true if enemy dies.
  public boolean attack(Mob defender) {
    int attack = stats.get_attack() - defender.stats.get_defense();
    attack = ((attack<0)?0:attack);
    defender.health -= attack;
    Writer.say(String.format(flavors[1],attack));
    return !defender.living();
  }
  public boolean living() { return health > 0; }
  public String toString() { return "["+name+"] [HP "+health+"/"+stats.max_health()+"]"; }
}
