public interface Event { public void execute(Dungeon dungeon); }
class ChestEvent implements Event {
  public void execute(Dungeon dungeon) {
    Writer.say(FlavorText.chests[(int)(Math.random()*FlavorText.chests.length)]);
    new Battle(dungeon.player, new Mob(Monster.MIMIC));
  }
}
class StairEvent implements Event {
  public void execute(Dungeon dungeon) {
    boolean direction = (Math.random() < 0.5);
    if(dungeon.depth <= 1) { direction = true; }
    String direction_text = (direction)?"down":"up";
    Writer.say("You come across a staircase leading "+direction_text+".");
    if(Interaction.choose(new String[]{"Go "+direction_text+" the stairs", "Ignore them, continue exploring"}) == 1) {
      dungeon.depth += (direction)?1:-1;
      Writer.say("You follow the stairs... Floor #"+dungeon.depth);
    }
  }
}
class ItemEvent implements Event {
  public void execute(Dungeon dungeon) {
    Writer.say("This is an ItemEvent!");
  }
}
class TrapEvent implements Event {
  public void execute(Dungeon dungeon) {
    String[] trap = FlavorText.trap();
    Writer.red(trap[0]);
    // Safe
    if(Math.random() < 0.25) { Writer.blue(trap[1]); }
    // Hurt
    else if(Math.random() < 0.75) { int damage = 7 * dungeon.player.stats.level; dungeon.player.health -= damage; Writer.red(String.format(trap[2],damage)); }
    // Killed
    else { Writer.red(trap[3]); dungeon.player.kill(); }
  }
}
class MonsterEvent implements Event {
  private static Monster[] monsters = new Monster[] {
    Monster.SLIME,
    Monster.SPIDER
  };
  public void execute(Dungeon dungeon) {
    new Battle(dungeon.player, new Mob(MonsterEvent.monsters[(int)(Math.random()*MonsterEvent.monsters.length)]));
    // dungeon.battle(dungeon.monsters[(int)(Math.random()*dungeon.monsters.length)]);
  }
}
