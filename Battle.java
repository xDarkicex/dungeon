public class Battle {
  Player player;
  Mob monster;
  Battle(Player player, Mob monster) {
    this.player = player;
    this.monster = monster;
    Writer.red(monster.flavors[0][(int)(Math.random()*monster.flavors[0].length)]);
    Writer.purple(player.flavors[0][(int)(Math.random()*player.flavors[0].length)]);
    while(true) {
      Writer.purple(player);
      Writer.red(monster);
      // Player's turn
      int input = Interaction.choose(new String[]{"Attack","Run","Use Potion"});
      if(input == 1) {
        if(player.attack(monster)) { break; }
      } else if(input == 2) {
        Writer.say("You run from the battle!");
        break;
      } else if(input == 3) {
        if(player.inventory.use(Item.POTION)) {
          int max_health = player.stats.max_health();
          int healing = max_health/4 + 1;
          player.health += healing;
          if(player.health >= max_health) { player.health = max_health; }
          Writer.blue("Potion used! +"+healing+" HP!");
        }
        else { Writer.red("You don't have a potion!"); }
      }
      // Monster's turn
      if(monster.attack(player)) { break; }
    }
    if((!monster.living()) && (player.living())) {
      Writer.say(monster.flavors[2][(int)(Math.random()*monster.flavors[2].length)]);
      int xp = monster.stats.total()*monster.stats.level;
      Writer.blue(player.name+" wins! +"+xp+" XP");
      if(player.stats.add_xp(xp)) { Writer.blue("Level up!"); player.heal(); }
    }
  }
}
