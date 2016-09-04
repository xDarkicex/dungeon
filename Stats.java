public class Stats {
  public int level;
  private int vitality, attack, defense, xp;
  Stats(int level) {
    // Random roll via level
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
    if(this.xp > (50*level)) { set_level(level+1); return true; }
    return false;
  }
  public void set_level(int level) { this.level = level; }
  public int get_attack() { return (int)(0.02*Math.pow((double)level,2.0)+(double)level+2.0*((double)attack)); }
  public int get_defense() { return (int)(0.01*Math.pow((double)level,2.0)+(double)level+1.0*((double)defense)); }
  public int max_health() { return (int)(0.01*Math.pow((double)level,2.0)+(double)level+10.0*((double)vitality/2.0)); }
  public int total() { return vitality+attack+defense+level; }
}
