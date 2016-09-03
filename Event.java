public abstract class Event {
  public double chance = 0;
  // What happens when this event is activated
  public abstract void execute(Dungeon dungeon);
}
class ChestEvent extends Event {
  public void execute(Dungeon dungeon) {
    Writer.say(FlavorText.chests[(int)(Math.random()*FlavorText.chests.length)]);
    // Mimic!
    if(Math.random() < 0.25) { dungeon.battle(Mob.Monster.MIMIC); }
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
class MonsterEvent extends Event {
  public void execute(Dungeon dungeon) {
    dungeon.battle(dungeon.monsters[(int)(Math.random()*dungeon.monsters.length)]);
  }
}
class TrapEvent extends Event {
  public void execute(Dungeon dungeon) {
    String[] trap = FlavorText.trap();
    Writer.red(trap[0]);
    // Safe
    if(Math.random() < 0.25) { Writer.blue(trap[1]); }
    // Hurt
    else if(Math.random() < 0.75) { int damage = 7 * dungeon.player.level; dungeon.player.health -= damage; Writer.red(trap[2]); }
    // Killed
    else { Writer.red(trap[3]); dungeon.player.kill(); }
  }
}
