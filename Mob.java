public class Mob {
  public int health;
  public String name;
  public Stats stats;
  public String[] flavors; // String[]{ "Appearance", "Attack", "Defeat" }
  Mob() { }
  Mob(String name, Stats stats, String[] flavors) {
    this.name = name;
    this.stats = stats;
    this.flavors = flavors;
    stats.set_level(1);
    heal();
  }
  Mob(Monster monster) {
    name = monster.name;
    stats = monster.stats;
    flavors = monster.flavors;
    stats.set_level(1);
    heal();
  }
  public void heal() { health = stats.max_health(); }
  public boolean kill() { health = 0; return true; }
  // Return true if enemy dies.
  public boolean attack(Mob defender) {
    int attack = stats.get_attack() - defender.stats.get_defense();
    attack = ((attack<=0)?1:attack);
    defender.health -= attack;
    Writer.say(String.format(flavors[1],attack));
    return !defender.living();
  }
  public boolean living() { return health > 0; }
  public String toString() { return "["+name+"] [HP "+health+"/"+stats.max_health()+"]"; }
}
