// Stats(int constitution, int strength, int intellect, int dextarity, int wisdom, int charisma, int luck)
public enum Monster {
  SLIME ("Slime", new Stats(3,1,1,1,1,1,1), new String[][]{
    {"A wobbly creature jumps in front of you!"},
    {"Jumps frantically at you, dealing %d damage."},
    {"The slime dissapates"}}),
  //RATS
  SICKLYRAT ("Sick Rat", new Stats(1,1,1,1,1,1,1), new String[][]{
    {"Sickly Rat Appears"},
    {"Rat bites you dealing %d damage.", "Tail whip! %d damage."},
    {"Rat triggered a tripwire and died!"}
  }),
  RAT ("Anger Rat", new Stats(3,1,2,1,1,1,1), new String[][]{
    {"Angery rat attacks"},
    {"Rat bites you dealing %d damage.", "Tail whip! %d damage.", "Rat Claws into your leg inflicting %d damage."},
    {"Rat explodes"}
  }),
  LARGERAT ("Large Rat", new Stats(5,3,3,1,1,1,1), new String[][]{
    {"A rat of the top percentile appears"},
    {"HYPER FANG inficting %d damage!", "Rat bites you dealing %d damage.", "Tail whip! %d damage.", "Rat Claws into your leg inflicting %d damage."},
    {"CAAZ DOESNT KNOW HIS MEMES!!!"}
  }),
  SPIDER ("Spider", new Stats(5,3,2,1,1,1,1), new String[][]{
    {"A spider swings down from above!"},
    {"The spider bites you dealing %d damages."},
    {"The spider dies"}});
  public String name;
  public Stats stats;
  public String[][] flavors;
  Monster(String name, Stats stats, String[][] flavors) {
    this.name = name;
    this.stats = stats;
    this.flavors = flavors;
  }
  // MIMIC ("Mimic", "That's no chest!", 5,5,2),
  // SLIME ("Slime", "A wobbly creature jumps in front of you!", 1, 1, 1),
  // BLOATFLY ("Bloat Fly", "a fly buzz's in for the attack", 2,1,1),
  // SPIDER ("Spider", "Large Spider attacks.", 1, 3, 3),
  // LARGESPIDER ("Giant Spider", "Giant spider blocks your path.", 4, 5, 3),
  // VAMPIRE ("Vampire", "Attack from the shadows", 10,10,10),
  // //RATS
  // SICKLYRAT ("Sick Rat", "Sickly rat appears", 1, 1, 1),
  // RAT ("Rat", "Attacked by a Rat", 3, 1, 2),
  // ANGERYRAT ("Angery Rat", "Rabit Rat Jumps at you.", 5, 2, 2),
  // SKELETON ("Skeleton", "A scary spooky skeleton appears!", 3,1,1);
}
