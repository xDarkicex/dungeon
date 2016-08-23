package events;

public static class ItemEvent extends Event {
  public static void execute(Dungeon dungeon) {
    Writer.say("This is an ItemEvent!");
  }
}
