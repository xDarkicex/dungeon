class Mob {
  public enum Monster {
    MIMIC ("Mimic", "That's no chest!", 5,5,2),
    SLIME ("Slime", "A wobbly creature jumps in front of you!", 1, 1, 1),
    VAMPIRE ("Vampire", "Attack from the shadows", 10,10,10),
    SKELETON ("Skeleton", "A scary spooky skeleton appears!", 3,1,1);
    public String name;
    public String description;
    public Mob mob;
    Monster(String name, String description, int base_attack, int base_defense, int base_health) {
      System.out.println("Monster created");
      this.name = name;
      this.description = description;
      this.mob = new Mob(base_attack,base_defense,base_health);
    }
    // enemy.mob.health
    void heal() { mob.heal(); }
    void set_level(int level) { mob.set_level(level); }
    int get_attack() { return mob.get_attack(); }
  }
  // Mob variables
  public int maxHealth;
  public int health;
  public int level = 1;
  public int xp = 0;
  private int base_attack = 1;
  private int base_defense = 1;
  private int base_health = 10;
  Mob() { System.out.println("Living thing created!"); heal(); }
  Mob(int base_attack, int base_defense, int base_health) {
    // System.out.println("Monster created");
    // this.name = name;
    // this.description = description;
    set_base_attack(base_attack);
    set_base_defense(base_defense);
    set_base_health(base_health);
    // set_level(level);
  }
  public void add_xp(int xp) {
    this.xp += xp;
    if(this.xp > (100*level)) {
      set_level(level+1);

    }
  }
  public void set_level(int level) { this.level = level; heal(); }
  public void set_base_attack(int base_attack) { this.base_attack = base_attack; }
  public void set_base_defense(int base_defense) { this.base_defense = base_defense; }
  public void set_base_health(int base_health) { this.base_health = base_health; }

  public int get_attack(){ return 1 + (int)((double)base_attack * (double)level * 0.5); }
  public int get_max_health() { return 1 + (int)((double)level * (double)base_health * 1.5); }
  // (type)variable
  // This is how you cast. Casting basically just moves one type to another.
  // int 5 -> double 5.0
  // 5 * 1.5
  public void heal() { health = get_max_health(); }
  // int = 5
  // double 1.5
  // float 1.5f
}
