public static abstract class Event {
  public double chance = 0;
  // What happens when this event is activated
  abstract void execute(Dungeon dungeon);
}

static class ChestEvent extends Event {
  public execute(Dungeon dungeon) {
    Writer.say("")
  }
}

static class ItemEvent extends Event {
  public execute(Dungeon dungeon) {

  }
}
