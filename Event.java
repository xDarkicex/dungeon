public interface Event { public void execute(Dungeon dungeon); }
class ChestEvent implements Event {
  public void execute(Dungeon dungeon) {
    Writer.say(FlavorText.chests[(int)(Math.random()*FlavorText.chests.length)]);
    if(Interaction.choose(new String[]{"Open It", "Leave it alone"}) == 1) {
      if(Math.random() < 0.5) {
        Mob mimic = new Mob("Mimic", new Stats(10,10,10,10,10,10,10), new String[][]{{"That's no chest!"}, {"The mimic bounces up at you dealing %d damage!", "Mimic Sucks your soul dry, dealing %d damage!"}, {"The frantic chest collapses."} });
        mimic.stats.set_level(dungeon.depth*2);
        mimic.heal();
        new Battle(dungeon.player, mimic);
      }
      else {
        Item item = Item.values()[(int)(Math.random()*Item.values().length)];
        Writer.blue("You open it up and find a "+item.name+" inside!");
        dungeon.player.inventory.add_item(item);
      }
    }
    else {
      Writer.say("You decide to leave the chest behind.");
    }
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
      Writer.say("You follow the stairs... Floor "+dungeon.depth);
    }
  }
}
class ItemEvent implements Event {
  public void execute(Dungeon dungeon) {
    Item item = Item.values()[(int)(Math.random()*Item.values().length)];
    Writer.blue("You found a "+item.name+" lying on the floor!");
    dungeon.player.inventory.add_item(item);
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
  public void execute(Dungeon dungeon) {
    Mob monster = new Mob( Monster.values()[(int)(Math.random()*Monster.values().length)]);
    monster.stats.set_level(dungeon.depth);
    monster.heal();
    new Battle(dungeon.player, monster );

    }
}
