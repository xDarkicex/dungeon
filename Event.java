public abstract class Event {
  public double chance = 0;
  // What happens when this event is activated
  public abstract void execute(Dungeon dungeon);
}
class ChestEvent extends Event {
  public void execute(Dungeon dungeon) {
    Writer.say(FlavorText.chests[(int)(Math.random()*FlavorText.chests.length)]);
    // Mimic!
    if(Math.random() < 0.25) {
      new Battle(dungeon.player, new Mob(Monster.MIMIC));
    }
    // Pheonix Down!
    else if(Math.random() < 70){ Writer.green(FlavorText.potion()); dungeon.player.potion++; dungeon.player.inventory();  }
    else { Writer.green("You find a pheonix down within a chest"); dungeon.player.pheonix++; dungeon.player.inventory(); }
  }
}
class ItemEvent extends Event {
  public void execute(Dungeon dungeon) {
    Writer.say("This is an ItemEvent!");
  }
}
class TrapEvent extends Event {
  public void execute(Dungeon dungeon) {
    String[] trap = FlavorText.trap();
    Writer.red(trap[0]);
    // Safe
    if(Math.random() < 0.25) { Writer.blue(trap[1]); }
    // Hurt
    else if(Math.random() < 0.75) { int damage = 7 * dungeon.player.stats.level; dungeon.player.health -= damage; Writer.red(trap[2]); }
    // Killed
    else { Writer.red(trap[3]); dungeon.player.kill(); }
  }
}
class MonsterEvent extends Event {
  private static Monster[] monsters = new Monster[] {
    Monster.SLIME,
    Monster.SPIDER
  };
  public void execute(Dungeon dungeon) {
    new Battle(dungeon.player, new Mob(MonsterEvent.monsters[(int)(Math.random()*MonsterEvent.monsters.length)]));
    // dungeon.battle(dungeon.monsters[(int)(Math.random()*dungeon.monsters.length)]);
  }
}
