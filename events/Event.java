package events;

public static abstract class Event {
  public double chance = 0;
  // What happens when this event is activated
  public static abstract void execute(Dungeon dungeon);
}
