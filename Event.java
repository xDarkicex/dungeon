public interface Event { public void execute(Dungeon dungeon); }
class ChestEvent implements Event {
  public void execute(Dungeon dungeon) {
    Writer.say(FlavorText.chests[(int)(Math.random()*FlavorText.chests.length)]);
    new Battle(dungeon.player, new Mob(Monster.MIMIC));
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
