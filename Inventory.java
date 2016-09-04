public class Inventory {
  class Slot {
    public int quantity = 0;
    public Item item;
    Slot(Item item) { this.item = item; }
  }
  // TODO: Turn this into an arraylist.
  public Slot[] slots = new Slot[] {
    new Slot(Item.POTION),
    new Slot(Item.PHEONIXDOWN),
  };
  Inventory() { }
  public boolean use(Item item) {
    for(Slot slot : slots) {
      if((slot.item.equals(item)) && (slot.quantity > 0)) {
        slot.quantity--;
        return true;
      }
    }
    return false;
  }
  public void add_item(Item item) {
    for(Slot slot : slots) { if(slot.item.equals(item)) { slot.quantity++; break; } }
  }
  public String toString() {
    String s = "";
    for(Slot slot : slots) { if(slot.quantity > 0) { s+="["+slot.item.name+" x"+slot.quantity+"] "; } }
    return s;
  }
}
enum Item {
  POTION("Potion"),
  PHEONIXDOWN("Pheonix Down");
  public String name;
  Item(String name) {
    this.name = name;
  }
}
