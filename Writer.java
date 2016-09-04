public class Writer {
  public static final String RESET = "\u001B[0m";
  public static final String BLACK = "\u001B[30m";
  public static final String RED = "\u001B[31m";
  public static final String GREEN = "\u001B[32m";
  public static final String YELLOW = "\u001B[33m";
  public static final String BLUE = "\u001B[34m";
  public static final String PURPLE = "\u001B[35m";
  public static final String CYAN = "\u001B[36m";
  public static final String WHITE = "\u001B[37m";
  public static final void clear() { System.out.print("\033[H\033[2J"); System.out.flush(); }
  public static final void write(String string, String color, boolean with_color, boolean new_line) {
    if(new_line) { string += "\n"; }
    for(char c : string.toCharArray()) {
      if(with_color) { System.out.print(color+c+RESET); }
      else { System.out.print(c); }
      try { Thread.sleep(5); }
      catch(InterruptedException e) { }
    }
  }
  public static final void say(Object obj) { write(obj.toString(),"",false,true); }
  // Color helper
  public static final void with(Object obj, String color) { Writer.write(obj.toString(),color,true,true); }
  public static final void with_no_nl(Object obj, String color) { Writer.write(obj.toString(),color,true,false); }
  // Colors!
  public static final void red(Object o) { Writer.with(o,RED); }
  public static final void green(Object o) { Writer.with(o,GREEN); }
  public static final void blue(Object o) { Writer.with(o,BLUE); }
  public static final void yellow(Object o) { Writer.with(o,YELLOW); }
  public static final void purple(Object o) { Writer.with(o,PURPLE); }
  public static final void cyan(Object o) { Writer.with(o,CYAN); }
  // Aliases to make life interesting
  public static final void debug(Object o) { Writer.yellow(o); }
}
