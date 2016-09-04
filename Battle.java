public class Battle {
  Player player;
  Mob monster;
  Battle(Player player, Mob monster) {
    this.player = player;
    this.monster = monster;
    Writer.red(monster.flavors[0][(int)(Math.random()*monster.flavors[0].length)]);
    Writer.purple(player.flavors[0][(int)(Math.random()*player.flavors[0].length)]);
    Writer.purple(player);
    Writer.red(monster);
    while(true) {
      // Player's turn
      int input = Interaction.choose(new String[]{"Attack","Run"});
      if(input == 1) {
        if(player.attack(monster)) { break; }
      }
      if(input == 2) {
        Writer.say("You run from the battle!");
        break;
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
