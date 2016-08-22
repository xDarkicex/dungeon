public abstract class Event {
  public double chance = 0;
  // What happens when this event is activated
  abstract void execute(Dungeon dungeon);
}

class ChestEvent extends Event {
  public execute(Dungeon dungeon) {
    Writer.say("")
  }
}

class ItemEvent extends Event {
  public execute(Dungeon dungeon) {

  }
}
