public class Stats {
  public int level = 1;
  public int constitution, strength, intellect, dexterity, wisdom, charisma, luck, xp;
  Stats(int level) {
    // Random roll via level
    // Start with 5 points, gain 1 point every level
    int points = 5 + level;
    //wisdom will give user hints on if its a trap or a goodie
    for(int i = 0; i < points; i++) {
      int roll = (int)(Math.random() * 3);
      switch(roll) {
        case 0: constitution++; break;
        case 1: strength++; break;
        case 2: intellect++; break;
        case 3: dexterity++; break;
        case 4: wisdom++; break;
        case 5: charisma++; break;
        case 6: luck++; break;

      }
    }
  }
  Stats(int con, int str, int intel, int dex, int wis, int cha, int luck) {
    constitution = con;
    strength = str;
    intellect = intel;
    dexterity = dex;
    wisdom = wis;
    charisma = cha;
    luck = luck;
  }
  public boolean add_xp(int xp) {
    this.xp += xp;
    if(this.xp > (50*level)) { set_level(level+1); return true; }
    return false;
  }
  public void set_level(int level) { this.level = level; }
  public int get_attack() { return (int)(0.02*Math.pow((double)level,2.0)+(double)level+2.0*((double)strength)); }
  public int get_defense() { return (int)(0.01*Math.pow((double)level,2.0)+(double)level+1.0*((double)constitution)); }
  public int max_health() { return (int)(0.01*Math.pow((double)level,2.0)+(double)level+10.0*((double)constitution/2.0)); }
  public int total() { return constitution+strength+intellect+dexterity+wisdom+charisma+level; }
}
