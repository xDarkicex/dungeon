package events;

public static class ChestEvent extends Event {
  public static void execute(Dungeon dungeon) {
    Writer.say("This is a chest event!");
  }
}
