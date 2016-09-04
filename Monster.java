public enum Monster {
  MIMIC ("Mimic", new Stats(10, 5,5), new String[]{"That's no chest!", "The mimic bounces up at you dealing %d damage!", "The frantic chest collapses." }),
  SLIME ("Slime", new Stats(3, 1,1), new String[]{"A wobbly creature jumps in front of you!", "Jumps frantically at you, dealing %d damage.", "The slime dissapates"}),
  SPIDER ("Spider", new Stats(5, 3,2), new String[]{"A spider swings down from above!", "The spider bites you", "The spider dies"});
  public String name;
  public Stats stats;
  public String[] flavors;
  Monster(String name, Stats stats, String[] flavors) {
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