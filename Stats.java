public class Stats {
  public int level;
  private int vitality, attack, defense, xp;
  // private int vitality = 0;
  // private int attack = 0;
  // private int defense = 0;
  // private int speed = 0;
  // Random roll by level.
  Stats(int level) {
    // Start with 5 points, gain 1 point every level
    int points = 5 + level;
    for(int i = 0; i < points; i++) {
      int roll = (int)(Math.random() * 3);
      switch(roll) {
        case 0: vitality++; break;
        case 1: attack++; break;
        case 2: defense++; break;
      }
    }
  }
  Stats(int vit, int atk, int def) {
    vitality = vit;
    attack = atk;
    defense = def;
  }
  public boolean add_xp(int xp) {
    this.xp += xp;
    if(this.xp > (100*level)) { set_level(level+1); return true; }
    return false;
  }
  public int get_attack() { return (int)(Math.pow((double)attack,2.0) + (double)(attack*level) + Math.pow((double)level,2.0)); }
  public int get_defense() { return (int)(Math.pow((double)defense,2.0) + (double)(defense*level) + Math.pow((double)level,2.0)); }
  public void set_level(int level) { this.level = level; }
  public int max_health() { return vitality*(int)((level+1)/2); }
  public int total() { return vitality+attack+defense+level; }
}
